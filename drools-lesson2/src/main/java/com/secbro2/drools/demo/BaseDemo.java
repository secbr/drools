package com.secbro2.drools.demo;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class BaseDemo {

	protected static KieSession getKieSession() {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer container = kieServices.getKieClasspathContainer();
		return container.newKieSession("all-kieSession");
	}

	protected static KieSession getKieSession(String sessionName) {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer container = kieServices.getKieClasspathContainer();
		return container.newKieSession(sessionName);
	}
}
