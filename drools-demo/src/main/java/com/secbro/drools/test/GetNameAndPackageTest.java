package com.secbro.drools.test;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * Created by zhuzs on 2017/8/11.
 */
public class GetNameAndPackageTest extends BaseTest{

    @Test
    public void test(){
        KieSession kieSession = this.getKieSession("Name and package");
        int count = kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("Fire " + count + " rule(s)!");

    }
}
