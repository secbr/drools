package com.secbro2.drools.demo;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

/**
 * KieHelper
 *
 * @author zzs
 */
public class KieHelperDemo extends BaseDemo {

	public static void main(String[] args) {

		KieHelper kieHelper = new KieHelper();
		kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/chapter4.drl"), ResourceType.DRL);

		/*kieHelper.addContent("package com.rules\n" +
				"\n" +
				"rule \"chapter4\"\n" +
				"\n" +
				"when\n" +
				"\n" +
				"then\n" +
				"\n" +
				"System.out.println(\"Fire the default rules!\");\n" +
				"end",ResourceType.DRL);*/

		KieBase kieBase = kieHelper.build();
		KieSession kieSession = kieBase.newKieSession();
		kieSession.fireAllRules();

		kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/chapter5.drl"), ResourceType.DRL);
		kieBase = kieHelper.build();
		kieSession = kieBase.newKieSession();
		kieSession.fireAllRules();

	}
}
