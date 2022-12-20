package com.member.service;

import com.member.domain.MemberVO;

public interface MemberService {

	
	// 회원 가입 (추가)
	public int addMember(MemberVO member);
	// 권한 추가
	public int addAuth(String auth, String id);
	// 회원 정보 가져오기
	public MemberVO getMember(String id);
	// 회원 정보 수정 처리
	public int ModifyMember(MemberVO member);
	// 회원 탈퇴 처리
	public int deleteMember(MemberVO member);
	
	
	
	
	
	
}
