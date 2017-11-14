package com.secbro.drools.chapter25;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAndListTest extends BaseTest{

    @Test
    public void testMapAndList(){
        KieSession kieSession = this.getKieSessionBySessionName("mapAndList-rules");

        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);

        List<Person> list = new ArrayList<>();
        Person p = new Person();
        p.setAge(18);
        list.add(p);
        Person p1 = new Person();
        p1.setAge(20);
        list.add(p1);

        kieSession.insert(map);
        kieSession.insert(list);

        kieSession.fireAllRules();
        kieSession.dispose();

    }
}
