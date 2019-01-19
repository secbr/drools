package com.secbro2.drools.demo;

/**
 * @author zzs
 */
public class Person {

	private Integer id;

	private String username;

	public Person(){
	}

	public Person(Integer id,String username){
		this.id = id;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
