package com.secbro2.drools.demo;

import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.kie.api.runtime.KieSession;

import java.io.InputStream;

/**
 * @author zzs
 */
public class RuleTemplateArrayDemo extends BaseDemo {


	public static void main(String[] args) {

		InputStream template = RuleTemplateArrayDemo.class.getResourceAsStream("/com/template/template.drt");

		DataProvider dataProvider = new ArrayDataProvider(new String[][]{
				{"1", "Tom"}, {"2", "Lucy"}
		});

		DataProviderCompiler compiler = new DataProviderCompiler();

		String drl = compiler.compile(dataProvider, template);

		KieSession kieSession = getKieSessionByDrl(drl);

		Person person = new Person(1,"");

		kieSession.insert(person);

		kieSession.fireAllRules();

		System.out.println("Person's username is " + person.getUsername());


	}

}
