package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;

public interface BoardService {

	// 게시글 전체 조회 
	public List<BoardVO> getList(Criteria cri); 
	// 게시글 등록
	public void register(BoardVO board);
	// 특정 게시글 가져오기 
	public BoardVO get(Long bno); 
	// 게시글 수정 
	public boolean modify(BoardVO board); 
	// 게시글 삭제 
	public boolean delete(Long bno); 
	
	// 글 개수 조회 
	public int getTotal(Criteria cri);
	
	
	
	
}
