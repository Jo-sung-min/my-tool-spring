package com.board1.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board1.domain.Board1VO;
import com.board1.service.Board1Service;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board1/*")
@Log4j
public class Board1Controller {

	@Autowired
	private Board1Service service;
	
	@RequestMapping("signupForm")
	public void rrr() {
		log.info("등록 들어옴!!");	
		
	}
	
	@PostMapping("signupForm")
	public void test(Board1VO board) {
	log.info("등록 들어옴!!");	
	service.register(board);	
		
		
	}
	
	
	
	
}
