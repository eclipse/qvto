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
package org.eclipse.m2m.qvt.oml.internal.cst;

import org.eclipse.ocl.cst.CSTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Method CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingMethodCS()
 * @model abstract="true"
 * @generated
 */
public interface MappingMethodCS extends CSTNode {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Mapping Declaration CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Declaration CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Mapping Declaration CS</em>' containment reference.
     * @see #setMappingDeclarationCS(MappingDeclarationCS)
     * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingMethodCS_MappingDeclarationCS()
     * @model containment="true"
     * @generated
     */
	MappingDeclarationCS getMappingDeclarationCS();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapping Declaration CS</em>' containment reference.
     * @see #getMappingDeclarationCS()
     * @generated
     */
	void setMappingDeclarationCS(MappingDeclarationCS value);

} // MappingMethodCS
