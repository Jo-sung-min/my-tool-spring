package com.board1.domain;

import java.util.Date;

import lombok.Data;
@Data
public class Board1VO {
	
		private Long bno; 
		private String title; 
		private String content;
		private String writer; 
		private Date reg; 
		

}
