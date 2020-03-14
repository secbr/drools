package decision;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/12 10:51 AM
 **/
@Slf4j
public class TestDecision2 {

	@Test
	public void testDecision() {

		KieContainer container = KieServices.get().getKieClasspathContainer();
		KieSession kieSession = container.newKieSession();

		int count = kieSession.fireAllRules();
		log.info("Fired {} rules!",count);
		kieSession.dispose();
	}
}
