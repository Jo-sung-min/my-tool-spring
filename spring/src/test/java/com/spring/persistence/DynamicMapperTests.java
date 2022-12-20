package com.spring.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.SampleDTO;
import com.spring.mapper.DynamicMapper;

import lombok.extern.log4j.Log4j;

/*
@RunWith : 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 표시함.
		   JUnit 테스트할 때 어플리케이션 컨텍스트 만들고 관리해주는 작업 진행.
@ContextConfiguration : 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스트링내에 
		   				객체로 등록하게 해줌. (테스트 시 필요한 설정 파일 지정)
		   				() 안에 작성하는 문자열을 classpath:나 file:을 이용할 수 있다.
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"classpath:mybatis/mybatis-config.xml"})
@Log4j
public class DynamicMapperTests {
	
	@Autowired
	private DynamicMapper mapper;
	
	private SampleDTO dto; // 픽스쳐
	
	
	@Before // 각 테스트 메서드가 실행되기 이전에 먼저 실행되는 메서드 위에 부착
	public void createFixture() {
		dto = new SampleDTO();
		dto.setId("java111"); // 테이블에 존재하는 id
		dto.setPw("1234");
//		dto.setAge(0);
	} 
	
	
	/*
	@Test
	public void testSelectIf() {
		log.info("**************** selectIf *****************");
		log.info(mapper.selectIf(null));
		
	}
	@Test
	public void testSelectIf2() {
		log.info(mapper.selectIf2(dto));
		
	}

	@Test
	public void testSelectTrim() {
		log.info(mapper.selectTrim(dto));
		
	}
	
	@Test
	public void testUpdate() {
		log.info(mapper.updateTest(dto));
		
	}
	
	@Test
	public void testSelectIn() {
		List<String> list = new ArrayList<String>();
		list.add("java01");
		list.add("java02");
		list.add("test");
		list.add("hello");
		list.add("spring01");
		
		int result = mapper.selectIn(list);
		log.info(result);
	}
	
	@Test
	public void testSelectKey() {
		log.info(mapper.updateKey(dto));
		log.info(dto.getAge());
	}
	
	@Test
	public void testSelectKey() {
		int result =mapper.insertKey(dto);
		//결과 같이 1이여야만 성공했다 라는뜻 검증 메서드 매처
		assertThat(result, is(1)); // assert 메서드에서 실패하면 테스트 자체 실패
		
		log.info(dto.getAge());
	}
	
	 */
	
	/*
	 	JUnit 테스트 검증 메서드		매처 : 매칭이 되는지 확인
	 	assertThat(검증할 값, 매처)	: 값이 매처에서 요구하는 것과일치하는지
	 			매처  	: 	is()메서드 사용
	 	assertEquals(a,b) 	: 객체 a와 b 가 일치하는지 확인 내용물의 값 확인
	 	assertTrue(a) 		: a가 참인가 확인
	 	assertSame(a,b)		: a와 b 가 동일한 객체인지 확인(==) 주소값확인
	 	assertNotNull(a)	: 객체 a가 null 이 아님을 확인
	
	
	@Test
	public void testAssertCount() {
		
		assertThat(mapper.selectTrim(dto), is(8));
		
	}
	 */
	
	@Test
	public void testSelectKey() {
		int result =mapper.insertKey(dto);
		//결과 같이 1이여야만 성공했다 라는뜻 검증 메서드 매처
		assertThat(result, is(1)); // assert 메서드에서 실패하면 테스트 자체 실패
		log.info(dto.getAge());
	}
	
	
}
