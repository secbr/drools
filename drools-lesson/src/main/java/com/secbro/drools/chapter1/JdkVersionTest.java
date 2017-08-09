package com.secbro.drools.chapter1;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * Created by zhuzs on 2017/8/9.
 */
public class JdkVersionTest extends BaseTest{

    @Test
    public void testJdkVersion(){
        KieSession kieSession = getKieSession();
        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rules!");
    }
}
