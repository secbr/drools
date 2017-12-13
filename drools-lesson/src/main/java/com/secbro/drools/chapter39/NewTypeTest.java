package com.secbro.drools.chapter39;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author zzs
 */
public class NewTypeTest extends BaseTest{

    @Test
    public void testNewType() throws IllegalAccessException, InstantiationException {

        KieContainer kieContainer = this.getKieContainer();
        KieBase kieBase = kieContainer.getKieBase("new-type-kbase");
        FactType factType = kieBase.getFactType("com.newType","Country");
        Object country = factType.newInstance();
        factType.set(country,"name","美国");

        KieSession kieSession = kieContainer.newKieSession("new-type-rules");

        kieSession.insert(country);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
