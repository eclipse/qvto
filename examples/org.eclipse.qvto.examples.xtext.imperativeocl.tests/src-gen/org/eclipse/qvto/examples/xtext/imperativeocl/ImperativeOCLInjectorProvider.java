/*
 * generated by Xtext
 */
package org.eclipse.qvto.examples.xtext.imperativeocl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.junit4.GlobalRegistries;
import org.eclipse.xtext.junit4.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.IRegistryConfigurator;

public class ImperativeOCLInjectorProvider implements IInjectorProvider, IRegistryConfigurator {

	protected GlobalStateMemento stateBeforeInjectorCreation;
	protected GlobalStateMemento stateAfterInjectorCreation;
	protected Injector injector;

	static {
		GlobalRegistries.initializeDefaults();
	}

	@Override
	public Injector getInjector()
	{
		if (injector == null) {
			stateBeforeInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
			this.injector = internalCreateInjector();
			stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
		}
		return injector;
	}

	protected Injector internalCreateInjector() {
		return new ImperativeOCLStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(createRuntimeModule());
			}
		}.createInjectorAndDoEMFRegistration();
	}

	protected ImperativeOCLRuntimeModule createRuntimeModule() {
		// make it work also with Maven/Tycho and OSGI
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=493672
		return new ImperativeOCLRuntimeModule() {
			@Override
			public ClassLoader bindClassLoaderToInstance() {
				return ImperativeOCLInjectorProvider.class
						.getClassLoader();
			}
		};
	}

	@Override
	public void restoreRegistry() {
		stateBeforeInjectorCreation.restoreGlobalState();
	}

	@Override
	public void setupRegistry() {
		getInjector();
		stateAfterInjectorCreation.restoreGlobalState();
	}
}
