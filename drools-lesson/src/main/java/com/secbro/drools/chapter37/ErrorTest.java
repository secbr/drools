package com.secbro.drools.chapter37;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class ErrorTest extends BaseTest{

    @Test
    public void testError(){
        KieSession kieSession = this.getKieSessionBySessionName("error-rules");

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
