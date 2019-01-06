package com.secbro2.drools.chapter4;

import com.secbro2.drools.chapter3.Chapter3;
import org.jboss.weld.environment.se.Weld;
import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

/**
 * @author zzs
 */
public class Chapter4 {


	@KSession
	KieSession kieSession;

	@Inject
	Chapter4(KieSession kieSession){
		this.kieSession = kieSession;
	}

	public static void main(String[] args) {

		/*Weld weld = new Weld();
		Chapter4 chapter4 = weld.initialize().instance().select(Chapter4.class).get();
		chapter4.doFire();*/

		SeContainer seContainer = null;
		try {
			seContainer = SeContainerInitializer.newInstance().initialize();

			Chapter4 chapter4 = seContainer.select(Chapter4.class).get();
			chapter4.doFire();

		} finally {
			if (seContainer != null && seContainer.isRunning()) {
				seContainer.close();
			}
		}
	}


	/*public static void main(String[] args) {
		KieServices kieServices = KieServices.Factory.get();

		KieContainer container = kieServices.getKieClasspathContainer();

		KieSession kieSession = container.newKieSession();

//		kieSession.insert()

		int nums = kieSession.fireAllRules();

		System.out.println("Fire " + nums + " rules!");
	}*/

	private void doFire(){
//		kieSession.insert()
		int nums = kieSession.fireAllRules();
		System.out.println("Fire " + nums + " rules!");
	}
}
