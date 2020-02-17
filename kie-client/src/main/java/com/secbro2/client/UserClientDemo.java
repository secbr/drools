package com.secbro2.client;

import com.testspace.firstproject.entity.User;
import com.testspace.firstproject.entity.UserCheckResult;
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
public class UserClientDemo {

	public static final String SERVER_URL = "http://localhost:8080/kie-server/services/rest/server";
	public static final String USERNAME = "kieserver";
	public static final String PASSWORD = "kieserver1!";
	public static final long TIME_OUT = 10000L;
	// 别名
	public static final String KIE_CONTAINER_ID = "FirstProject_1.0.1";
	public static final String KIE_SESSION = "hello-xx-session";

	public static void main(String[] args) {

		// KisService 配置信息设置
		KieServicesConfiguration kieServicesConfiguration =
				KieServicesFactory.newRestConfiguration(SERVER_URL, USERNAME, PASSWORD, TIME_OUT);
		kieServicesConfiguration.setMarshallingFormat(MarshallingFormat.JSON);

		// 创建规则服务客户端
		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
		System.out.println(kieServicesClient.listContainers().getResult().getContainers());

		RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);

		// 规则输入条件
		User user = new User(null,"Tom",12);
		UserCheckResult checkResult = new UserCheckResult();

		// 命令定义，包含插入数据，执行规则
		KieCommands kieCommands = KieServices.Factory.get().getCommands();


		List<Command<?>> commands = new LinkedList<>();
		commands.add(kieCommands.newInsert(user,"user"));
		
		commands.add(kieCommands.newInsert(checkResult,"checkResult"));
		commands.add(kieCommands.newFireAllRules());
		ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(KIE_CONTAINER_ID,
				kieCommands.newBatchExecution(commands,KIE_SESSION));


		ExecutionResults executionResults = results.getResult();

		user = (User) executionResults.getValue("user");
		checkResult = (UserCheckResult) executionResults.getValue("checkResult");
		System.out.println("age:" + user.getAge()+";username:" + user.getUsername());
		System.out.println("code:" + checkResult.getCode()+";message:" + checkResult.getMessage());

	}
}
