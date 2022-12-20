package com.spring.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data 
public class SampleDTO {

	private String id;
	private String pw;
	private Integer age;
	private Timestamp reg;
		
	
}
