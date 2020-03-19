package decision;

import com.choupangxia.entity.Person;
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
public class TestCondition {

	@Test
	public void checkDrl2() {
		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
		String drl = compiler.compile(ResourceFactory.newClassPathResource("com/decision7/decision7.xls"),
				InputType.XLS);
		System.out.println(drl);
	}

	@Test
	public void testDecision() {

		KieContainer container = KieServices.get().getKieClasspathContainer();

		Person p1 = new Person();
		p1.setAge(10);
		p1.setName("我是青少年");

		Person p2 = new Person();
		p2.setAge(28);
		p2.setName("我是中年人");

		Person p3 = new Person();
		p3.setAge(88);
		p3.setName("我是老年人");


		KieSession kieSession = container.newKieSession("decision-rules7");

		kieSession.insert(p1);
		kieSession.insert(p2);
		kieSession.insert(p3);

		int count = kieSession.fireAllRules();

		log.info("Fired {} rules!", count);
		kieSession.dispose();
	}
}
