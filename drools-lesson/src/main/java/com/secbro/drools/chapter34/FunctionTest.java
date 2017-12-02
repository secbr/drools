package com.secbro.drools.chapter34;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class FunctionTest extends BaseTest{

    @Test
    public void testFunction(){
        KieSession kieSession = this.getKieSessionBySessionName("function-rules");

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
