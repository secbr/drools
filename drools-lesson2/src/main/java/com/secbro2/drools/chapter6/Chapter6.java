package com.secbro2.drools.chapter6;

import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.cdi.KContainer;
import org.kie.api.runtime.KieContainer;

import java.util.Collection;
import java.util.List;

/**
 * @author zzs
 */
public class Chapter6 {

	public static void main(String[] args) {
		KieServices kieServices = KieServices.Factory.get();

		KieContainer container = kieServices.getKieClasspathContainer();

		Results results = container.verify();
		List<Message> messages = results.getMessages();
		System.out.println("messages size:" + messages.size());
		for (Message msg : messages) {
			System.out.println("level:" + msg.getLevel() + ";text=" + msg.getText());
		}

		Collection<String> kieBaseNames = container.getKieBaseNames();
		for(String kieBaseName : kieBaseNames){
			System.out.println("kieBaseName----" + kieBaseName);
			Collection<String> kieSessionNamesInKieBase = container.getKieSessionNamesInKieBase(kieBaseName);
			for(String kieSession : kieSessionNamesInKieBase){
				System.out.println("kieSession-----" + kieSession);
			}
		}


	}
}
