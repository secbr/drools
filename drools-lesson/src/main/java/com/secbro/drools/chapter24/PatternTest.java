package com.secbro.drools.chapter24;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Car;
import com.secbro.drools.model.Person;
import com.secbro.drools.model.SubPerson;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class PatternTest extends BaseTest{

    @Test
    public void testPattern(){
        KieSession kieSession = this.getKieSessionBySessionName("pattern-rules");

        Car car = new Car();
        SubPerson subPerson = new SubPerson();
        subPerson.setAge(10);
        car.setSubPerson(subPerson);

//        Person person = new Person();
        kieSession.insert(car);

        kieSession.fireAllRules();
        kieSession.dispose();

    }
}
