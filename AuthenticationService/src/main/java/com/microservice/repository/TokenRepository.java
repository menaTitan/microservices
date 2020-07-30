package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.domain.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
	
	public Token findByToken(String token);

}
