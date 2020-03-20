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
public class TestMultiFact {

	@Test
	public void checkDrl2() {
		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
		String drl = compiler.compile(ResourceFactory.newClassPathResource("com/decision8/decision8.xls"),
				InputType.XLS);
		System.out.println(drl);
	}

	@Test
	public void testDecision() {

		KieContainer container = KieServices.get().getKieClasspathContainer();

		Person person = new Person();
		person.setAge(25);
		person.setName("Tom");

		Address address = new Address();
		address.setCountry("China");
		address.setCity("BeiJing");

		KieSession kieSession = container.newKieSession("decision-rules8");

		kieSession.insert(person);
		kieSession.insert(address);

		int count = kieSession.fireAllRules();

		log.info("Fired {} rules!", count);
		kieSession.dispose();
	}
}
