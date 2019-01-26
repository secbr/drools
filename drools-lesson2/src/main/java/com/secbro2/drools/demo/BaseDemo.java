package com.secbro2.drools.demo;

import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import java.util.List;

/**
 * @author zzs
 */
public class BaseDemo {

	protected static KieSession getKieSession() {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer container = kieServices.getKieClasspathContainer();
		return container.newKieSession("all-kieSession");
	}

	protected static KieSession getKieSession(String sessionName) {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer container = kieServices.getKieClasspathContainer();
		return container.newKieSession(sessionName);
	}

	protected static KieSession getKieSessionByDrl(String drlContent) {

		KieHelper kieHelper = new KieHelper();
		kieHelper.addContent(drlContent, ResourceType.DRL);

		Results verify = kieHelper.verify();
		boolean hasMessages = verify.hasMessages(Message.Level.WARNING, Message.Level.ERROR);
		if (hasMessages) {
			List<Message> messages = verify.getMessages(Message.Level.WARNING, Message.Level.ERROR);
			for (Message message : messages) {
				System.out.println("ERROR : " + message.getText());
			}

			throw new RuntimeException("verify has errors!");
		}

		return kieHelper.build().newKieSession();
	}

}
