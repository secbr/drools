package com.secbro2.drools.demo;

/**
 * @author zzs
 */
public class GlobalService {

	/**
	 * 是否执行
	 * @return
	 */
	public boolean isProcess() {
		System.out.println("isProcess：true");
		return true;
	}

	public void insertObject(Person person){
		System.out.println("insert person into database " + person);
	}
}
