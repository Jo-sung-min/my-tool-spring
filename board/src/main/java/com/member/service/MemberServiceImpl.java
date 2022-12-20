package com.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.member.domain.AuthVO;
import com.member.domain.MemberVO;
import com.member.persistence.MemberMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements MemberService{
	
	
	//비밀번호 암호화를 위한 객체 자동 주입
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder ;
	
	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public int addMember(MemberVO member) {
		log.info("*************service add member pw before: **"+ member.getPw());
		 member.setPw(bcryptPasswordEncoder.encode(member.getPw()));    
		log.info("*************service add member pw after: **"+ member.getPw());
		
		return mapper.addMember(member);
	}

	@Override
	public int addAuth(String auth, String id) {
		int result= -1;
		AuthVO authVO = new AuthVO();
		authVO.setId(id);
		if(auth.equals("member")) {			// 일반 회원 가입시 권한 추가
			authVO.setAuth("ROLE_MEMBER");
			result =mapper.addAuth(authVO);
			
		}else if (auth.equals("admin")) { 	// 관리자로 가입시 권한 추가
			authVO.setAuth("ROLE_MEMBER");
			result =mapper.addAuth(authVO);
			authVO.setAuth("ROLE_ADMIN");
			result =mapper.addAuth(authVO);
			
		}
		
		return result ;
	}

	@Override
	public MemberVO getMember(String id) {
		
		return mapper.getMember(id);
	}

	@Override
	public int ModifyMember(MemberVO member) {
		// id pw 체크 후
		int result =0;
		MemberVO dbMember = getMember(member.getId());
		if(bcryptPasswordEncoder.matches(member.getPw(), dbMember.getPw())) {
		result=	mapper.updateMember(member);
		}
		
		return result;
	}

	@Override
	public int deleteMember(MemberVO member) {
		int result = 0;
		MemberVO dbMember = getMember(member.getId());
		if(bcryptPasswordEncoder.matches(member.getPw(), dbMember.getPw())) {
			result =1;
			//권한 먼저 지우기  
			int deleteRes =mapper.deleteAuth(member.getId());
			log.info("*******deleteauth************"+deleteRes);
			 deleteRes =mapper.deleteMember(member.getId());
			log.info("*******deleteres************"+deleteRes);
			
		};
		/*
		
		// id pw 체크 후
		int result= mapper.idpwCheck(member);
		// 수정
		if(result ==1) {
			mapper.deleteMember(member.getId());
			//권한 삭제
			mapper.deleteAuth(member.getId());
		}*/
		return result;
	}

}
