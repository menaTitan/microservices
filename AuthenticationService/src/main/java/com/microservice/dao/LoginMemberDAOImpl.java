package com.microservice.dao;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.AuthenticationException;
import com.microservice.domain.LoginMember;
import com.microservice.domain.Token;
import com.microservice.repository.LoginMemberRepository;
import com.microservice.repository.TokenRepository;

@Component
public class LoginMemberDAOImpl implements LoginMemberDAO{

	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired TokenRepository tokenRepository;
	@Autowired LoginMemberRepository memberRepository;
	@PersistenceContext private EntityManager em;
	
	@Override
	public void saveMember(LoginMember member) {
		// TODO Auto-generated method stub

	}
	@Override
	public Collection<LoginMember> getAllmembers() {
		
		return memberRepository.findAll();
		
		/*return jdbcTemplate.query("Select * from loginmember", 
				new BeanPropertyRowMapper<LoginMember>(LoginMember.class));*/
	}

	@Override
	public String getLoginMemberUsername(String token) throws AuthenticationException {
		Token tokenObj = tokenRepository.findByToken(token);
		if (tokenObj.getExpires().before(new Date(System.currentTimeMillis()))) {
			throw new AuthenticationException("Invalid token");
		} else {
			Optional<LoginMember> memberOpt = memberRepository.findById(tokenObj.getId_loginmember());
			LoginMember member = memberOpt.get();
			if (member == null) {
				throw new AuthenticationException("Invalid token");
			} else {
				return member.getUsername();
			}
		}
	}

	@Override
	@Transactional
	public String generateToken(String username, String password) throws AuthenticationException {
		LoginMember member = memberRepository.getByUsername(username);
		if (member != null && password.equals(member.getPassword())) {
			String newToken = Integer.toString((int)(Math.random() * 1000000));
			long expTime = System.currentTimeMillis() + (86400 * 1000);
			Token token = new Token();
			token.setToken(newToken);
			token.setExpires(new Date(expTime));
			token.setId_loginmember(member.getId());
			em.persist(token);
			return newToken;
		} else {
			throw new AuthenticationException("Invalid username or password");
		}
	}

}
