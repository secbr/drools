package com.secbro.drools.chapter23;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class LhsTest extends BaseTest{

    @Test
    public void testLhs(){
        KieSession kieSession = this.getKieSessionBySessionName("lhs-rules");

        Person person = new Person();
        person.setAge(10);

        Person person1 = new Person();
        person1.setAge(15);

        kieSession.insert(person1);
        kieSession.insert(person);


        kieSession.fireAllRules();
        kieSession.dispose();

    }
}
