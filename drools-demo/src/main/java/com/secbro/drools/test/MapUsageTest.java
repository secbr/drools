package com.secbro.drools.test;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Person;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

/**
 * Map usage
 * Created by zhuzs on 2017/8/31.
 */
public class MapUsageTest extends BaseTest {

    @Test
    public void testMapUsage() {
        KieSession kieSession = this.getKieSession("map-group");

        Map<String, Person> map = new HashMap<>();
        Person p1 = new Person();
        p1.setAge(10);
        map.put("p1",p1);

        Person p2 = new Person();
        p2.setAge(20);
        map.put("p2",p2);

        kieSession.insert(map);

        int count = kieSession.fireAllRules();
        System.out.println("Fire " + count + " rule(s)!");

    }
}
