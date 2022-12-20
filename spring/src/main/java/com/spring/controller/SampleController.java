package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 컨트롤러 역할을 하는 클래스로 선언.
			// 자동으로 스프링객체(스프링빈==객체생성) 등록되게 해줌
@RequestMapping("/sample/*") // 해당 클래스 안에 있는 모든 주소 앞에 공통 주소 적용
public class SampleController {
	
	//메핑 메서드 작성
	//@RequestMapping("hello")
	//@RequestMapping("{hello,test}")// 하나의 메서드에 여러개 주소 매핑
	// :8080/sample/content/15     우리가 원래 했던건 :8080/sample/content?pageNum=15 
	//@RequestMapping("content/{bno}")
	//public String hello(@PathVariable("bno") String val) {
	
	@RequestMapping("?") //? 하나가 주소글자수하나 를 뜻한다
	public String hello() {
		System.out.println("hello 매핑 메서드 호출!!!");
		
		return "sample/hello"; // 요청 들어왔을때 보여줘야하는 view 이름
								// 리턴 타입이 void 일 수 도있음
		
	}
	
	
	
	/*
	// 와일드 카드로 URL 매핑
	@RequestMapping("*")
	public String hello2() {
		
		System.out.println("*****************");
		
		
		return "sample/hello";
	}
	*/
	
	@RequestMapping(value="hello",method = {RequestMethod.GET} )
	public String hello2() {
		System.out.println("hello2 GET!!!!");
		return "sample/hello";
	}
	
	// get 방식 요청만 받는 매핑
	@GetMapping("hello3")
	public String hello3() {
		System.out.println("hello3 GET!!!!33333333");
		return "sample/hello";
	}
	
	@PostMapping("hello3")
	public String hello3Post() {
		System.out.println("hello3 Post!!!!33333333");
		return "sample/hello";
	}
	
	
	
	
	
}
