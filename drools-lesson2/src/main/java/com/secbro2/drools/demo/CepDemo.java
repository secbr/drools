package com.secbro2.drools.demo;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class CepDemo {

	public static void main(String[] args) throws InterruptedException {

		KieServices kieServices = KieServices.Factory.get();

		KieBaseConfiguration config = kieServices.newKieBaseConfiguration();
		config.setOption(EventProcessingOption.STREAM);

		KieContainer container = kieServices.getKieClasspathContainer();
//		KieBase kieBase = container.getKieBase("test-cep");
		KieBase kieBase = container.newKieBase("test-cep",config);

		KieSession kieSession = kieBase.newKieSession();

		Person p1 = new Person(1,"Tom");
		Person p2 = new Person(2,"Lucy");
		kieSession.insert(p1);

		Thread.sleep(3000);
		kieSession.insert(p2);

		int count = kieSession.fireAllRules();

		System.out.println("Fire " + count + " rules!");
	}
}
