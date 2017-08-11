package com.secbro.drools.test;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * Created by zhuzs on 2017/8/11.
 */
public class GlobalTest extends BaseTest{

    @Test
    public void testGlobal(){
        KieSession kieSession = this.getKieSession("test-global-group");
        int count = kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("Fire " + count  + " rule(s)!");
    }
}
