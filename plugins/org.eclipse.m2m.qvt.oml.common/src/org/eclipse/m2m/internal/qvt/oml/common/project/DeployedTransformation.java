/*******************************************************************************
 * Copyright (c) 2007, 2016 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.project;

import org.eclipse.emf.common.util.URI;

public interface DeployedTransformation {

	String getId();
	
	URI getUri();
	
}
