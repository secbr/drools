package com.secbro2.drools.chapter7;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class Chapter7 {

	public static void main(String[] args) {
		KieServices kieServices = KieServices.Factory.get();

		KieContainer container = kieServices.newKieContainer(kieServices.newReleaseId("com.secbro2","drools-rules","1.0-SNAPSHOT"));

		KieSession kieSession = container.newKieSession("all-kieSession-1");

		int nums = kieSession.fireAllRules();

		System.out.println("Fire " + nums + " rules!");
	}
}
