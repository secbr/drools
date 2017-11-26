package com.secbro.drools.chapter31;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class ModifyTest extends BaseTest{

    @Test
    public void testModify(){
        KieSession kieSession = this.getKieSessionBySessionName("modifyDemo-rules");

        Person p = new Person();
        p.setAge(21);

        kieSession.insert(p);

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
