package com.secbro.drools.chapter33;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

/**
 * @author zzs
 */
public class QueryTest extends BaseTest{

    @Test
    public void testQuery(){
        KieSession kieSession = this.getKieSessionBySessionName("query-rules");

        Person p1 = new Person();
        p1.setAge(20);
        p1.setName("Tom");

        Person p2 = new Person();
        p2.setAge(23);
        p2.setName("Daven");

        kieSession.insert(p1);
        kieSession.insert(p2);

        kieSession.fireAllRules();

        QueryResults queryResults = kieSession.getQueryResults("query-by-age");
        System.out.println("queryResults size is " + queryResults.size());
        for(QueryResultsRow row : queryResults){
            Person person = (Person) row.get("$p1");
            System.out.println("Person name is " + person.getName());
        }

        System.out.println(" ------------------------------------------------------");

        QueryResults queryResults1 = kieSession.getQueryResults("query-by-param",21);
        System.out.println("queryResults1 size is " + queryResults1.size());
        for(QueryResultsRow row : queryResults1){
            Person person = (Person) row.get("$p2");
            System.out.println("Person name is " + person.getName());
        }

        kieSession.dispose();
    }

}
