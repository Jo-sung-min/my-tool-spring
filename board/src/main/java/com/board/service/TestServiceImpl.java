package com.board.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class TestServiceImpl implements TestService {

	
	//핵심기능
	@Override
	public void helloAop(int a, int b) {
//		log.info(0/0);
		log.info("!!!!!!!!!!!!!!!hello AOP!!!!!!!!!!!");
		log.info(a+b);
		
		
		
	}

}
