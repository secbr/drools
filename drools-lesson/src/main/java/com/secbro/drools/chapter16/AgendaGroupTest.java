package com.secbro.drools.chapter16;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class AgendaGroupTest extends BaseTest{

    @Test
    public void testAgendaGroup(){

        KieSession kieSession = this.getKieSessionBySessionName("agendaGroup-rules");
        kieSession.getAgenda().getAgendaGroup("agenda-group-test").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
