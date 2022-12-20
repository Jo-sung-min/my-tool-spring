package com.spring.persistence;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//테스트할 클래스 경로
@Log4j
public class TimeMapperTests {


	@Autowired
	private TimeMapper timeMapper;
	  
	@Test
	public void testGetTime() {
		log.info(timeMapper);
		log.info(timeMapper.getClass().getName());
		//우리가 만든어노테이션 붙은 추상 메서드 호출! 리턴받은 결과 출력
		log.info(timeMapper.getTime());
		
		
		
	}
	
	@Test
	public void testGetTime2() {
		log.info("******************2*************");
		log.info(timeMapper.getTime2());
		
	}
	
	
}
