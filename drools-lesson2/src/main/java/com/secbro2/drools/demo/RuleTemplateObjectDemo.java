package com.secbro2.drools.demo;

import org.drools.template.ObjectDataCompiler;
import org.drools.template.jdbc.ResultSetGenerator;
import org.kie.api.runtime.KieSession;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzs
 */
public class RuleTemplateObjectDemo extends BaseDemo {


	public static void main(String[] args) throws SQLException {

		InputStream template = RuleTemplateArrayDemo.class.getResourceAsStream("/com/template/template.drt");

		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1,"Tom"));
		personList.add(new Person(2,"Lucy"));

		ObjectDataCompiler dataCompiler = new ObjectDataCompiler();
		String drl = dataCompiler.compile(personList, template);

		KieSession kieSession = getKieSessionByDrl(drl);

		Person person = new Person(1,"");

		kieSession.insert(person);

		kieSession.fireAllRules();

		System.out.println("Person's username is " + person.getUsername());

		// sql

		/*Connection connection = null;
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select id, username from user ");
		ResultSetGenerator generator = new ResultSetGenerator();
		String drl = generator.compile(resultSet, template);*/


	}

}
