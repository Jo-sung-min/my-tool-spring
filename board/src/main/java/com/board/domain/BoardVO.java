package com.board.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BoardVO {
	private Long bno; 
	private String title; 
	private String content;
	private String writer; 
	private Date reg; 
	
}
