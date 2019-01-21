package com.secbro2.drools.demo;

import org.kie.api.runtime.KieSession;

/**
 * channels
 *
 * @author zzs
 */
public class Demo10 extends BaseDemo {

	public static void main(String[] args) {
		KieSession kieSession = getKieSession("test-channel");

		ChannelService channelService = new ChannelService();

		kieSession.registerChannel("test-channel", channelService);

		Person person = new Person(1,"Tom");

		kieSession.insert(person);

		int count = kieSession.fireAllRules();

		System.out.println("Fire " + count + " rules!");

	}
}
