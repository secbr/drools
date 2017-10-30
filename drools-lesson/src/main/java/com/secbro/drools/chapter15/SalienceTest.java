package com.secbro.drools.chapter15;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class SalienceTest extends BaseTest{

    @Test
    public void testSalience(){

        KieSession kieSession = this.getKieSessionBySessionName("salience-rules");

        Person person = new Person();
        person.setAge(10);
        kieSession.insert(person);

        kieSession.fireAllRules();
        kieSession.dispose();

    }
}
