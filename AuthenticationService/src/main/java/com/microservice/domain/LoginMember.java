package com.microservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "loginmember")
public class LoginMember {
	
	@Id private int id;
	private String password;
	private String username;
	
	public LoginMember() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LoginMember(int memberId, String memberPassword, String memberUsername) {
		super();
		this.id = memberId;
		this.password = memberPassword;
		this.username = memberUsername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
