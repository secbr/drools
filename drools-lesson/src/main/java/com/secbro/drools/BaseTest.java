package com.secbro.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by zhuzs on 2017/8/9.
 */
public class BaseTest {

    protected KieSession getKieSession(){
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        return kieSession;
    }

    protected KieSession getKieSession(String agendaGroupName){
        KieSession kieSession  = getKieSession();
        kieSession.getAgenda().getAgendaGroup(agendaGroupName).setFocus();
        return kieSession;
    }

}
