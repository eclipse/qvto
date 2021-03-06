/*******************************************************************************
 * Copyright (c) 2016, 2021 Christopher Gerking and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Christopher Gerking - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.jdt.runtime.blackbox;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;

public class ProjectClassLoader extends URLClassLoader {

	private static Map<IJavaProject, ProjectClassLoader> loadersMap = new HashMap<IJavaProject, ProjectClassLoader>();

	ProjectClassLoader(IProject project) throws CoreException, MalformedURLException {
		this(JavaCore.create(project));
	}

	ProjectClassLoader(IJavaProject javaProject) throws CoreException, MalformedURLException {
		super(getProjectClassPath(javaProject), ProjectClassLoader.class.getClassLoader());
		
		loadersMap.put(javaProject, this);
	}
	
	static synchronized boolean isProjectClassLoaderExisting(IJavaProject javaProject) {
		return loadersMap.containsKey(javaProject);
	}

	static synchronized ProjectClassLoader getProjectClassLoader(IProject project) throws CoreException, MalformedURLException {
		return getProjectClassLoader(JavaCore.create(project));
	}

	static synchronized ProjectClassLoader getProjectClassLoader(IJavaProject javaProject) throws CoreException, MalformedURLException {

		ProjectClassLoader loader = loadersMap.get(javaProject);

		if (loader == null) {
			loader = new ProjectClassLoader(javaProject);
		}

		return loader;
	}

	static synchronized void resetProjectClassLoader(IJavaProject javaProject) {

		ProjectClassLoader loader = loadersMap.get(javaProject);

		if (loader != null) {
			try {			// FIXME Bug 474603#22
				Method closeMethod = loader.getClass().getMethod("close");
				closeMethod.invoke(loader);
			}
			catch (InvocationTargetException e) {
				Throwable targetException = e.getTargetException();
				if (targetException instanceof IOException) {
					QvtPlugin.error(e);
				}
			}
			catch (Exception e) {}
			loadersMap.remove(javaProject);
		}
	}
	
	static synchronized void resetAllProjectClassLoaders() {

		for(IJavaProject javaProject : loadersMap.keySet()) {
			resetProjectClassLoader(javaProject);
		}
	}

	private static URL[] getProjectClassPath(IJavaProject javaProject) throws CoreException, MalformedURLException {
		String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);
		
		List<URL> urlList = new ArrayList<URL>();
		for (String entry : classPathEntries) {
			IPath path = new Path(entry);
			URL url = path.toFile().toURI().toURL();
			urlList.add(url);
		}
		
		return urlList.toArray(new URL[] {});
	}
}
