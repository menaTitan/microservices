package com.microservice.dao;

import java.util.Collection;

import com.microservice.AuthenticationException;
import com.microservice.domain.LoginMember;



public interface LoginMemberDAO {
	public void saveMember(LoginMember member);
	public Collection<LoginMember> getAllmembers();
	public String getLoginMemberUsername(String token) throws AuthenticationException;
	public String generateToken(String username, String password) throws AuthenticationException;
}
