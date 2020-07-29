package com.microservice.domain;

public class LoginMember {
	
	private String memberPassword;
	private String memberUsername;
	
	
	public String getMemberUsername() {
		return memberUsername;
	}
	public void setMemberUsername(String memberUsername) {
		this.memberUsername = memberUsername;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public LoginMember(String memberPassword, String memberUsername) {
		super();
		this.memberPassword = memberPassword;
		this.memberUsername = memberUsername;
	}

}
