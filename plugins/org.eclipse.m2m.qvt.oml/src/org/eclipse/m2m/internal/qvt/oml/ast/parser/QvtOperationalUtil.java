/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ast.parser;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler.Severity;
import org.eclipse.ocl.types.InvalidType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.OCLUtil;

public class QvtOperationalUtil {

	private QvtOperationalUtil() {
	}

	public static String getStringRepresentation(PathNameCS pathName, String pathSeparator) {
		return QvtOperationalParserUtil.getStringRepresentation(pathName, pathSeparator);
	}

	public static String getStringRepresentation(TypeCS typeCS) {
		return QvtOperationalParserUtil.getStringRepresentation(typeCS);
	}
	    
    public static boolean isAssignableToFrom(QvtOperationalEnv env, EClassifier to, EClassifier from) {
        return QvtOperationalParserUtil.isAssignableToFrom(env, to, from);
    }
    
	public static boolean isUndefined(Object value) {
		return value == null || value == getOclInvalid();
	}

	public static boolean isCreateFromStringSupported(EClassifier type) {
		return isPrimitiveType(type) || type instanceof EDataType;
	}

	public static Object getOclInvalid() {
		return ourOclInvalid;
	}
		
	public static boolean isPrimitiveType(Object type) {
		return type instanceof PrimitiveType;
	}

	public static boolean isInstantiable(EClass cls) {
		return !cls.isAbstract() && !cls.isInterface();
	}

    public static boolean isMappingOperation(EOperation operation) {
        return operation instanceof MappingOperation;
    }

    public static boolean isImperativeOperation(EOperation operation) {
    	return operation instanceof ImperativeOperation;
    }

	public static boolean isModelParamEqual(ModelParameter param, ModelParameter importedParam, boolean isStrictCompare) {
		if (param.getKind() == DirectionKind.IN) {
			if (importedParam.getKind() != DirectionKind.IN) {
				return false;
			}
		}
		if (!isStrictCompare) {
			return true;
		}

		ModelType modelType = getModelType(param);
		ModelType importedModelType = getModelType(importedParam);
		if(modelType == null || importedModelType == null) {
			return false;
		}
		
		if(modelType == importedModelType) {
			return true;
		}
		return modelType.getMetamodel().containsAll(importedModelType.getMetamodel());
	}
	
	public static ModelType getModelType(ModelParameter modelParameter) {
		EClassifier eType = modelParameter.getEType();
		return (eType instanceof ModelType) ? (ModelType) eType : null;
	}
	
    public static final Boolean oclIsKindOf(Object value, EClassifier type, QvtOperationalEvaluationEnv env) {
        // regardless of the source value, if the type is undefined, then so
        //    is oclIsTypeOf
        if (type == null) {
            return null;
        }
        
        // OclVoid and Invalid conform to all classifiers but their instances
        // aren't actually useful as any type but their own.  So, check for
        // exact type match in these cases
        if (isUndefined(value)) {
            return oclIsTypeOf(value, type, env);
        }

        return Boolean.valueOf(env.isKindOf(value, type));
    }

    public static final Boolean oclIsTypeOf(Object value, EClassifier type, QvtOperationalEvaluationEnv env) {
        // regardless of the source value, if the type is undefined, then so
        //    is oclIsTypeOf
        if (type == null) {
            return null;
        }
        
        // the type of null is OclVoid
        if (value == null) {
            return Boolean.valueOf(type instanceof VoidType);
        }
        
        // the type of OclInvalid is Invalid
        if (value == getOclInvalid()) {
            return Boolean.valueOf(type instanceof InvalidType);
        }

        return Boolean.valueOf(env.isTypeOf(value, type));
	}
    
    public static boolean isAbstract(EClassifier eClassifier) {
		if(eClassifier instanceof EClass) {    	
			EClass eClass = (EClass)eClassifier;
			return eClass.isAbstract() || eClass.isInterface();
		}
		return false;
    }
    
    public static boolean hasAbstractOutputParamerter(ImperativeOperation operation) {
    	for (VarParameter nextParam : operation.getResult()) {
    		if(nextParam.getEType() != null && isAbstract(nextParam.getEType())) {
   				return true;
    		}
		}
    	
    	for (EParameter eParam : operation.getEParameters()) {
    		if(eParam instanceof VarParameter) {
    			VarParameter varParam = (VarParameter) eParam;
    			if(varParam.getEType() != null && isAbstract(varParam.getEType())) {
    				return true;
    			}
    		}
		}
    	return false;
    }
    
    /**
     * FIXME - eliminate this hack, there is no guarantee of StdLib singleton in MDT OCL !!! 
     */    
	private static final Object ourOclInvalid = QvtOperationalEnvFactory.INSTANCE.createEnvironment().getOCLStandardLibrary().getOclInvalid();

	public static void reportError(Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env, String message, CSTNode node) {
		OCLUtil.getAdapter(env, BasicEnvironment.class).analyzerError(message, node.eClass().getName(), node);
	}

	public static void reportError(Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env, String message, int startOffset, int endOffset) {
		OCLUtil.getAdapter(env, BasicEnvironment.class).analyzerError(message, "unknown", startOffset, endOffset);
	}

	public static void reportWarning(Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env, String message, CSTNode node) {
		
		OCLUtil.getAdapter(env, BasicEnvironment.class).analyzerWarning(message, node.eClass().getName(), node);		
	}

	public static void reportWarning(Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env, String message, int startOffset, int endOffset) {
		
		ProblemHandler problemHandler = OCLUtil.getAdapter(env, ProblemHandler.class);
		if (problemHandler != null) {
			problemHandler.analyzerProblem(Severity.WARNING, message, "unknown", startOffset, endOffset);
		}		
	}
}
