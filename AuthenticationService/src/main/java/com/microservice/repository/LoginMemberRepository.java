package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.domain.LoginMember;

@Repository
public interface LoginMemberRepository extends JpaRepository<LoginMember, Integer> {

	public LoginMember getByUsername(String username);
	
}
