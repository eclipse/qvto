/*******************************************************************************
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFileUtil;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLPGParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtOpLexer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.IKeywordHandler;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.KeywordHandlerRegistry;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.cst.CSTNode;

/**
 * @author aigdalov
 * Created on Oct 30, 2007
 */
public class QvtCompletionCompiler extends QVTOCompiler {
    private final QvtCompletionData myData;
    private final Map<CFile, CFileData> myCFileDataMap = new LinkedHashMap<CFile, CFileData>();
    private QvtOperationalEnv myEnvironment;

    public QvtCompletionCompiler(IImportResolver importResolver, QvtCompletionData data) {
        super(importResolver);
        myData = data;
    }
    
    public Map<CFile, CFileData> getCFileDataMap() {
        return myCFileDataMap;
    }

    public QvtOpLexer createLexer(CFile cFile) throws IOException, ParserException, BadLocationException {
        CFileData cFileData = getCFileData(cFile);
        if (cFileData.getLexer() != null) {
            return cFileData.getLexer();
        }
        Reader reader = getCFileReader(cFile);
        
        QvtOpLexer lexer = new QvtOpLexer(new QvtOperationalEnvFactory().createEnvironment(cFile, getKernel()));
        cFileData.setLexer(lexer);
        try {
            lexer.initialize(new OCLInput(reader).getContent(), cFile.getName());
            lexer.lexToTokens(new QvtOpLPGParser(lexer));
        } finally {
            reader.close();
        }
        return lexer;    
    }

    private Reader getCFileReader(CFile cFile) throws IOException, BadLocationException {
        if (cFile == myData.getCFile()) {
            String documentText = myData.getDocument().get(0, myData.getDocument().getLength());
            return new StringReader(documentText);
        }
        return CFileUtil.getReader(cFile);
    }
    
    public QvtOperationalEnv compileAll() {
        if (myEnvironment == null) {
            myEnvironment = new QvtOperationalEnvFactory().createEnvironment(myData.getCFile(), getKernel());

            QvtCompilerOptions options = new QvtCompilerOptions();
            options.setReportErrors(false);
            options.setShowAnnotations(false);
            options.setSourceLineNumbersEnabled(false);

            try {
                compile(myData.getCFile(), options, null);
            } catch (MdaException ex) {
              Activator.log(ex);
            }
        }
        return myEnvironment;
    }
    
    @Override
    protected QvtOperationalVisitorCS createAnalyzer(AbstractQVTParser parser, QvtCompilerOptions options) {
		return new QvtCompletionVisitorCS(parser, options, null) {
			@Override
			protected void setEnv(QvtOperationalEnv env) {			
				super.setEnv(env);
				myEnvironment = env;
			}
		};
    }

    @Override
    protected CSTParseResult parse(CFile source, QvtCompilerOptions options) throws ParserException {
     	CFileData cFileData = compile(source);
		AbstractQVTParser qvtParser = (AbstractQVTParser) cFileData.getLexer().getParser();
		// FIXME - should be no dummy module but rather empty UnitCS object
    	MappingModuleCS mappingModuleCS = cFileData.getMappingModuleCS();
    	if (mappingModuleCS == null) {
    	    //mappingModuleCS = CSTFactory.eINSTANCE.createMappingModuleCS();
    	}
    	
    	QvtOperationalFileEnv env = (QvtOperationalFileEnv)cFileData.getLexer().getEnvironment();
    	CSTParseResult result = new CSTParseResult();
    	result.moduleCS = mappingModuleCS;
    	result.env = env;
    	result.parser = qvtParser;
    	return result;
    }
    
    
    private CFileData compile(CFile cFile) {
        CFileData cFileData = getCFileData(cFile);
        try {
            QvtOpLexer lexer = createLexer(cFile);
            PrsStream prsStream = lexer.getPrsStream();
            IKeywordHandler[] keywordHandlers = KeywordHandlerRegistry.getInstance().getKeywordHandlers();
            StringBuilder lightweightScriptBuilder = new StringBuilder(lexer.getStreamLength());
            for (int i = 0, n = prsStream.getSize(); i < n; i++) {
                IToken token = prsStream.getTokenAt(i);
                for (IKeywordHandler keywordHandler : keywordHandlers) {
                    String contribution = keywordHandler.handle(token, prsStream, myData, cFileData);
                    if (contribution != null) {
                        int offsetDelta = token.getStartOffset() - lightweightScriptBuilder.length();
                        for (int j = 0; j < offsetDelta - 1; j++) {
                            lightweightScriptBuilder.append(' ');
                        }
                        lightweightScriptBuilder.append(contribution);
                        break;
                    }
                }
            }
            String lightweightScript = lightweightScriptBuilder.toString();
            cFileData.setLightweightScript(lightweightScript);
            CSTNode cstNode = LightweightParserUtil.parse(lightweightScript, cFile, LightweightParserUtil.ParserTypeEnum.LIGHTWEIGHT_PARSER);
            if (cstNode instanceof MappingModuleCS) {
                cFileData.setMappingModuleCS((MappingModuleCS) cstNode);
            }
        } catch (Exception ex) {
            Activator.log(ex);
        }
        return cFileData;
    }
    
    public CFileData getCFileData(CFile cFile) {
        CFileData cFileData = myCFileDataMap.get(cFile);
        if (cFileData == null) {
            cFileData = new CFileData(cFile, myData);
            myCFileDataMap.put(cFile, cFileData);        
        }
        return cFileData;
    }
    
    public CFileData getCFileData(MappingModuleCS mappingModuleCS) {
        for (CFileData cFileData : myCFileDataMap.values()) {
            if (cFileData.getMappingModuleCS() == mappingModuleCS) {
                return cFileData;
            }
        }
        return null;
    }
}