package com.secbro.drools.chapter35;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class GlobalTest extends BaseTest{

    @Test
    public void testGlobal(){
        KieSession kieSession = this.getKieSessionBySessionName("global-rules");

        EmailService emailService = new EmailService();
        kieSession.setGlobal("emailService",emailService);

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
