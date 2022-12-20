package com.board.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyVO {

	private	Long repno;		//댓글 고유번호
	private Long bno;		//댓글이 달린 본문 글 번호
	private String reply;	//댓글 내용
	private String replyer;	//댓글 작성자
	private Timestamp reg;	//작성시간
	
	
	
	
	
}
