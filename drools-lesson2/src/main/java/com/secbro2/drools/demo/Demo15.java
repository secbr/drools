package com.secbro2.drools.demo;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * template xls
 *
 * @author zzs
 */
public class Demo15 extends BaseDemo {

	public static void main(String[] args) {

		KieServices kieServices = KieServices.Factory.get();
		KieBase kieBase = kieServices.getKieClasspathContainer().getKieBase("test-template");

		KieSession kieSession = kieBase.newKieSession();

		Person p = new Person(2,"");
		kieSession.insert(p);

		kieSession.fireAllRules();

		System.out.println(p.getUsername());

	}
}
