package com.board1.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {

	private int pageNum;
	private int listQty;
	private String sel;
	private String keyword;
	
	
	public Criteria() {
		this(1,20);
	}
	
	public Criteria(int pageNum, int listQty) {
		
		
	}
	
	public String[] getSelArr() {
		return sel == null? new String [] {} : sel.split("");
	}
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("listQty", this.listQty)
				.queryParam("sel", this.sel)
				.queryParam("keyword", this.keyword)
				;
		
		return builder.toUriString();
		
	}
	
	
	
	
	
	
	
}
