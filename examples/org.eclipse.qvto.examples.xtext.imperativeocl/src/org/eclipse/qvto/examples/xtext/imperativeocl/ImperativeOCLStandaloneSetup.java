/*
* generated by Xtext
*/
package org.eclipse.qvto.examples.xtext.imperativeocl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ImperativeOCLStandaloneSetup extends ImperativeOCLStandaloneSetupGenerated{

	public static void doSetup() {
		new ImperativeOCLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
