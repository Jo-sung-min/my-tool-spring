package com.board.persistence;

import java.util.List;

import com.board.domain.ReplyVO;

public interface ReplyMapper {

	// 댓글 추가
	public int add(ReplyVO vo);
	// 댓글 한개 조회
	public ReplyVO getReply(Long repno);
	// 댓글 수정
	public int modify(ReplyVO vo);
	// 댓글 삭제
	public int delete(Long repno);
	// 댓글 목록 조회(페이징처리 x)
	public List<ReplyVO> getList(Long bno);
	
}
