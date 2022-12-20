package com.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.domain.Bank;
import com.board.domain.BoardVO;
import com.board.domain.SampleVO;

import lombok.extern.log4j.Log4j;




/*
  produces : 서버에서 브라우저에 리턴해주는 데이터의 형태를 지정해줌 (서버->브)
  				브라우저에서 요청 시 지정한 accept 요청헤더값과 일치
  cunsumes : 브라우저에서 요청시 지정한 Content - type 과 일치하게 작성(브->서버)				
 */


@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	//단순 문자열 리턴
	@GetMapping(value="getText",produces ="text/plain;charset=UTF-8")
	public String getText() {
		log.info("문자열 리턴!!!!!!!");
		log.info("문자열 리턴!!!!!!!"+MediaType.TEXT_PLAIN_VALUE);
	
		
		//기존의@Controller 는 문자열을 리턴하는 경우 JSP 파일 이름으로 처리하지만, 
		//@RestController 의 경우에는 순수한 데이터가 리턴된다.
		//produces ="text/plain;charset=UTF-8" 속성은 해당 메서드가 생산하는 MIME 타입을 의미함
		//위와같이 문자열로 직접지정할 수도 있고, MediaType 이라는 클래스를 이용할 수도 있다.
		return "아녕하세용ㄹ";
	}
	
	//객체 리턴(produces 생략도 가능)
	@GetMapping(value="getVO",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO test() {
		
		log.info("*******getVO**********");
		return new SampleVO(123,"피카츄","마포구");
	}

	//컬렉션 타입 리턴 : List
	@GetMapping("getList")
	public List<SampleVO> getList(){
		List<SampleVO> list = new ArrayList<SampleVO>();
		for(int i = 0 ;i<10 ;i++) {
			list.add(new SampleVO(i,"Name-"+i,"Addr-"+i));
		}
		
		
		return list ;
	}
	
	
	
	//컬렉션 타입 리턴 : Map
	@GetMapping("getMap")
	public Map<String, SampleVO> getMap(){
		Map<String , SampleVO> map = new HashMap<String, SampleVO>();
		// map 은 인터페이스라서 객체 생성할때 해쉬맵으로 생성해야함
		// list 랑 같은 구조
		map.put("one", new SampleVO(111,"성민","이다"));
		return map;
	}
	
	
	
	// ResponseEntity 타입리턴
	// 영어와 수학점수를 요청 파라미터로 받아서, 60점 미만이면 상태코드 에러전송.
	@GetMapping(value="gradeCheck",params = {"eng","math"})
	public ResponseEntity<SampleVO> ett(Integer eng , Integer  math){
		SampleVO vo = new SampleVO(0,eng+"",math+"");
		
		ResponseEntity<SampleVO> result= null;
		
		if(eng < 60|| math<60) {
			// 상태코드 502 추가, 몸체에 데이터 추가
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	
	//@PathVariable 사용
	@GetMapping("/news/{cat}/{nid}")
	public String[] getPathVar(@PathVariable("cat") String cat,@PathVariable("nid") Integer nid) {
		
		log.info("*****pathvariable******");
		log.info("*****cat******"+cat);
		log.info("*****cat******"+nid);
		
		// 문자열 두개 배열로 만들어 리턴
		return new String[] {"categor:"+ cat,"news id :"+ nid};  
	}
	
	
	//@requestBody	: 요청시 데이터를 JSON 으로 보내고, 여기 서버에서 Bank 자바 객체로 변환해 받기
	@PostMapping(value="bank",consumes="application/json")
	public Bank convertBank(@RequestBody Bank bank) {
		
		log.info("convert to Bank obj"+bank);
		
		
		return bank;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
}
