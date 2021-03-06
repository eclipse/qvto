/*******************************************************************************
 * Copyright (c) 2007, 2018 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
/*
 * Created on 05.10.2004
 */
package org.eclipse.m2m.internal.qvt.oml.runtime.generator;

import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.ExecutionContext;

@Deprecated
public interface TransformationRunner {
	
	@Deprecated
    public static class In {
    	
        /**
         * Create input for the transformation
         * @param sources {ordered} list of 'in' and 'inout' transformation params
         * @param context transformation context (external properties, etc.)
         */
        public In(ModelContent[] sources, ExecutionContext context) {
            mySources = sources.clone();
            myContext = context;
        }
        
        public ModelContent[] getSources() {
            return mySources;
        }
        
        public ExecutionContext getContext() {
            return myContext;
        }
        
        private final ModelContent[] mySources;
        private final ExecutionContext myContext;
    }
    
	@Deprecated
    public static class Out {
    	
        public Out(List<ModelExtentContents> modelExtents, List<Object> outParamValues, Trace trace) {
        	myModelExtents = modelExtents;
        	myOutParamValues = outParamValues;
            myTrace = trace;
        }
        
        public List<ModelExtentContents> getExtents() {
            return myModelExtents;
        }
        
        public List<Object> getOutParamValues() {
            return myOutParamValues;
        }
        
        public Trace getTrace() {
            return myTrace;
        }
        
        private final List<ModelExtentContents> myModelExtents;
        private final List<Object> myOutParamValues;
        private final Trace myTrace;
    }
    
}
