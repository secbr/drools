package com.secbro2.drools.demo;

import com.secbro2.drools.entity.Company;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * DROOLS规则引擎-判断集合是否包含集合
 * <br>
 * 相关文章链接：http://www.choupangxia.com/2019/07/14/drools%e8%a7%84%e5%88%99%e5%bc%95%e6%93%8e-%e5%88%a4%e6%96%ad%e9%9b%86%e5%90%88%e6%98%af%e5%90%a6%e5%8c%85%e5%90%ab%e9%9b%86%e5%90%88/
 * @author sec
 * @version 1.0
 * @date 2019/7/14 2:46 PM
 **/
public class CompareCollectionDemo extends BaseDemo{

	public static void main(String[] args) {

		KieSession kieSession = getKieSession("compareList");

		Company company = new Company();
		List<String> targetList = new ArrayList<>();
		targetList.add("教育");
		targetList.add("P2P");
		company.setScopes(targetList);

		List<String> blackList = new ArrayList<>();
		blackList.add("房地产");
		blackList.add("游戏");
		blackList.add("P2P");

		kieSession.insert(company);
		kieSession.insert(blackList);

		kieSession.fireAllRules();

	}
}
