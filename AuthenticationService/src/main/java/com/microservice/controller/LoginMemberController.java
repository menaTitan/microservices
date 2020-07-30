package com.microservice.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.AuthenticationException;
import com.microservice.dao.LoginMemberDAOImpl;
import com.microservice.domain.LoginMember;


@RestController
public class LoginMemberController {
	
	@Autowired
	LoginMemberDAOImpl loginMemberDAO;
	
	@GetMapping("/members")
	public Collection<LoginMember> getLoginMembers() {
		return loginMemberDAO.getAllmembers();
	}
	
	@GetMapping("/token/{token}")
	public String verifyToken(@PathVariable("token") String token) {
		try {
			return loginMemberDAO.getLoginMemberUsername(token);
		} catch (Exception e) {
			if (!(e instanceof AuthenticationException)) {
				e.printStackTrace();
			}
			return e.getMessage();
		}
	}

	@PostMapping("/login")
	public String loginAndGetToken(@RequestBody LoginMember member) {
		try {
			return loginMemberDAO.generateToken(member.getUsername(), member.getPassword());
		} catch (Exception e) {
			if (!(e instanceof AuthenticationException)) {
				e.printStackTrace();
			}
			return e.getMessage();
		}
	}
}
