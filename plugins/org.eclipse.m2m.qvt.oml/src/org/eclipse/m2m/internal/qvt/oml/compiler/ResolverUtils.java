/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.compiler;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitContents.CSTContents;


public class ResolverUtils {
	
	private ResolverUtils() {
		super();
	}
	
    private static String getNamespaceQuery(URI unitURI) {
        String query = unitURI.query();
		if(query == null || query.trim().length() == 0) {
        	return null;
        }
		
        StringTokenizer tok = new StringTokenizer(query, "&"); //$NON-NLS-1$                
        while (tok.hasMoreElements()) {
            String pair = ((String) tok.nextElement()).trim();
            int index = pair.indexOf('=');

            if (index > 0) {
                String key = pair.substring(0, index);
                if("ns".equals(key.trim())) { //$NON-NLS-1$
                	String val = pair.substring(index + 1).trim();
                	return val.trim();
                }
            }
        }

        return null;
    }
    
    /**
     * Read the name-space value from the query part of the URI if available.
     * @param uri to parse, expecting <code>platform:/plugin/&lt;plugind-id&gt;/&lt;path&gt;/&lt;unit-file&gt;.qvto?ns=org.bar</code> 
     * <b>Note</b>: A temporary solution for compilation of deployed qvto files,
     * in which case the knowledge of the source folder is absent and
     * affects the qualified name resolution 
     */
    public static URI getSourceFolderURI(URI uri) {
    	String ns = getNamespaceQuery(uri);
    	if(ns == null) {
    		return null;
    	}
    	URI result;
    	if(".".equals(ns)) { //$NON-NLS-1$
    		result = uri.trimSegments(1);
    	} else if(ns != null) {
    		String[] segments = getNameSegments(ns);
    		result = uri.trimSegments(segments.length + 1);
    	} else {
    		return null;
    	}
    	// add trailing / as for directories
    	return result.appendSegment("").trimQuery(); //$NON-NLS-1$
    }
    
	
	public static String getNamespace(IPath namespacePath, IPath srcContainerPath) {
		if(namespacePath == null || srcContainerPath == null) {
			throw new IllegalArgumentException();
		}
		
		if(namespacePath.equals(srcContainerPath)) {
			// default namespace
			return null;
		}

		int srcContainerDepth = srcContainerPath.segmentCount();
		IPath srcRelativePath = namespacePath.removeFirstSegments(srcContainerDepth);
		
		return getNamespace(srcRelativePath);
	}
	
	public static String getNamespace(IPath srcRelativePath) {
		StringBuilder buf = new StringBuilder();			
		String[] segments = srcRelativePath.segments();
		
		for (int i = 0; i < segments.length; i++) {
			if(i > 0) {
				buf.append('.');
			}
			
			buf.append(segments[i]);	
		}
		
		return buf.toString();
	}

		
	public static List<UnitProxy> findAllUnits(UnitProvider unitProvider) {
		final List<UnitProxy> result = new ArrayList<UnitProxy>();
		
		UnitProvider.UnitVisitor visitor = new UnitProvider.UnitVisitor() {
			
			public boolean visitUnit(UnitProxy unit) {
				result.add(unit);
				return true;
			}
		};

		unitProvider.accept(visitor, null, UnitProvider.UnitVisitor.DEPTH_INFINITE, true);		
		return result;
	}
	
	public static String toQualifiedName(IPath path) {
		return path.toString().replace(IPath.SEPARATOR, UnitProxy.NAMESPACE_SEP);
	}
	
	public static String toQualifiedName(String[] nameSegments, int startPos, int endPos) {
		int len = nameSegments.length;
		
		if(	startPos > endPos ||
			(startPos < 0 || startPos >= len) ||
			(endPos < 0 || endPos >= len) ) {
			throw new ArrayIndexOutOfBoundsException("name segment position"); //$NON-NLS-1$
		}
		
		StringBuilder buf = new StringBuilder();
		for (int i = startPos; i <= endPos; i++) {
			if(i > startPos) {
				buf.append(UnitProxy.NAMESPACE_SEP);
			}
			
			buf.append(nameSegments[i]);
		}
		
		return buf.toString();
	}
	
    public static String[] getNameSegments(String qualifiedName) {
		return qualifiedName.split("\\."); //$NON-NLS-1$    	
    }	
	
	public static UnitProxy createUnitProxy(String qualifiedName, URI uri, final String contents, final UnitResolver resolver) {
		String[] segments = getNameSegments(qualifiedName);
		String namespace = null;
		if(segments.length > 1) {
			namespace = toQualifiedName(segments, 0, segments.length - 2);
		}
		
		String name = segments[segments.length - 1];
		
		return new UnitProxy(namespace, name, uri) {
			@Override
			public UnitContents getContents() throws IOException {
				return createCSTContents(contents);
			}
			
			@Override
			public int getContentType() {			
				return TYPE_CST_STREAM;
			}
			
			@Override
			public UnitResolver getResolver() {			
				return resolver;
			}
		};
	}
	
	public static IPath toNamespaceRelativePath(String qualifiedName) {
		String path = qualifiedName.replace('.', '/');
		return new Path(path);
	}
	
	public static CSTContents createCSTContents(final String input) {
		if(input == null) {
			throw new IllegalArgumentException();
		}
		
		return new UnitContents.CSTContents() {
			public Reader getContents() throws IOException {				
				return new StringReader(input);
			}
		};
	}
}
