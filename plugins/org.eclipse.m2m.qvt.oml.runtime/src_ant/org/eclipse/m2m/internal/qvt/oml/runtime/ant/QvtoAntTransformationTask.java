/*******************************************************************************
 * Copyright (c) 2009, 2019 Borland Software Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bug 537609
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ant;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ProjectComponent;
import org.apache.tools.ant.Task;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator.ValidationType;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.osgi.util.NLS;

/**
 *  <p>
 *  All URIs used in transformation task (that are: transformation URI,
 *  transformation's parameter URI, trace URI) are resolved due to the following rules:
 *
 *  <ul>
 *  <li>
 *  in case it's platform URI (URI.isPlatform() == true) -
 *      it is used as-is
 *  <li>
 *  in case it's non-relative file URI (URI.isRelative() == false) -
 *      it's resolved against workspace root
 *  <li>
 *  in case it's relative file URI (URI.isRelative() == false) but starts with ["\", "/"] -
 *      it's resolved against workspace root
 *  <li>
 *  in case it's relative file URI (URI.isRelative() == false) and does not start with ["\", "/"] -
 *      it's resolved against script location
 *  </ul>
 *
 *  <hr>
 *  <p>
 *  Ant task example:
 *  <br>
 *
 *  &lt;project name="project" default="default" xmlns:qvto="http://www.eclipse.org/qvt/1.0.0/Operational"&gt;<br>
 *  &lt;target name="default"&gt;<br>
 *      &lt;qvto:transformation uri="platform:/resource/qvto/transforms/NewTransformation.qvto"&gt;<br>
 *  <br>
 *           &lt;inout<br>
 *               uri="platform:/resource/qvto/transforms/in.ecore"<br>
 *               outuri="platform:/resource/qvto/transforms/in_out.ecore"<br>
 *           /&gt;<br>
 *           &lt;out uri="platform:/resource/qvto/transforms/out.ecore#//cls"/&gt;<br>
 *  <br>
 *           &lt;trace uri="platform:/resource/qvto/transforms/NewTransformation.qvtotrace"/&gt;<br>
 *       &lt;/qvto:transformation&gt;<br>
 *  &lt;/target&gt;<br>
 *  &lt;/project&gt;<br>
 *
 */
public class QvtoAntTransformationTask extends Task {

	public static final String QVTO_ANTTASK_NAME = "qvto:transformation"; //$NON-NLS-1$

	public static interface ModelParameter {

		public TargetUriData getTargetUriData(ProjectComponent project);

	}

	/**
	 *  ModelParameter of [in] type for the transformation
	 */
	public static class In implements ModelParameter {

		public In() {
		}

		URI getURI(ProjectComponent project) {
			return toUri(myUri, project);
		}

		public void setUri(String uri) {
			myUri = uri;
		}

		public TargetUriData getTargetUriData(ProjectComponent project) {
			return new TargetUriData(getURI(project).toString());
		}

		@Override
		public String toString() {
			return "IN uri=" + myUri; //$NON-NLS-1$
		}

		private String myUri;
	}

	/**
	 *  ModelParameter of [inout] type for the transformation
	 */
	public static class Inout implements ModelParameter {

		public Inout() {
		}

		URI getURI(ProjectComponent project) {
			return toUri(myUri, project);
		}

		public void setUri(String uri) {
			myUri = uri;
		}

		URI getOutURI(ProjectComponent project) {
			String outUriString = myOutUri != null && myOutUri.trim().length() > 0 ? myOutUri : myUri;
			return toUri(outUriString, project);
		}

		public void setOuturi(String uri) {
			myOutUri = uri;
		}

		public TargetUriData getTargetUriData(ProjectComponent project) {
			return new TargetUriData(getOutURI(project).toString());
		}

		@Override
		public String toString() {
			return "INOUT uri=" + myUri; //$NON-NLS-1$
		}

		private String myUri;
		private String myOutUri;
	}

	/**
	 *  ModelParameter of [out] type for the transformation
	 */
	public static class Out implements ModelParameter {

		public Out() {
		}

		URI getURI(ProjectComponent project) {
			return toUri(myUri, project);
		}

		public void setUri(String uri) {
			myUri = uri;
		}

		public void addConfiguredFeature(Feature feature) {
			myFeature = feature;
		}

		public TargetUriData getTargetUriData(ProjectComponent project) {
			String feature = myFeature != null ? myFeature.getName() : null;
			return new TargetUriData(
					feature != null && feature.trim().length() > 0 ? TargetType.EXISTING_CONTAINER : TargetType.NEW_MODEL,
							getURI(project).toString(),
							feature,
							myFeature != null ? myFeature.isClearContents() : false
					);
		}

		@Override
		public String toString() {
			return "OUT uri=" + myUri; //$NON-NLS-1$
		}

		private String myUri;
		private Feature myFeature;
	}

	public static class Feature {

		public String getName() {
			return myName;
		}

		public void setName(String name) {
			myName = name;
		}

		public boolean isClearContents() {
			return Boolean.valueOf(myClearcontents);
		}

		public void setClearcontents(String clearcontents) {
			myClearcontents = clearcontents;
		}

		private String myName;
		private String myClearcontents;
	}

	/**
	 *  Trace element - specifies a trace definition
	 *  for the transformation
	 */
	public static class Trace {

		public Trace() {
		}

		public URI getURI(ProjectComponent project) {
			return toUri(myUri, project);
		}

		public void setUri(String uri) {
			myUri = uri;
		}

		public boolean isGenerate() {
			return myGenerate == null ? true : Boolean.valueOf(myGenerate);
		}

		public void setGenerate(String generate) {
			myGenerate = generate;
		}

		public boolean isIncrementalUpdate() {
			return Boolean.valueOf(myIncrementalUpdate);
		}

		public void setIncrementalUpdate(String incrementalUpdate) {
			myIncrementalUpdate = incrementalUpdate;
		}

		private String myUri;
		private String myGenerate;
		private String myIncrementalUpdate;
	}

	/**
	 *  Configuration property element - specifies a configuration property value
	 *  for the transformation
	 */
	public static class ConfigProperty {

		public ConfigProperty() {
		}

		public String getName() {
			return myName;
		}

		public void setName(String name) {
			myName = name;
		}

		public String getValue() {
			return myValue;
		}

		public void setValue(String value) {
			myValue = value;
		}

		private String myName;
		private String myValue;
	}

	public void setUri(String moduleUri) {
		myModuleUri = moduleUri;
	}

	public void addConfiguredIn(In parameter) {
		myModelParameters.add(parameter);
	}

	public void addConfiguredInout(Inout parameter) {
		myModelParameters.add(parameter);
	}

	public void addConfiguredOut(Out parameter) {
		myModelParameters.add(parameter);
	}

	public void addConfiguredTrace(Trace trace) {
		myTrace = trace;
	}

	public void addConfiguredConfigProperty(ConfigProperty configProperty) {
		myConfigProperties.put(configProperty.getName(), configProperty.getValue());
	}


	/**
	 * Checks up parameters validity and launch transformation
	 */
	@Override
	public void execute() throws BuildException {

		final QvtTransformation transformation = getTransformationObject();

		try {
			URI traceUri = getTraceUri(QvtoAntTransformationTask.this);
			boolean useTrace = myTrace == null ? false : myTrace.isGenerate();
			boolean isIncrementalUpdate = myTrace == null ? false : myTrace.isIncrementalUpdate();
			List<TargetUriData> allTargetData = new ArrayList<TargetUriData>();

			for (ModelParameter p : myModelParameters) {
				allTargetData.add(p.getTargetUriData(QvtoAntTransformationTask.this));
			}

			IStatus status = QvtValidator.validateTransformation(transformation, allTargetData, traceUri == null ? null : traceUri.toString(), useTrace,
					isIncrementalUpdate, ValidationType.FULL_VALIDATION);
			if (status.getSeverity() > IStatus.WARNING) {
				throw new MdaException(status);
			}

			List<URI> modelParamUris = new ArrayList<URI>(allTargetData.size());
			for(TargetUriData uriData : allTargetData) {
				modelParamUris.add(uriData.getUri());
			}

			ExecutionContext context = QvtLaunchUtil.createContext(getConfiguration(), createQVTLog());

			QvtLaunchUtil.doLaunch(transformation, modelParamUris, traceUri, context, useTrace, isIncrementalUpdate);
		}
		catch (Exception e) {
			if(e instanceof RuntimeException && e instanceof QvtRuntimeException == false) {
				e.printStackTrace();
			}

			throw new BuildException(StatusUtil.getExceptionMessages(e), e);
		}
		finally {
			transformation.cleanup();
		}

		log(NLS.bind(Messages.TransformationExecuted, getModuleURI(this)));
	}

	private Log createQVTLog() {
		return new Log() {

			public void log(int level, String message, Object param) {
				log(message, param);
			}

			public void log(int level, String message) {
				log(message);
			}

			public void log(String message, Object param) {
				QvtoAntTransformationTask.this.log(message + " , data:" + String.valueOf(param)); //$NON-NLS-1$
			}

			public void log(String message) {
				QvtoAntTransformationTask.this.log(message);
			}
		};
	}

	/**
	 * @return a transformation to be executed
	 */
	private QvtTransformation getTransformationObject() {
		try {
			return new QvtInterpretedTransformation(TransformationUtil.getQvtModule(getModuleURI(this)));
		} catch (Exception e) {
			throw new BuildException(
					NLS.bind(
							Messages.AbstractApplyTransformationTask_File_not_found,
							getModuleURI(this)
							),
					e
					);
		}
	}

	private URI getModuleURI(ProjectComponent project) {
		return toUri(myModuleUri, project);
	}

	private URI getTraceUri(ProjectComponent project) {
		if (myTrace == null) {
			return null;
		}
		return myTrace.getURI(project);
	}

	private Map<String, Object> getConfiguration() {
		return myConfigProperties;
	}

	private static URI toUri(String uriString, ProjectComponent project) throws BuildException {
		try {
			URI uri = URI.createURI(uriString);
			if(uri == null) {
				throw new BuildException(NLS.bind(Messages.InvalidUriSpecified, uriString));
			}

			if (uri.isRelative() && !uriString.trim().startsWith(MSDOS_FS) && !uriString.trim().startsWith(UNIX_FS)) {
				URI baseUri = URI.createFileURI(project.getProject().getBaseDir().getAbsolutePath());
				uri = baseUri.appendSegments(uri.segments());

				IFile wsfile = WorkspaceUtils.getIFile(uri.toFileString());
				uri = URI.createURI(wsfile.getFullPath().toPortableString());
			}
			return uri;
		}
		catch (Exception e) {
			throw new BuildException(e);
		}
	}


	private String myModuleUri;
	private Trace myTrace;

	private final List<ModelParameter> myModelParameters = new ArrayList<ModelParameter>(3);
	private final Map<String, Object> myConfigProperties = new LinkedHashMap<String, Object>(3);

	//private static final String SYSTEM_FS = System.getProperty("file.separator"); //$NON-NLS-1$
	private static final String MSDOS_FS = "\\"; //$NON-NLS-1$
	private static final String UNIX_FS = "/"; //$NON-NLS-1$

}
