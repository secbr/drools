package decision;

import lombok.extern.slf4j.Slf4j;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/12 10:51 AM
 **/
@Slf4j
public class TestAction {

	@Test
	public void checkDrl2() {
		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
		String drl = compiler.compile(ResourceFactory.newClassPathResource("com/decision6/decision6.xls"),
				InputType.XLS);
		System.out.println(drl);
	}

	@Test
	public void testDecision() {

		KieContainer container = KieServices.get().getKieClasspathContainer();
		Results results = container.verify();
		if (results.hasMessages(Message.Level.ERROR)) {
			List<Message> messages = results.getMessages();
			for (Message message : messages) {
				log.info("错误信息:{}", message);
			}
		}

		KieSession kieSession = container.newKieSession("decision-rules6");

		int count = kieSession.fireAllRules();

		log.info("Fired {} rules!", count);
		kieSession.dispose();
	}
}
