package com.secbro.drools.chapter30;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * @author zhuzs
 */
public class DeleteTest extends BaseTest{

    @Test
    public void testDelete(){
        KieSession kieSession = this.getKieSessionBySessionName("deleteDemo-rules");

        Person p = new Person();
        p.setAge(21);
        FactHandle factHandle = kieSession.insert(p);
        kieSession.delete(factHandle);

        kieSession.fireAllRules();

        kieSession.dispose();
    }
}
