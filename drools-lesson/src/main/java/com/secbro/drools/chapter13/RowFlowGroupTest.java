package com.secbro.drools.chapter13;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

public class RowFlowGroupTest extends BaseTest{

    @Test
    public void testRowFlowGroup(){
        KieSession kieSession = this.getKieSessionBySessionName("ruleFlowGroup-rules");
        kieSession.getAgenda().getAgendaGroup("rule-flow-group-1").setFocus();

        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("rule-flow-group-2").setFocus();
        kieSession.fireAllRules();

        kieSession.getAgenda().getAgendaGroup("rule-flow-group-1").setFocus();
        kieSession.fireAllRules();

        kieSession.getAgenda().getAgendaGroup("rule-flow-group-2").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();

    }
}
