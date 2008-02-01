/**
* <copyright>
*
* Copyright (c) 2007 Borland Software Corporation
* 
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Borland Software Corporation - initial API and implementation
*
* </copyright>
*
* $Id: QvtOpLexerprs.java,v 1.29 2008/02/01 10:56:07 aigdalov Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006, 2007 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*
* </copyright>
*
* $Id: QvtOpLexerprs.java,v 1.29 2008/02/01 10:56:07 aigdalov Exp $
*/

package org.eclipse.m2m.qvt.oml.internal.cst.parser;

public class QvtOpLexerprs implements lpg.lpgjavaruntime.ParseTable, QvtOpLexersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            1,1,3,3,3,1,1,1,1,1,
            5,1,1,1,1,1,1,1,1,1,
            1,2,2,2,1,1,1,1,2,1,
            1,1,2,1,1,2,4,1,2,1,
            1,1,2,2,3,2,2,0,1,2,
            2,2,1,2,1,2,3,2,3,3,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,2,3,1,1,1,1,
            1,2,1,2,2,2,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,2,2,1,2,
            1,2,0,1,3,3,3,3,3,3,
            3,4,4,3,3,1,2,2,1,1,
            1,1,1
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            20,20,20,20,20,20,20,20,20,20,
            20,20,20,20,20,20,20,20,20,20,
            20,20,20,20,20,20,20,20,20,20,
            20,20,20,20,20,20,20,20,20,20,
            20,21,22,22,22,26,26,26,26,27,
            27,25,25,6,6,35,35,29,13,13,
            13,9,9,9,9,9,2,2,2,2,
            3,3,3,3,3,3,3,3,3,3,
            3,3,3,3,3,3,3,3,3,3,
            3,3,3,3,3,3,4,4,4,4,
            4,4,4,4,4,4,4,4,4,4,
            4,4,4,4,4,4,4,4,4,4,
            4,4,1,1,1,1,1,1,1,1,
            1,1,37,37,37,37,37,37,37,37,
            38,38,38,38,38,38,38,38,38,38,
            38,38,36,36,39,39,39,15,15,40,
            40,28,28,11,11,11,11,31,31,31,
            31,31,31,31,31,31,31,31,31,31,
            31,31,31,31,31,31,31,31,31,31,
            31,31,31,31,31,31,31,16,16,16,
            16,16,16,16,16,16,16,16,16,16,
            16,16,16,16,16,16,16,16,16,16,
            16,16,16,16,16,16,17,17,17,17,
            17,17,17,17,17,17,17,17,17,17,
            17,17,17,17,17,17,17,17,17,17,
            17,17,17,17,17,7,7,7,7,7,
            7,7,7,7,7,7,7,7,7,7,
            7,7,7,7,7,7,7,7,7,7,
            7,7,7,7,7,14,14,14,14,30,
            30,30,30,30,30,30,30,18,18,18,
            18,18,8,8,8,8,8,5,19,32,
            32,10,10,12,12,33,23,23,23,23,
            23,23,23,23,23,24,20,20,20,20,
            20,8,8,8,805,504,503,503,503,2,
            448,1278,54,505,1289,487,799,907,433,433,
            433,433,1077,162,346,6,7,8,9,470,
            985,401,344,377,433,433,433,326,203,506,
            506,506,506,506,1225,506,506,1341,422,433,
            444,203,506,506,506,506,506,405,506,506,
            43,422,410,460,407,438,438,438,438,438,
            1338,438,438,1339,438,1,47,47,47,47,
            1245,341,1256,482,47,1343,341,1344,482,47,
            1078,47,507,312,312,312,312,312,1155,312,
            312,1080,453,707,310,310,310,310,607,312,
            312,312,312,312,1290,312,312,1227,1231,54,
            310,310,310,102,45,45,45,45,1267,484,
            1291,44,45,410,484,1299,54,45,1150,45,
            303,52,52,52,52,1005,465,492,492,492,
            1229,465,1316,54,1327,54,492,1083,165,164,
            164,164,1157,165,164,164,164,1342,1345,1346,
            52,52,1294,1296,1297,1310,1313,509,509
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,73,74,75,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,97,98,99,
            100,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,72,73,74,75,76,77,78,
            79,80,81,82,83,84,85,86,87,88,
            89,90,91,92,93,94,95,96,97,98,
            99,100,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,66,67,
            68,69,70,71,72,73,74,75,76,77,
            78,79,80,81,82,83,84,85,86,87,
            88,89,90,91,92,93,94,95,96,97,
            98,99,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,66,67,
            68,69,70,71,72,73,74,75,76,77,
            78,79,80,81,82,83,84,85,86,87,
            88,89,90,91,92,93,94,95,96,97,
            0,0,100,0,0,103,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,95,96,97,98,99,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,95,96,97,98,99,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,95,96,97,98,99,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,0,93,
            94,95,96,97,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,53,54,55,
            56,57,58,59,60,61,62,63,64,65,
            66,67,68,69,70,71,72,0,74,75,
            76,77,78,79,80,81,82,83,84,85,
            86,87,88,89,90,91,92,0,0,0,
            102,0,98,99,100,101,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,0,79,80,81,82,83,
            84,85,86,87,88,89,90,91,14,93,
            94,95,96,97,0,1,2,3,4,5,
            6,7,8,9,10,11,0,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,53,54,55,
            56,57,58,59,60,61,62,63,64,65,
            0,67,68,69,70,71,0,0,0,0,
            76,77,0,1,2,3,4,5,6,7,
            8,9,10,11,15,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,71,0,
            74,0,0,0,0,73,0,1,2,3,
            4,5,6,7,8,9,10,11,0,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,68,69,0,0,0,78,0,73,
            0,1,2,3,4,5,6,7,8,9,
            10,11,0,13,0,1,2,3,4,5,
            6,7,8,9,10,0,1,2,3,4,
            5,6,7,8,9,10,0,1,2,3,
            4,5,6,7,8,9,10,0,1,2,
            3,4,5,6,7,8,9,10,0,0,
            0,67,66,0,66,0,0,67,0,1,
            2,3,4,5,6,7,8,9,10,0,
            0,0,0,69,70,0,1,2,3,4,
            5,6,7,8,9,10,0,1,2,3,
            4,5,6,7,8,9,10,0,0,0,
            0,0,0,0,0,0,0,0,0,12,
            12,11,11,13,12,12,12,12,0,66,
            72,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            92,0,0,0,0,0,98,99,100,0,
            101,101,0,0,0,0,0,102,102,0,
            0,0,0,0,0,0,68,0,0,0,
            0,102,75,101,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            509,556,556,556,556,556,556,556,556,556,
            556,556,556,556,556,556,556,556,556,556,
            556,556,556,556,556,556,556,556,556,556,
            556,556,556,556,556,556,556,556,556,556,
            556,556,556,556,556,556,556,556,556,556,
            556,556,556,556,556,556,556,556,556,556,
            556,556,556,556,556,556,556,556,556,556,
            556,453,556,556,556,556,556,555,556,556,
            556,556,556,556,556,556,556,556,556,556,
            556,556,556,556,556,556,556,556,556,556,
            556,509,554,554,554,554,554,554,554,554,
            554,554,554,554,554,554,554,554,554,554,
            554,554,554,554,554,554,554,554,554,554,
            554,554,554,554,554,554,554,554,554,554,
            554,554,554,554,554,554,554,554,554,554,
            554,554,554,554,554,554,554,554,554,554,
            554,554,554,554,554,554,554,554,554,554,
            554,554,559,554,554,554,554,554,520,554,
            554,554,554,554,554,554,554,554,554,554,
            554,554,554,554,554,554,554,554,554,554,
            554,554,313,506,506,506,506,506,506,506,
            506,506,506,506,506,506,506,506,506,506,
            506,506,506,506,506,506,506,506,506,506,
            506,506,506,506,506,506,506,506,506,506,
            506,506,506,506,506,506,506,506,506,506,
            506,506,506,506,506,506,506,506,506,506,
            506,506,506,506,506,506,506,506,447,506,
            506,506,506,506,506,506,506,506,506,506,
            506,506,506,506,506,506,506,506,506,506,
            506,506,506,506,506,506,506,506,506,506,
            506,506,10,561,561,561,561,561,561,561,
            561,561,561,561,561,561,561,561,561,561,
            561,561,561,561,561,561,561,561,561,561,
            561,561,561,561,561,561,561,561,561,561,
            561,561,561,561,561,561,561,561,561,561,
            561,561,561,561,561,561,561,561,561,561,
            561,561,561,561,561,561,561,561,561,561,
            561,561,561,561,561,561,561,561,561,561,
            561,561,561,561,561,561,561,561,561,561,
            561,561,561,561,561,561,561,561,561,561,
            48,509,561,509,509,561,509,438,438,438,
            438,438,438,438,438,438,438,438,438,438,
            438,438,438,438,438,438,438,438,438,438,
            438,438,438,438,438,438,438,438,438,438,
            438,438,438,438,438,438,438,438,438,438,
            438,438,438,438,438,438,438,438,438,438,
            438,438,438,438,438,438,438,438,438,438,
            438,438,480,438,438,438,438,438,438,438,
            438,438,438,438,438,438,438,438,438,438,
            438,438,438,438,438,438,438,438,438,438,
            438,438,438,438,438,438,314,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,447,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,509,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,502,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,821,821,821,821,
            821,821,821,821,821,821,509,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,819,819,819,819,819,819,
            819,819,819,819,824,819,819,819,819,819,
            819,819,819,819,819,819,819,819,509,819,
            819,819,819,468,509,504,504,504,504,504,
            504,504,504,504,504,503,530,503,503,503,
            503,503,503,503,503,503,503,503,503,503,
            503,503,503,503,503,503,503,503,503,503,
            503,503,503,503,503,503,503,503,503,503,
            503,503,503,503,503,503,503,503,503,503,
            503,503,503,503,503,503,503,503,503,503,
            394,374,415,428,417,524,505,509,352,400,
            403,420,347,539,839,360,368,543,536,537,
            534,535,549,540,526,527,505,509,509,509,
            508,509,505,505,505,381,509,433,433,433,
            433,433,433,433,433,433,433,433,433,433,
            433,433,433,433,433,433,433,433,433,433,
            433,433,433,433,433,433,433,433,433,433,
            433,433,433,433,433,433,433,433,433,433,
            433,433,433,433,433,433,433,433,433,433,
            433,433,433,433,433,433,433,433,433,433,
            433,433,433,433,433,433,433,433,433,433,
            433,433,433,433,329,433,433,433,433,433,
            433,433,433,433,433,433,433,433,431,433,
            433,433,433,468,509,465,465,465,465,465,
            465,465,465,465,465,492,509,492,492,492,
            492,492,492,492,492,492,492,492,492,492,
            492,492,492,492,492,492,492,492,492,492,
            492,492,492,492,492,492,492,492,492,492,
            492,492,492,492,492,492,492,492,492,492,
            492,492,492,492,492,492,492,492,492,492,
            509,834,498,827,826,828,38,16,509,509,
            499,829,1,674,674,674,674,674,674,674,
            674,674,674,673,497,673,673,673,673,673,
            673,673,673,673,673,673,673,673,673,673,
            673,673,673,673,673,673,673,673,673,673,
            673,673,673,673,673,673,673,673,673,673,
            673,673,673,673,673,673,673,673,673,673,
            673,673,673,673,673,673,673,673,361,509,
            548,509,509,509,14,675,316,674,674,674,
            674,674,674,674,674,674,674,673,509,673,
            673,673,673,673,673,673,673,673,673,673,
            673,673,673,673,673,673,673,673,673,673,
            673,673,673,673,673,673,673,673,673,673,
            673,673,673,673,673,673,673,673,673,673,
            673,673,673,673,673,673,673,673,673,673,
            673,673,538,560,35,509,509,817,307,675,
            6,563,563,563,563,563,563,563,563,563,
            563,410,509,410,509,341,341,341,341,341,
            341,341,341,341,341,509,482,482,482,482,
            482,482,482,482,482,482,509,484,484,484,
            484,484,484,484,484,484,484,58,563,563,
            563,563,563,563,563,563,563,563,12,509,
            509,545,816,3,816,163,53,475,57,563,
            563,563,563,563,563,563,563,563,563,161,
            509,509,311,458,412,60,563,563,563,563,
            563,563,563,563,563,563,59,563,563,563,
            563,563,563,563,563,563,563,32,20,509,
            7,509,19,13,324,321,509,509,509,836,
            532,410,546,410,531,837,832,831,509,816,
            671,509,509,509,509,509,509,509,509,509,
            509,509,509,509,509,509,509,509,509,509,
            671,509,509,509,509,509,671,671,671,509,
            514,513,509,509,509,509,509,1,6,509,
            509,509,509,509,509,509,533,509,509,509,
            509,12,542,314
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int getErrorSymbol() { return 0; }
    public final int getScopeUbound() { return 0; }
    public final int getScopeSize() { return 0; }
    public final int getMaxNameLength() { return 0; }

    public final static int
           NUM_STATES        = 49,
           NT_OFFSET         = 103,
           LA_STATE_OFFSET   = 842,
           MAX_LA            = 1,
           NUM_RULES         = 333,
           NUM_NONTERMINALS  = 40,
           NUM_SYMBOLS       = 143,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 334,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 102,
           EOLT_SYMBOL       = 104,
           ACCEPT_ACTION     = 508,
           ERROR_ACTION      = 509;

    public final static boolean BACKTRACK = false;

    public final int getNumStates() { return NUM_STATES; }
    public final int getNtOffset() { return NT_OFFSET; }
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }
    public final int getMaxLa() { return MAX_LA; }
    public final int getNumRules() { return NUM_RULES; }
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }
    public final int getNumSymbols() { return NUM_SYMBOLS; }
    public final int getSegmentSize() { return SEGMENT_SIZE; }
    public final int getStartState() { return START_STATE; }
    public final int getStartSymbol() { return lhs[0]; }
    public final int getIdentifierSymbol() { return IDENTIFIER_SYMBOL; }
    public final int getEoftSymbol() { return EOFT_SYMBOL; }
    public final int getEoltSymbol() { return EOLT_SYMBOL; }
    public final int getAcceptAction() { return ACCEPT_ACTION; }
    public final int getErrorAction() { return ERROR_ACTION; }
    public final boolean isValidForParser() { return isValidForParser; }
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
