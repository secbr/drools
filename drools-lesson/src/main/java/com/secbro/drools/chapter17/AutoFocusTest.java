package com.secbro.drools.chapter17;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class AutoFocusTest extends BaseTest{

    @Test
    public void testAutoFocus(){
        KieSession kieSession = this.getKieSessionBySessionName("autoFocus-rules");
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
