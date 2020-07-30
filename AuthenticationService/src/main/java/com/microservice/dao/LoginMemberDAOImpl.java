package com.microservice.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.microservice.domain.LoginMember;

@Component
public class LoginMemberDAOImpl implements LoginMemberDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void saveMember(LoginMember member) {
		// TODO Auto-generated method stub

	}
	@Override
	public Collection<LoginMember> getAllmembers() {
		return jdbcTemplate.query("Select * from loginmember", 
				new BeanPropertyRowMapper<LoginMember>(LoginMember.class));
	}

	@Override
	public String getLoginMemberUsername(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateToken(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
