package com.secbro2.drools.demo;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class Demo8 {

	public static void main(String[] args) throws InterruptedException {
		KieServices kieServices = KieServices.Factory.get();

		KieContainer container = kieServices.newKieContainer(kieServices.newReleaseId("com.secbro2","drools-rules","1.0-SNAPSHOT"));

		KieScanner kieScanner = kieServices.newKieScanner(container);
		kieScanner.start(1000);

		KieSession kieSession = container.newKieSession("all-kieSession-1");

		while (true){
			Thread.sleep(5000);
			int nums = kieSession.fireAllRules();

			System.out.println("Fire " + nums + " rules!");
		}



	}
}
