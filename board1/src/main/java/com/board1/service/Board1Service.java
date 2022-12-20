package com.board1.service;

import com.board1.domain.Board1VO;

public interface Board1Service {
	
	
	//무슨 메서드를 만들지 여기서 설정
	
	// 게시글 전체 조회
	
	//게시글 등록
	public void register(Board1VO board);
	//특정게시글 가져오기
	public Board1VO getOne(int bno); 
	//게시글 수정
	public boolean modify(Board1VO board);
	//게시글 삭제
	public boolean deldete(int bno);
	//글 개수 조회
	public int getTotal();
	
	
	
	

}
