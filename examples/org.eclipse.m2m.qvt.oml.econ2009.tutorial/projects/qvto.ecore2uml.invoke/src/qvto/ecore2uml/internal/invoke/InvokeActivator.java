/*******************************************************************************
 * Copyright (c) 2009, 2018 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Borland - initial API and implementation
 *******************************************************************************/
package qvto.ecore2uml.internal.invoke;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class InvokeActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "qvto.ecore2uml.internal.invoke";

	// The shared instance
	private static InvokeActivator plugin;
	
	/**
	 * The constructor
	 */
	public InvokeActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static InvokeActivator getDefault() {
		return plugin;
	}

}
