package com.secbro2.drools.chapter5;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class Chapter5 {

	public static void main(String[] args) {
		KieServices kieServices = KieServices.Factory.get();

		KieContainer container = kieServices.getKieClasspathContainer();

		KieSession kieSession = container.newKieSession("all-kieSession-1");

		int nums = kieSession.fireAllRules();

		System.out.println("Fire " + nums + " rules!");
	}
}
