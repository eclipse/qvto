/**
 */
package org.eclipse.qvto.examples.xtext.imperativeoclcs;

import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ReturnExpCS#getOwnedValue <em>Owned Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage#getReturnExpCS()
 * @model
 * @generated
 */
public interface ReturnExpCS extends ExpCS {
	/**
	 * Returns the value of the '<em><b>Owned Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Value</em>' containment reference.
	 * @see #setOwnedValue(ExpCS)
	 * @see org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage#getReturnExpCS_OwnedValue()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.ReturnExpCS#getOwnedValue <em>Owned Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Value</em>' containment reference.
	 * @see #getOwnedValue()
	 * @generated
	 */
	void setOwnedValue(ExpCS value);

} // ReturnExpCS
