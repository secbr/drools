package com.secbro.drools.chapter28;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zhuzs
 */
public class InsertTest extends BaseTest{

    @Test
    public void testInsert(){
        KieSession kieSession = this.getKieSessionBySessionName("insertDemo-rules");

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
