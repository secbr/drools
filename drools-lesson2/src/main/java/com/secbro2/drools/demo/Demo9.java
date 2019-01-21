package com.secbro2.drools.demo;

import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class Demo9 extends BaseDemo {

	public static void main(String[] args) {
		KieSession kieSession = getKieSession("test-global");
		GlobalService globalService = new GlobalService();
		kieSession.setGlobal("globalService", globalService);

		Person p = new Person(1,"Tom");

		kieSession.insert(p);
		int count = kieSession.fireAllRules();

		System.out.println("Fire " + count + " rules!");

	}
}
