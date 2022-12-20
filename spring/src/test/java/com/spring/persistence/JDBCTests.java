package com.spring.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test; 
import org.junit.runner.RunWith; 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
/*
	@RunWith : 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 표시함.
			   JUnit 테스트할 때 어플리케이션 컨텍스트 만들고 관리해주는 작업 진행.
 */
//@RunWith(SpringJUnit4ClassRunner.class)


//JDBC 연동 테스트 클래스
@Log4j	
public class JDBCTests {
	
	static {
			try{ 
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	
	//테스트 메서드
	@Test
	public void testConnection() {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100.250:1521:ORCL","java14","java14")){
			log.info(conn);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
			
			
			
}
