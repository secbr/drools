package com.secbro.drools.chapter5;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.StatelessKieSession;

import java.util.ArrayList;
import java.util.List;

public class StatelessSessionTest extends BaseTest{

    @Test
    public void testStateLessSession(){
        StatelessKieSession kieSession = this.getStatelessKieSession();
        List<Person> list = new ArrayList<>();

        Person p = new Person();
        p.setAge(35);
        list.add(p);
        Person p1 = new Person();
        p1.setAge(20);
        list.add(p1);
        kieSession.execute(list);
    }
}
