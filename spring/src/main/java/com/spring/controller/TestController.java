package com.spring.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.SampleDTO;
import com.spring.dto.SampleDTOList;
import com.spring.dto.TestDTO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/test/*")
public class TestController {
	
	
	
	
	//test/hi1?id=java&pw=1234
	// 주소줄에 파라미터 넣어서 요청해주기
	@RequestMapping("hi1")
	public String hello1(TestDTO dto) {
		log.info(dto.getId());
		System.out.println(dto.getPw());	
		System.out.println(dto.getName());	
		
		return "sample/test";
	}
	
	@RequestMapping("hi2")
	public String  hello2(@RequestParam("name") String name,@RequestParam("age") String age) {
		System.out.println("이번엔 바인딩 해보자");
		log.info(age);
		log.info(name);
		
		return "sample/test";
	}
	
	
	//8월 12일
	//동일한 이름의 파라미터가 여러개 전달되는 경우 ArrayList, 배열 사용가능
	//리스트 파라미터 받아보기
	
	
	@RequestMapping("hi3")
	public String hello3(@RequestParam("names") ArrayList<String> names) {
		System.out.println("List!!!!!!!");
		log.info(names);
		
		
		
		return "sample/test";
	}
	
	
	//배열 (@RequestParam 어노테이션 생략가능
	
	@RequestMapping("hi4")
	public String hello4(String[] names) {
		System.out.println("[]!!!!! ");
		for(String s : names) {
			log.info(s); // 주소가 나오네
		}
		log.info(names); // 주소가 나오네
		
		return "sample/test";
	}
	
	//객체 리스트
	
	@RequestMapping("hi5")
	public String hello5(SampleDTOList list) {
		log.info(list); // 리스트 타입 집어넣으면 알아서 맞게 찾아서 넣어주네 개꿀이다
		
		
		
		return "sample/test";
	}
	
	
	@RequestMapping("form")
	public String form() {
		
		return "sample/form";
	}
	
	@RequestMapping("pro")
	public String pro(String id, String pw, SampleDTO dto, Model model) {
		log.info(id);
		log.info(pw);
		log.info(dto.getId());
		log.info(dto.getPw());
		
		//view 에 데이터 전달
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("dto", dto);
		
		
		return "sample/pro";
		
	}
	
	
	
	
	
	
	
	
	
}
