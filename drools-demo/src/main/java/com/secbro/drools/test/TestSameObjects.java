package com.secbro.drools.test;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Customer;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * Created by zhuzs on 2017/8/7.
 */
public class TestSameObjects extends BaseTest {

    @Test
    public void testSameObjects() {
        KieSession kieSession = getKieSession("two same objects");

        Customer customer = new Customer();
        customer.setAge(61);
        kieSession.insert(customer);

        Customer customer1 = new Customer();
        customer1.setAge(59);
        kieSession.insert(customer1);

        int count = kieSession.fireAllRules();

        kieSession.dispose();
        System.out.println("Fire " + count + " rules!");
    }
}
