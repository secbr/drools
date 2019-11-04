package com.secbro2.drools.logger;

import com.secbro2.drools.demo.BaseDemo;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sec
 * @version 1.0
 * @date 2019/11/3 10:39 PM
 **/
public class LoggerDemo extends BaseDemo {

	private static Logger logger = LoggerFactory.getLogger(LoggerDemo.class);

	public static void main(String[] args) {

		KieSession kieSession = getKieSession("loggerTest");
		kieSession.setGlobal("logger", logger);

		kieSession.insert("abc");

		int count = kieSession.fireAllRules();
		logger.info("触发了" + count + "条规则！");

	}
}
