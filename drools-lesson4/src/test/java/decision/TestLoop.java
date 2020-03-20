package decision;

import com.choupangxia.entity.Address;
import com.choupangxia.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/12 10:51 AM
 **/
@Slf4j
public class TestLoop {

	@Test
	public void checkDrl2() {
		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
		String drl = compiler.compile(ResourceFactory.newClassPathResource("com/decision9/decision9.xls"),
				InputType.XLS);
		System.out.println(drl);
	}

	@Test
	public void testDecision() {

		KieContainer container = KieServices.get().getKieClasspathContainer();

		Person person = new Person();
		person.setAge(24);
		person.setName("Tom");

		KieSession kieSession = container.newKieSession("decision-rules9");

		kieSession.insert(person);
		int count = kieSession.fireAllRules();
		log.info("Person age:{}",person.getAge());
		log.info("Fired {} rules!", count);
		kieSession.dispose();
	}
}
