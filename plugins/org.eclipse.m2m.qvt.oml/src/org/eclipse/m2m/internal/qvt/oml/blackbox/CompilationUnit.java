/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox;

import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;

public interface CompilationUnit {
	List<QvtOperationalModuleEnv> getElements();
}