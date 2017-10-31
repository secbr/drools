package com.secbro.drools.chapter19;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class DateEffectiveTest extends BaseTest{

    @Test
    public void testDateEffective(){
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm");
        KieSession kieSession = this.getKieSessionBySessionName("dateEffective-rules");
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
