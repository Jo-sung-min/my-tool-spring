package com.spring.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.SampleDTO;
import com.spring.dto.SampleTv;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample4/*")
@Log4j
public class SampleController4 {
	
	//기존 방식으로 객체 생성
	//private Date day = null;

	/*
	//생성자로 객체생성
	public SampleController4(){
		day =new Date();		
	}
	*/
	
	//의존성 주입
	/*
	  	스프링에서는 DI라는 의존성 주입 기술을 통해 의존하는 객체를 전달받아 사용함.
	  	객체생성은 XML 파일에 <bean>으로 등록하여, 스프링의BeanFactory 가 생성/ 관리 하도록 지정,
	  	해당 스프링빈(객체)이 필요한 곳에서 @Autowired로 주입받아 사용가능하도록 되어있다.
	  	@Autowired : 의존성 자동 주입
	  		1.변수의 타입이 같은은 빈이 있으면 변수이름(ID)상관없이 주입
	  	 	2.같은 타입의 빈이 여러개 있다면, bean의 id 속성값과 변수명이 동일한것을 주입해줌. 
	 */
	//root-context 에서 타입만 같으면 같은 이름이아니여도 일단 채워준다 그리고 아이디는 있으면 고려해줌
	//만약 같은 타입의 bean 객체를 이름이 다르게 2개 생성했을 경우에는 아이디 안맞으면 오류뜸
	@Autowired
	private Date day = null;
	
	/*
	@Autowired
	private Date day2 = null;
	*/
	
	
	/*
	@Autowired
	private SampleTv tv =null;
	*/
	
	//@Autowired 와 같은기능	
	@Setter(onMethod_= @Autowired)
	private SampleTv tv =null;
	
	
	@RequestMapping("test")
	public String test() {
		//day =new Date();
		log.info("test 요청!!");
		log.info(day);
		//log.info(day2);
		
		
	//	tv.setPower(true);
	//	tv.setCh(10);
	//	tv.setCol("blue");
		
		log.info(tv.isPower());
		log.info(tv.getCh());
		log.info(tv.getCol());
		log.info(tv.getReg());
		
		return "sample/test";
		
	}
	
	public void test2() {
		
		log.info(day);
		
	}
	
	@GetMapping("login")
	public String form() {
		log.info("form 요청 !!!");
		
		return "sample/form";
	}
	
	
	
	@PostMapping("login")
	public String login(SampleDTO dto) {
		log.info("login Post 요청 !!!");
		log.info(dto.getId());
		log.info(dto.getPw());
		
	//	return "sample/pro";
		return "redirect:/sample4/test"; // 자바 리턴값으로 /sample4/test 요청
	}
	
	
	
	
	
}
