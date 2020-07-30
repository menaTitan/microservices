package com.microservice.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class Token {
	
	@Id private int id_token;
	private int id_loginmember;
	private String token;
	private Date expires;
	
	public Token() {}
	
	public int getId_token() {
		return id_token;
	}
	public void setId_token(int id_token) {
		this.id_token = id_token;
	}
	public int getId_loginmember() {
		return id_loginmember;
	}
	public void setId_loginmember(int id_loginmember) {
		this.id_loginmember = id_loginmember;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
		this.expires = expires;
	}
	
}
