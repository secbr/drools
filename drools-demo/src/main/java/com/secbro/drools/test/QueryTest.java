package com.secbro.drools.test;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

/**
 * Created by zhuzs on 2017/8/20.
 */
public class QueryTest extends BaseTest {

    @Test
    public void queryTest() {
        KieSession kieSession = this.getKieSession("query-test-group1");

        Person p1 = new Person();
        p1.setAge(29);
        Person p2 = new Person();
        p2.setAge(40);

        kieSession.insert(p1);
        kieSession.insert(p2);
        int count = kieSession.fireAllRules();
        System.out.println("Fire " +count + " rule(s)!");

        QueryResults results = kieSession.getQueryResults("query-1");
        System.out.println("results size is " + results.size());
        for(QueryResultsRow row : results){
            Person person = (Person) row.get("$person");
            System.out.println("Person from WM, age : " + person.getAge());
        }

        kieSession.dispose();
    }

    @Test
    public void queryWithParamTest() {
        KieSession kieSession = this.getKieSession("query-test-group1");

        Person p1 = new Person();
        p1.setAge(29);
        p1.setName("Ross");
        Person p2 = new Person();
        p2.setAge(40);
        p2.setName("Tom");

        kieSession.insert(p1);
        kieSession.insert(p2);
        int count = kieSession.fireAllRules();
        System.out.println("Fire " +count + " rule(s)!");

        QueryResults results = kieSession.getQueryResults("query-2","Tom");
        System.out.println("results size is " + results.size());
        for(QueryResultsRow row : results){
            Person person = (Person) row.get("$person");
            System.out.println("Person from WM, age : " + person.getAge() + "; name :" + person.getName());
        }

        kieSession.dispose();
    }
}
