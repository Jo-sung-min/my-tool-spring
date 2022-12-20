package com.spring.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.SampleDTO;
import com.spring.dto.SampleDTOList;
import com.spring.dto.SampleTv;

import lombok.extern.log4j.Log4j;


@Log4j  
@Controller
@RequestMapping("/sample2/*")
public class SampleController2 {
	//
	
	
	
	// 8080/samaple2/hello?id=java&pw=1234
	@RequestMapping("hello")
	public String hello(SampleDTO dto){
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		
		return "sample/test";
	}
	
	// 8080/samaple2/hello?id=java&pw=1234
	@RequestMapping("hello1")
	public String hello(String id, String pw){ // pw String int 둘다 받을 수 있음
		System.out.println(id);
		System.out.println(pw);
		
		return "sample/test";
	}

	// ....8080/sample2/hello2?name=AAA&age=10
	
	@RequestMapping("hello2")
	public String hello2(@RequestParam("name") String name,@RequestParam("age") int age) {
		//혹시 바인딩 잘 안되면 즉 파라미터를 잘 못불러오면 이렇게 어노테이션 붙여주면됨
		log.info("hello2매핑 메서드 실행");
		log.info("name : "+name);
		log.info("age : "+age);
		return "sample/test";
		
	}
	
	//8월 12일
	//동일한 이름의 파라미터가 여러개 전달되는 경우 ArrayList, 배열 사용가능
	//리스트 파라미터 받아보기
	//..../sample2/hello3/?names=A&names=B&names=C
	@RequestMapping("hello3")
	public String hello3(@RequestParam("names") ArrayList<String> names) {
		System.out.println("List!!!");
		log.info(names);
		
		
		return "sample/test";	
	}
	
	// 배열 (@RequestParam 어노테이션 생략가능)
	//..../sample2/hello4/?names=A&names=B&names=C
	@RequestMapping("hello4")
	public String hello4(String[] names) {
		System.out.println("[]!!!");
		for(String s : names) {
			log.info(s);
			
		}
		log.info(names);
		
		
		return "sample/test";
	}
	
	
	//객체 리스트
	// ..../sample2/hello5?List[0].id=AAA&List[1].id=BBB  라고하면 문제가 생김 (문제 이유 대괄호[0]이 인식이 안됨)
	// ..../sample2/hello5?List%5B0%5D.id=AAA&List%5B1%5D.id=BBB 
	@RequestMapping("hello5")
	public String hello5(SampleDTOList list) {
		log.info(list);
		
		return "sample/test";
	}
	
	
	@RequestMapping("form")
	public String form() {
		
		
		return "sample/form";
	}
	
	@RequestMapping("pro")
	public String pro(String id,String pw, SampleDTO dto,Model model,HttpServletRequest request ) {
		log.info(id);
		log.info(pw);
		log.info(dto.getId());
		log.info(dto.getPw());
		
		//view 에 데이터 전달
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		//request로 데이터 전달
		request.setAttribute("reqId", id);
		request.setAttribute("reqPw", pw);
		
		return "sample/pro";
	}
	
	
	//ModelAndView 잘 쓰진 않음
	@RequestMapping("pro2")
	public ModelAndView pro2(String id, String pw , SampleDTO dto) {
		//객체생성
		ModelAndView mv = new ModelAndView();
		// view 에 전달할 데이터 추가
		mv.addObject("id",id);
		mv.addObject("pw",id);
		mv.addObject("dto",dto);
		// 이동할 view 이름 추가
		mv.setViewName("sample/pro");
		return mv;
	}
	
	
	//별칭 붙이는법@ModelAttribute("dto") SampleDTO dto
	@RequestMapping("pro3")
	public String pro3(SampleDTO dto) {
		
		
		
		return "sample/pro";
	}
	
	
	@RequestMapping("hello6")
	public String hello6() {
		
		log.info("hello6매핑!!");
		
		return "sample/test";	
	}
	
	/*
	 * 매번 로그 찍히니까 주석처리하고 진행
	@ModelAttribute("tv")// 별칭 달아도 되고 안달아도 되고 안달면 리턴 객체 이름 
							// 앞에 소문자로 변경해서 보내줌 ex sampleTv
	public SampleTv getTv(String col) {
		log.info("getTV호출!!!");
		SampleTv tv  = new SampleTv();
		tv.setPower(true);
		tv.setCh(10);
		tv.setCol(col);
		return tv;
		
	}
	
	@ModelAttribute("tv") 
	public void getTv2(String col,Model model) {
		log.info("getTV호출!!!");
		SampleTv tv  = new SampleTv();
		tv.setPower(true);
		tv.setCh(10);
		tv.setCol(col);
		model.addAttribute("tv1", tv);;
	}
	
	*/
	
	@RequestMapping("hello7")
	@ResponseBody	//jsp 페이지는 없지만 body로 리턴해 주겠다.
					//자바 스크립트 이용하여 메세지 요청할 때 사용
					//view 페이지로 응답x, 데이터 응답해줄때 주로 사용(ajax사용시)
	public String hello7() {
		
		
		return "hello.......";
	}
	
	
	
	//@RequestMapping(value="hello8",params= {"id=java","pw=1234"})
	//@RequestMapping(value="hello8",params= {"id=java","pw"})
	@RequestMapping(value={"hello8","hello9"},params= {"id=java","pw","!age"},method = RequestMethod.GET)// 페이지를 요청할때 파라미터
									//id=java가 있어야 호출됨 유효성 검사 느낌 보안체크로 많이사용
	public String hello8() {
		
		
		
		
		return "sample/test";
	}
	
	
	//id로 네이밍해서 값을 받아주는데 넘어오는 파라미터가 없으면 default 로 raraar 세팅함
	//required 꼭 id 변수가 있어야한다는뜻
	@RequestMapping("hello10")
//	public String hello10(@RequestParam(value="id", defaultValue = "raraar") String msg, String pw) {
//	public String hello10(@RequestParam(value="id", required = true) String msg, String pw) {
	public String hello10(@RequestParam(value="id", required = true) String id,
				@RequestParam(value="pw", required = true) String pw,
				@RequestParam(value="auto", required = false, defaultValue = "0") String auto) {
		log.info(id);
		log.info(pw);
		log.info(auto);
		
		return "sample/test";
	}
	
	
	
	
	
	
	
	
}

