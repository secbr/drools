package com.secbro2.drools.demo;

import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

/**
 * @author zzs
 */
public class AccumulateDemo extends BaseDemo {

	public static void main(String[] args) {
		KieHelper kieHelper = new KieHelper();
		kieHelper.addResource(ResourceFactory.newClassPathResource("com/accumu/accumulate.drl"), ResourceType.DRL);

		KieSession kieSession = kieHelper.build().newKieSession();

		Person p1 = new Person(1, "Tom", 19);
		Person p2 = new Person(2, "Lucy", 18);

		kieSession.insert(p1);
		kieSession.insert(p2);

		kieSession.fireAllRules();
	}
}
