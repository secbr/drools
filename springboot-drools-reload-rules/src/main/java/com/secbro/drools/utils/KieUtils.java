package com.secbro.drools.utils;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 你的支持是我努力的最大动力！社区的建立离不开你的支持。
 * 此系列课程正在持续更新中，相关讨论QQ（593177274）已经建立，欢迎大家加入讨论。
 * 本人博客地址：http://blog.csdn.net/wo541075754
 */
public class KieUtils {

    private static KieContainer kieContainer;

    private static KieSession kieSession;

    public static KieContainer getKieContainer() {
        return kieContainer;
    }

    public static void setKieContainer(KieContainer kieContainer) {
        KieUtils.kieContainer = kieContainer;
        kieSession = kieContainer.newKieSession();
    }

    public static KieSession getKieSession() {
        return kieSession;
    }

    public static void setKieSession(KieSession kieSession) {
        KieUtils.kieSession = kieSession;
    }
}
