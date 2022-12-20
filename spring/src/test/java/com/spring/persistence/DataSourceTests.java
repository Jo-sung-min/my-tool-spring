package com.spring.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/*
	@RunWith : 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 표시함.
			   JUnit 테스트할 때 어플리케이션 컨텍스트 만들고 관리해주는 작업 진행.
	@ContextConfiguration : 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스트링내에 
			   				객체로 등록하게 해줌. (테스트 시 필요한 설정 파일 지정)
			   				() 안에 작성하는 문자열을 classpath:나 file:을 이용할 수 있다.
 */

//DataSource 등 DB 연결 테스트 클래스

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j 
public class DataSourceTests {
	
	@Setter(onMethod_=@Autowired) //DI 의존성 주입 (자동주입)
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		
		try(Connection conn = dataSource.getConnection()) {
			log.info(conn);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
}
