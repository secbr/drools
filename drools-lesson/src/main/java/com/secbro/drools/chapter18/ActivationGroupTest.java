package com.secbro.drools.chapter18;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class ActivationGroupTest extends BaseTest{

    @Test
    public void testActivationGroup(){

        KieSession kieSession = this.getKieSessionBySessionName("activationGroup-rules");
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
