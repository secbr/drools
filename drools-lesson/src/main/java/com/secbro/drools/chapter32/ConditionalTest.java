package com.secbro.drools.chapter32;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Car;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class ConditionalTest extends BaseTest{

    @Test
    public void test(){
        KieSession kieSession = this.getKieSessionBySessionName("conditional-rules");

        Person p = new Person();
        p.setAge(19);
        Car car = new Car();
        car.setDiscount(80);

        kieSession.insert(p);
        kieSession.insert(car);

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
