package com.secbro.drools.chapter39;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class NewTypeTest extends BaseTest{

    @Test
    public void testNewType(){
        KieSession kieSession = this.getKieSessionBySessionName("new-type-rules");

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
