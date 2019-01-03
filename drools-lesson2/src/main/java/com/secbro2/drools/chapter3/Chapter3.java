package com.secbro2.drools.chapter3;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

/**
 * @author zzs
 */
public class Chapter3 {

	private final DemoService demoService;

	@Inject
	public Chapter3(DemoService demoService) {
		this.demoService = demoService;
	}

	private void print() {
		this.demoService.print();
	}

	public static void main(String[] args) {
		SeContainer seContainer = null;
		try {
			seContainer = SeContainerInitializer.newInstance().initialize();

			Chapter3 chapter3 = seContainer.select(Chapter3.class).get();

			chapter3.print();
		} finally {
			if (seContainer != null && seContainer.isRunning()) {
				seContainer.close();
			}
		}
	}

}
