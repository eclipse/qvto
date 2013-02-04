/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *
 * $Id: TraceItemProviderAdapterFactory.java,v 1.3 2009/01/11 23:22:19 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.trace.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.m2m.internal.qvt.oml.trace.util.TraceAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceItemProviderAdapterFactory extends TraceAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation";

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.m2m.internal.qvt.oml.trace.Trace} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceItemProvider traceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.Trace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTraceAdapter() {
		if (traceItemProvider == null) {
			traceItemProvider = new TraceItemProvider(this);
		}

		return traceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceRecordItemProvider traceRecordItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTraceRecordAdapter() {
		if (traceRecordItemProvider == null) {
			traceRecordItemProvider = new TraceRecordItemProvider(this);
		}

		return traceRecordItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarParameterValueItemProvider varParameterValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVarParameterValueAdapter() {
		if (varParameterValueItemProvider == null) {
			varParameterValueItemProvider = new VarParameterValueItemProvider(this);
		}

		return varParameterValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingOperationToTraceRecordMapEntryItemProvider mappingOperationToTraceRecordMapEntryItemProvider;

	/**
	 * This creates an adapter for a {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappingOperationToTraceRecordMapEntryAdapter() {
		if (mappingOperationToTraceRecordMapEntryItemProvider == null) {
			mappingOperationToTraceRecordMapEntryItemProvider = new MappingOperationToTraceRecordMapEntryItemProvider(this);
		}

		return mappingOperationToTraceRecordMapEntryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.m2m.internal.qvt.oml.trace.EMappingOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMappingOperationItemProvider eMappingOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.EMappingOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEMappingOperationAdapter() {
		if (eMappingOperationItemProvider == null) {
			eMappingOperationItemProvider = new EMappingOperationItemProvider(this);
		}

		return eMappingOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.m2m.internal.qvt.oml.trace.EValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EValueItemProvider eValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.EValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEValueAdapter() {
		if (eValueItemProvider == null) {
			eValueItemProvider = new EValueItemProvider(this);
		}

		return eValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.m2m.internal.qvt.oml.trace.ETuplePartValue} instances.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ETuplePartValueItemProvider eTuplePartValueItemProvider;

    /**
	 * This creates an adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.ETuplePartValue}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Adapter createETuplePartValueAdapter() {
		if (eTuplePartValueItemProvider == null) {
			eTuplePartValueItemProvider = new ETuplePartValueItemProvider(this);
		}

		return eTuplePartValueItemProvider;
	}

    /**
	 * This keeps track of the one adapter used for all {@link org.eclipse.m2m.internal.qvt.oml.trace.EMappingContext} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMappingContextItemProvider eMappingContextItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.EMappingContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEMappingContextAdapter() {
		if (eMappingContextItemProvider == null) {
			eMappingContextItemProvider = new EMappingContextItemProvider(this);
		}

		return eMappingContextItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.m2m.internal.qvt.oml.trace.EMappingParameters} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMappingParametersItemProvider eMappingParametersItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.EMappingParameters}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEMappingParametersAdapter() {
		if (eMappingParametersItemProvider == null) {
			eMappingParametersItemProvider = new EMappingParametersItemProvider(this);
		}

		return eMappingParametersItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.m2m.internal.qvt.oml.trace.EMappingResults} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMappingResultsItemProvider eMappingResultsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.m2m.internal.qvt.oml.trace.EMappingResults}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEMappingResultsAdapter() {
		if (eMappingResultsItemProvider == null) {
			eMappingResultsItemProvider = new EMappingResultsItemProvider(this);
		}

		return eMappingResultsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectToTraceRecordMapEntryItemProvider objectToTraceRecordMapEntryItemProvider;

	/**
	 * This creates an adapter for a {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createObjectToTraceRecordMapEntryAdapter() {
		if (objectToTraceRecordMapEntryItemProvider == null) {
			objectToTraceRecordMapEntryItemProvider = new ObjectToTraceRecordMapEntryItemProvider(this);
		}

		return objectToTraceRecordMapEntryItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (traceItemProvider != null) traceItemProvider.dispose();
		if (traceRecordItemProvider != null) traceRecordItemProvider.dispose();
		if (varParameterValueItemProvider != null) varParameterValueItemProvider.dispose();
		if (mappingOperationToTraceRecordMapEntryItemProvider != null) mappingOperationToTraceRecordMapEntryItemProvider.dispose();
		if (eMappingOperationItemProvider != null) eMappingOperationItemProvider.dispose();
		if (eValueItemProvider != null) eValueItemProvider.dispose();
		if (eTuplePartValueItemProvider != null) eTuplePartValueItemProvider.dispose();
		if (eMappingContextItemProvider != null) eMappingContextItemProvider.dispose();
		if (eMappingParametersItemProvider != null) eMappingParametersItemProvider.dispose();
		if (eMappingResultsItemProvider != null) eMappingResultsItemProvider.dispose();
		if (objectToTraceRecordMapEntryItemProvider != null) objectToTraceRecordMapEntryItemProvider.dispose();
	}

}
