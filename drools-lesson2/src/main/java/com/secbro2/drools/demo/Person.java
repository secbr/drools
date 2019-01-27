package com.secbro2.drools.demo;

/**
 * @author zzs
 */
public class Person {

	private Integer id;

	private String username;

	private Integer age;

	public Person(){
	}

	public Person(Integer id,String username){
		this.id = id;
		this.username = username;
	}

	public Person(Integer id,String username,Integer age){
		this.id = id;
		this.username = username;
		this.age = age;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
