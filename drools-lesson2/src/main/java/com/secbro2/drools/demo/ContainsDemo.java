package com.secbro2.drools.demo;

import com.secbro2.drools.entity.Corporation;
import com.secbro2.drools.entity.Scope;
import org.kie.api.runtime.KieSession;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sec
 * @version 1.0
 * @date 2019/7/31 8:30 PM
 **/
public class ContainsDemo extends BaseDemo {

	public static void main(String[] args) {

		KieSession kieSession = getKieSession("containsVar");

		Corporation corporation = new Corporation();
		Set<Scope> scopes = new HashSet<>();
		scopes.add(new Scope("P2P"));
		scopes.add(new Scope("金融"));
		scopes.add(new Scope("区块链"));
		corporation.setScopes(scopes);

		Scope scope = new Scope("区块链");

		kieSession.insert(corporation);
		kieSession.insert(scope);

		kieSession.fireAllRules();

	}
}
