package com.secbro2.drools.entity;

import lombok.Data;

/**
 * @author sec
 * @version 1.0
 * @date 2019/7/31 8:36 PM
 **/
@Data
public class Scope {


	public Scope(String scope){
		this.scope = scope;
	}

	private String scope;

}
