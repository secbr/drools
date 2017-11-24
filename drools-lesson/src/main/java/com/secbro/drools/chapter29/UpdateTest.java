package com.secbro.drools.chapter29;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * @author zhuzs
 */
public class UpdateTest extends BaseTest{

    @Test
    public void testUpdate(){
        KieSession kieSession = this.getKieSessionBySessionName("updateDemo-rules");

        Person p = new Person();
        p.setAge(24);
        FactHandle factHandle = kieSession.insert(p);

        kieSession.fireAllRules();
        p.setAge(25);
        kieSession.update(factHandle,p);

//        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
