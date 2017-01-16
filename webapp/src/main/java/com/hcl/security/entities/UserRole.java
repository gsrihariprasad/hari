package com.hcl.security.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRole {
	
	private Long userroleid;	
	private Long userid;	
	private String role;
	
	public Long getUserroleid() {
		return userroleid;
	}
	public void setUserroleid(Long userroleid) {
		this.userroleid = userroleid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
