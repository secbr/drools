package com.secbro.drools.chapter14;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class LockOnActiveTest extends BaseTest{

    @Test
    public void testLockOnActive(){
        KieSession kieSession = this.getKieSessionBySessionName("lock-on-active-rules");

        Person p = new Person();
        p.setAge(19);

        kieSession.insert(p);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
