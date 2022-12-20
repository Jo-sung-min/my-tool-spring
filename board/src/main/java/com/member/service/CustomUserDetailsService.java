package com.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.member.domain.MemberVO;
import com.member.persistence.MemberMapper;
import com.member.service.domain.CustomUser;

import lombok.extern.log4j.Log4j;
// 스프링 시큐리티의 권한 인증을 처리해주는 비지니스 로직 서비스 클래스
// 시큐리티에서 사용되어지는 UserDetailsService 인터페이스를 
//  구현하는 클래스로 작성
@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	
	@Autowired
	private MemberMapper mapper;
	
	
	//username 을 주면 회원정보를 UserDatails 로 리턴해주는 처리가 되어야한다.
	// 우리가 사용하는 회원정보 (회원테이블)는 MemberVO 이며,
	// 이 메서드가 리턴해주는 타입은 UserDetails 인테페이스이다.
	// -> MemberVO를 UserDetails 타입으로 변환해주는 처리가 필요하다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("loadUserByUsername username:"+ username);
		
		MemberVO vo = mapper.getMember(username);
		log.info("loadUserByUsername vo : "  +vo);
		
		
		return vo==null? null: new CustomUser(vo) ;
	}

}
