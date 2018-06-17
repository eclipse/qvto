/*******************************************************************************
 * Copyright (c) 2013 S. Boyko and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *   
 * Contributors:
 *     Sergey Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline;

import java.util.Vector;

/**
 * A string pattern matcher. Supports '*' and '?' wildcards.
 */
public class StringMatcher {
    protected static final char SINGLE_WILDCARD= '\u0000';

    protected String myPattern;
    protected int myLength; // pattern length
    protected boolean isIgnoreWildCards;
    protected boolean isIgnoreCase;
    protected boolean hasLeadingStar;
    protected boolean hasTrailingStar;
    protected String mySegments[]; //the given pattern is split into * separated segments

    /* boundary value beyond which we don't need to search in the text */
    protected int myBound = 0;
    
    public static class Position {
        int start; //inclusive
        int end; //exclusive
        public Position(int start, int end) {
            this.start= start;
            this.end= end;
        }
        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }
    }
    /**
     * StringMatcher constructor takes in a String object that is a simple 
     * pattern. The pattern may contain '*' for 0 and many characters and
     * '?' for exactly one character.  
     *
     * Literal '*' and '?' characters must be escaped in the pattern 
     * e.g., "\*" means literal "*", etc.
     *
     * Escaping any other character (including the escape character itself), 
     * just results in that character in the pattern.
     * e.g., "\a" means "a" and "\\" means "\"
     *
     * If invoking the StringMatcher with string literals in Java, don't forget
     * escape characters are represented by "\\".
     *
     * @param pattern the pattern to match text against
     * @param ignoreCase if true, case is ignored
     * @param ignoreWildCards if true, wild cards and their escape sequences are ignored
     *        (everything is taken literally).
     */
    public StringMatcher(String pattern, boolean ignoreCase, boolean ignoreWildCards) {
        if (pattern == null)
            throw new IllegalArgumentException();
        isIgnoreCase= ignoreCase;
        isIgnoreWildCards= ignoreWildCards;
        myPattern= pattern;
        myLength= pattern.length();
        
        if (isIgnoreWildCards) {
            parseNoWildCards();
        } else {
            parseWildCards();
        }
    }
    /**
     * Find the first occurrence of the pattern between <code>start</code)(inclusive) 
     * and <code>end</code>(exclusive).  
     * @param text the String object to search in 
     * @param start the starting index of the search range, inclusive
     * @param end the ending index of the search range, exclusive
     * @return an <code>StringMatcher.Position</code> object that keeps the starting 
     * (inclusive) and ending positions (exclusive) of the first occurrence of the 
     * pattern in the specified range of the text; return null if not found or subtext
     * is empty (start==end). A pair of zeros is returned if pattern is empty string
     * Note that for pattern like "*abc*" with leading and trailing stars, position of "abc"
     * is returned. For a pattern like"*??*" in text "abcdf", (1,3) is returned
     */
    public StringMatcher.Position find(String text, int start, int end) {
        if (text == null)
            throw new IllegalArgumentException();
            
        int tlen= text.length();
        if (start < 0)
            start= 0;
        if (end > tlen)
            end= tlen;
        if (end < 0 ||start >= end )
            return null;
        if (myLength == 0)
            return new Position(start, start);
        if (isIgnoreWildCards) {
            int x= posIn(text, start, end);
            if (x < 0)
                return null;
            return new Position(x, x+myLength);
        }

        int segCount= mySegments.length;
        if (segCount == 0)//pattern contains only '*'(s)
            return new Position (start, end);
                    
        int curPos= start;
        int matchStart= -1;
        int i;
        for (i= 0; i < segCount && curPos < end; ++i) {
            String current= mySegments[i];
            int nextMatch= regExpPosIn(text, curPos, end, current);
            if (nextMatch < 0 )
                return null;
            if(i == 0)
                matchStart= nextMatch;
            curPos= nextMatch + current.length();
        }
        if (i < segCount)
            return null;
        return new Position(matchStart, curPos);
    }
    /**
     * match the given <code>text</code> with the pattern 
     * @return true if matched eitherwise false
     * @param text a String object 
     */
    public boolean match(String text) {
        return match(text, 0, text.length());
    }
    /**
     * Given the starting (inclusive) and the ending (exclusive) positions in the   
     * <code>text</code>, determine if the given substring matches with aPattern  
     * @return true if the specified portion of the text matches the pattern
     * @param text a String object that contains the substring to match 
     * @param start marks the starting position (inclusive) of the substring
     * @param end marks the ending index (exclusive) of the substring 
     */
    public boolean match(String text, int start, int end) {
        if (null == text)
            throw new IllegalArgumentException();
            
        if (start > end)
            return false;
        
        if (isIgnoreWildCards)
            return (end - start == myLength) && myPattern.regionMatches(isIgnoreCase, 0, text, start, myLength);
        int segCount= mySegments.length;
        if (segCount == 0 && (hasLeadingStar || hasTrailingStar))  // pattern contains only '*'(s)
            return true;
        if (start == end)
            return myLength == 0;
        if (myLength == 0)
            return start == end;    
         
        int tlen= text.length();
        if (start < 0)
            start= 0;
        if (end > tlen)
            end= tlen; 
                    
        int tCurPos= start;
        int bound= end - myBound;
        if ( bound < 0)
            return false;
        int i=0;
        String current= mySegments[i];
        int segLength= current.length();

        /* process first segment */
        if (!hasLeadingStar){ 
            if(!regExpRegionMatches(text, start, current, 0, segLength)) {
                return false;
            } else {
                ++i;
                tCurPos= tCurPos + segLength;
            }
        }
        if ((mySegments.length == 1) && (!hasLeadingStar) && (!hasTrailingStar)) {
            // only one segment to match, no wildcards specified
            return tCurPos == end;
        }
        /* process middle segments */   
        while (i < segCount) {
            current= mySegments[i];
            int currentMatch;
            int k= current.indexOf(SINGLE_WILDCARD);
            if (k < 0) {
                currentMatch= textPosIn(text, tCurPos, end, current);
                if (currentMatch < 0)
                    return false;
            } else { 
                currentMatch= regExpPosIn(text, tCurPos, end, current);
                if (currentMatch < 0)
                    return false;
            }
            tCurPos= currentMatch + current.length();
            i++;
        }

        /* process final segment */
        if (!hasTrailingStar && tCurPos != end) {
            int clen= current.length();
            return regExpRegionMatches(text, end - clen, current, 0, clen);
        }
        return i == segCount ;
    }

    /**
     * This method parses the given pattern into segments seperated by wildcard '*' characters.
     * Since wildcards are not being used in this case, the pattern consists of a single segment.
     */
    private void parseNoWildCards() {
        mySegments= new String[1];
        mySegments[0]= myPattern;
        myBound= myLength;
    }
    /**
     * Parses the given pattern into segments seperated by wildcard '*' characters.
     */
    private void parseWildCards() {
        if(myPattern.startsWith("*"))//$NON-NLS-1$
            hasLeadingStar= true;
        if(myPattern.endsWith("*")) {//$NON-NLS-1$
            /* make sure it's not an escaped wildcard */
            if (myLength > 1 && myPattern.charAt(myLength - 2) != '\\') {
                hasTrailingStar= true;
            }
        }

        Vector<String> temp= new Vector<String>();

        int pos= 0;
        StringBuffer buf= new StringBuffer();
        while (pos < myLength) {
            char c= myPattern.charAt(pos++);
            switch (c) {
                case '\\':
                    if (pos >= myLength) {
                        buf.append(c);
                    } else {
                        char next= myPattern.charAt(pos++);
                        /* if it's an escape sequence */
                        if (next == '*' || next == '?' || next == '\\') {
                            buf.append(next);
                        } else {
                            /* not an escape sequence, just insert literally */
                            buf.append(c);
                            buf.append(next);
                        }
                    }
                break;
                case '*':
                    if (buf.length() > 0) {
                        /* new segment */
                        temp.addElement(buf.toString());
                        myBound += buf.length();
                        buf.setLength(0);
                    }
                break;
                case '?':
                    /* append special character representing single match wildcard */
                    buf.append(SINGLE_WILDCARD);
                break;
                default:
                    buf.append(c);
            }
        }

        /* add last buffer to segment list */
        if (buf.length() > 0) {
            temp.addElement(buf.toString());
            myBound += buf.length();
        }
            
        mySegments= new String[temp.size()];
        temp.copyInto(mySegments);
    }
    /** 
     * @param text a string which contains no wildcard
     * @param start the starting index in the text for search, inclusive
     * @param end the stopping point of search, exclusive
     * @return the starting index in the text of the pattern , or -1 if not found 
     */
    protected int posIn(String text, int start, int end) {//no wild card in pattern
        int max= end - myLength;
        
        if (!isIgnoreCase) {
            int i= text.indexOf(myPattern, start);
            if (i == -1 || i > max)
                return -1;
            return i;
        }
        
        for (int i= start; i <= max; ++i) {
            if (text.regionMatches(true, i, myPattern, 0, myLength))
                return i;
        }
        
        return -1;
    }
    /** 
     * @param text a simple regular expression that may only contain '?'(s)
     * @param start the starting index in the text for search, inclusive
     * @param end the stopping point of search, exclusive
     * @param p a simple regular expression that may contains '?'
     * @return the starting index in the text of the pattern , or -1 if not found 
     */
    protected int regExpPosIn(String text, int start, int end, String p) {
        int plen= p.length();
        
        int max= end - plen;
        for (int i= start; i <= max; ++i) {
            if (regExpRegionMatches(text, i, p, 0, plen))
                return i;
        }
        return -1;
    }

    
    protected boolean regExpRegionMatches(String text, int tStart, String p, int pStart, int plen) {
        while (plen-- > 0) {
            char tchar= text.charAt(tStart++);
            char pchar= p.charAt(pStart++);

            /* process wild cards */
            if (!isIgnoreWildCards) {
                /* skip single wild cards */
                if (pchar == SINGLE_WILDCARD) {
                    continue;
                }
            }
            if (pchar == tchar)
                continue;
            if (isIgnoreCase) {
                if (Character.toUpperCase(tchar) == Character.toUpperCase(pchar))
                    continue;
                // comparing after converting to upper case doesn't handle all cases;
                // also compare after converting to lower case
                if (Character.toLowerCase(tchar) == Character.toLowerCase(pchar))
                    continue;
            }
            return false;
        }
        return true;
    }
    /** 
     * @param text the string to match
     * @param start the starting index in the text for search, inclusive
     * @param end the stopping point of search, exclusive
     * @param p a string that has no wildcard
     * @return the starting index in the text of the pattern , or -1 if not found 
     */
    protected int textPosIn(String text, int start, int end, String p) { 
        
        int plen= p.length();
        int max= end - plen;
        
        if (!isIgnoreCase) {
            int i= text.indexOf(p, start);
            if (i == -1 || i > max)
                return -1;
            return i;
        }
        
        for (int i= start; i <= max; ++i) {
            if (text.regionMatches(true, i, p, 0, plen))
                return i;
        }
        
        return -1;
    }
}