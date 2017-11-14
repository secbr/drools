package com.secbro.drools.chapter20;

import com.secbro.drools.BaseTest;
import com.secbro.drools.model.Server;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class TimerTest extends BaseTest{

    @Test
    public void testTimer() throws InterruptedException {

        KieSession kieSession = this.getKieSessionBySessionName("timerTest-rules");

        Server server = new Server();
        server.setTimes(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                kieSession.fireUntilHalt();
            }
        }).start();

        FactHandle factHandle = kieSession.insert(server);
        for (int i=1; i<10; i++){
            Thread.sleep(1000);
            server.setTimes(i);
            kieSession.update(factHandle,server);
        }

        Thread.sleep(3000);
        kieSession.halt();

        System.out.println("server尝试结果：" + server.getResult());

    }
}
