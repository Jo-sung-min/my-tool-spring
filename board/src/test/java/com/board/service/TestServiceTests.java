package com.board.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestServiceTests {

	@Autowired
	private TestService service;
	
	/*
	@Test
	public void testClass() {
			log.info(service);
			log.info(service.getClass().getName());
		
	}
	*/
	
	
	
	@Test
	public void testAbc() {
		log.info("==========test abc============");
		service.helloAop(10,20);
		
		
		
	}
	

	
	
	
}
