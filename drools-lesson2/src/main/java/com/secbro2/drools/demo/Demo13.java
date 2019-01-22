package com.secbro2.drools.demo;

import org.drools.core.event.DefaultAgendaEventListener;
import org.drools.core.event.DefaultRuleRuntimeEventListener;
import org.kie.api.KieBase;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

/**
 * KieSession Events
 *
 * @author zzs
 */
public class Demo13 extends BaseDemo {

	public static void main(String[] args) {
		KieHelper kieHelper = new KieHelper();
		kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/chapter4.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/chapter5.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/agenda.drl"), ResourceType.DRL);

		KieBase kieBase = kieHelper.build();
		KieSession kieSession = kieBase.newKieSession();
		kieSession.addEventListener(new DefaultRuleRuntimeEventListener(){
			@Override
			public void objectInserted(final ObjectInsertedEvent event) {
				// intentionally left blank
				System.out.println("objectInserted,username=" + ((Person)event.getObject()).getUsername());
			}
		});

		kieSession.addEventListener(new DefaultAgendaEventListener(){
			@Override
			public void beforeMatchFired(BeforeMatchFiredEvent event) {
				// intentionally left blank
				String ruleName = event.getMatch().getRule().getName();
				System.out.println("beforeMatchFired ruleName=" + ruleName);
			}
		});

		kieSession.insert(new Person(1,"Tom"));

		kieSession.fireAllRules();

	}
}
