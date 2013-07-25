/*
* generated by Xtext
*/
package org.eclipse.qvto.examples.xtext.qvtoperational.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class})
public class AbstractQVTOperationalJavaValidator extends org.eclipse.qvto.examples.xtext.imperativeocl.validation.ImperativeOCLJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/qvt/pivot/1.0/QVTOperationalCS"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/3.1.0/BaseCST"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/3.1.0/EssentialOCLCST"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/qvt/pivot/1.0/ImperativeOCLCS"));
		return result;
	}

}
