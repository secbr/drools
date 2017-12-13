package com.secbro.drools.chapter41;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class MetaTest extends BaseTest{
    @Test
    public void testMeta(){
        KieSession kieSession = this.getKieSessionBySessionName("meta-rules");

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
