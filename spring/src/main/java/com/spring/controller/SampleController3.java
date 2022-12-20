package com.spring.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("sample3/*")
@Log4j
public class SampleController3 {

	//리턴타입 String : jsp 페이지 경로리턴
	@RequestMapping("ex01")
	public String ex01() {
		log.info("ex01!!!!");
		
		
		return "sample/test";
		
	}

	
	//리턴 타입 void 일 경우 : url 경로가 == jsp 페이지 경로
	@RequestMapping("ex02")
	public void ex02() {
		log.info("ex02!!!");
		
	}
	
	
	// 리턴타입 VO, DTO
	@RequestMapping("ex03")
	@ResponseBody
	public SampleDTO ex03() {
		log.info("ex03!!!");
		SampleDTO dto = new SampleDTO();
		dto.setId("sm");
		dto.setPw("1234");
		return dto;
		
	}

	
	
	//리턴타입 ResponseEntity
	@RequestMapping("ex04")
	public ResponseEntity<String> ex04(){
		log.info("EX04!!!!!!!!");
		
		//보낼 데이터
		//String msg ="helloooooo";
		
		//{ "name" : "피카츄" }
		//String msg = "{\"name\" : \"피카츄\"}";
		String msg = "{\"name\": \"피카츄\"}";
		
		
		
		//헤더정보 내용물의 타입을 알려주는것
		HttpHeaders headers= new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		
		ResponseEntity<String> entity = 
				new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		
		return entity;
	}
	
	
	
	
	
	
	
	
}
