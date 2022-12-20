package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.domain.ReplyVO;
import com.board.service.ReplyService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/reply/*")
@Log4j
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	//댓글 추가 요청 매핑
	@PostMapping(value="add" ,consumes = "application/json"
			,produces = {MediaType.TEXT_PLAIN_VALUE})
	
	public ResponseEntity<String> add(@RequestBody ReplyVO vo){
		log.info("******************vo*****:"+vo);
		int result =service.add(vo);
		
		return result==1? new ResponseEntity<String>("성공",HttpStatus.OK)
				: new ResponseEntity<String>("실패.....",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	//댓글 목록 요청 매핑
	@GetMapping(value="list/{bno}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno){
		
		log.info("bno 잘 오고있냐고!"+bno);
		List<ReplyVO> list = service.getList(bno);
		
		return  new ResponseEntity<List<ReplyVO>>(list,HttpStatus.OK);
	} 

	
	
	//댓글 수정매핑
	@PostMapping(value="modify",consumes = "application/json")
	public void modify(@RequestBody ReplyVO vo) {
		service.modify(vo);
		
		
	}
	
	//댓글 삭제 매핑 ,consumes = {MediaType.APPLICATION_JSON_VALUE}
	@PostMapping(value="delete")
	public void delete( Long repno) {
		log.info(repno);
		int result = service.delete(repno);
		
	}
	
	
	
	
	
 
	
	
	
	
	
	
	
}
