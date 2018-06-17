/*******************************************************************************
 * Copyright (c) 2009, 2016 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.jdt.debug.ui.launch;

import org.eclipse.osgi.util.NLS;

public class DebugPDEMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.jdt.debug.ui.launch.DebugPDEMessages"; //$NON-NLS-1$

	public static String QVTOMainTab_mustRunAsQVTApp;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DebugPDEMessages.class);
	}

	private DebugPDEMessages() {
	}
}
