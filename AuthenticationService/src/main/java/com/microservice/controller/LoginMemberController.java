package com.microservice.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dao.LoginMemberDAO;
import com.microservice.dao.LoginMemberDAOImpl;
import com.microservice.domain.LoginMember;


@RestController
public class LoginMemberController {
	private LoginMemberDAO loginMemberDAO = new LoginMemberDAOImpl();
	
	@GetMapping("/members")
	public Collection<LoginMember> getLoginMembers() {
		return loginMemberDAO.getAllmembers();
	}


}
