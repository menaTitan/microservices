package com.microservice.dao;

import java.util.Collection;
import java.util.List;

import com.microservice.AuthenticationException;
import com.microservice.domain.LoginMember;



public interface LoginMemberDAO {
	public void saveMember(LoginMember member);
	public String getLoginMemberUsername(String token) throws AuthenticationException;
	public String generateToken(String username, String password) throws AuthenticationException;
	Collection<LoginMember> getMembers(List<Integer> ids);
}
