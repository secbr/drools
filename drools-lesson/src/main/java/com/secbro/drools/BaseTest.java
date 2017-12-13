package com.secbro.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

/**
 * Created by zhuzs on 2017/8/9.
 */
public class BaseTest {

    protected KieSession getKieSession() {
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        return kieSession;
    }

    protected KieSession getKieSessionBySessionName(String sessionName) {
        KieContainer kieContainer = getKieContainer();
        KieSession kieSession = kieContainer.newKieSession(sessionName);
        return kieSession;
    }

    protected KieContainer getKieContainer(){
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        return kieContainer;
    }

    protected KieSession getKieSession(String agendaGroupName) {
        KieSession kieSession = getKieSession();
        kieSession.getAgenda().getAgendaGroup(agendaGroupName).setFocus();
        return kieSession;
    }

    protected StatelessKieSession getStatelessKieSession() {
        KieContainer kieContainer = getKieContainer();
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession("stateless-rules");

        return kieSession;
    }
}
