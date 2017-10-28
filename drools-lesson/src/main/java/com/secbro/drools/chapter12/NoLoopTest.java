package com.secbro.drools.chapter12;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class NoLoopTest extends BaseTest{

    @Test
    public void testNoLoop(){
        KieSession kieSession = this.getKieSessionBySessionName("no-loop-rules");

        Person p = new Person();
        p.setAge(5);

        kieSession.insert(p);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
