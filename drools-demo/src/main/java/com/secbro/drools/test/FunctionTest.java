package com.secbro.drools.test;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * Created by zhuzs on 2017/8/22.
 */
public class FunctionTest extends BaseTest{


    @Test
    public void testFunction(){
        KieSession kieSession = this.getKieSession("function-group");
        int count = kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("Fire " + count + " rule(s)!");
    }
}
