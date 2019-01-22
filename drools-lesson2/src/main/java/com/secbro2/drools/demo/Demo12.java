package com.secbro2.drools.demo;

import org.kie.api.KieBase;
import org.kie.api.event.kiebase.*;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

/**
 * KieBase Events
 *
 * @author zzs
 */
public class Demo12 extends BaseDemo {

	public static void main(String[] args) {
		KieHelper kieHelper = new KieHelper();
		kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/chapter4.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/chapter5.drl"), ResourceType.DRL);

		KieBase kieBase = kieHelper.build();
		kieBase.addEventListener(new DefaultKieBaseEventListener(){
			@Override
			public void beforeKiePackageRemoved(BeforeKiePackageRemovedEvent event) {
				super.beforeKiePackageRemoved(event);
				String packageName = event.getKiePackage().getName();
				System.out.println("beforeKiePackageRemoved : " + packageName);
			}
		});

		kieBase.removeKiePackage("com.rules");
		KieSession kieSession = kieBase.newKieSession();
		kieSession.fireAllRules();

	}
}
