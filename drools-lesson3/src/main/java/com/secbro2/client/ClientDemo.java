package com.secbro2.client;

import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/8 1:40 PM
 **/
public class ClientDemo {

	public static final String SERVER_URL = "http://127.0.0.1:8080/kie-server/services/rest/server";
	public static final String USERNAME = "kieserver";
	public static final String PASSWORD = "kieserver1!";
	public static final long TIME_OUT = 10000L;
	public static final String KIE_CONTAINER_ID = "FirstProject";

	public static void main(String[] args) {

		// KisService 配置信息设置
		KieServicesConfiguration kieServicesConfiguration =
				KieServicesFactory.newRestConfiguration(SERVER_URL, USERNAME, PASSWORD, TIME_OUT);
		kieServicesConfiguration.setMarshallingFormat(MarshallingFormat.JSON);

		// 创建规则服务客户端
		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);

		RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);

		// 规则输入条件
		String name = "Tom";

		// 命令定义，包含插入数据，执行规则
		KieCommands kieCommands = KieServices.Factory.get().getCommands();
		List<Command<?>> commands = new LinkedList<>();
		commands.add(kieCommands.newInsert(name));
		commands.add(kieCommands.newFireAllRules());

		ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(KIE_CONTAINER_ID,
				kieCommands.newBatchExecution(commands, "hello-session"));

		String msg = results.getMsg();
		System.out.println(msg);
		System.out.println(results.getType());


	}
}
