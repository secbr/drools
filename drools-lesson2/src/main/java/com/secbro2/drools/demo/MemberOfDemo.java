package com.secbro2.drools.demo;

import com.secbro2.drools.entity.Member;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * DROOLS规则引擎-memberOf操作
 * <br>
 * 相关文章链接：https://www.choupangxia.com/2019/07/15/drools%e8%a7%84%e5%88%99%e5%bc%95%e6%93%8e-memberof%e6%93%8d%e4%bd%9c/
 *
 * @author sec
 * @version 1.0
 * @date 2019/7/14 2:46 PM
 **/
public class MemberOfDemo extends BaseDemo {

	public static void main(String[] args) {

		KieSession kieSession = getKieSession("memberOfSession");

		String str = "欢迎张三！";
		List<String> list = new ArrayList<>();
		list.add("欢迎");
		list.add("张三");
		list.add("！");

		Member member = new Member();
		member.setName("张三");

		kieSession.insert(str);
		kieSession.insert(list);
		kieSession.insert(member);

		kieSession.fireAllRules();

	}
}
