package com.secbro2.drools.demo;

import org.kie.api.runtime.Channel;

/**
 * @author zzs
 */
public class ChannelService implements Channel {
	@Override
	public void send(Object object) {
		System.out.println(" send object : " + object);
	}
}
