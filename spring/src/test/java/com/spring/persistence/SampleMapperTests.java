package com.spring.persistence;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.SampleDTO;
import com.spring.mapper.SampleMapper;

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
public class SampleMapperTests {

	@Autowired
	private SampleMapper sampleMapper;
	
	
	/*
	@Test
	public void testCount() {
		log.info("******test*****");
		log.info("count:"+sampleMapper.getCount());
	}
	
	@Test
	public void testGetMaxAge() {
		log.info("******test*****");
		log.info("age:"+sampleMapper.testGetMaxAge());
	}
	
	@Test
	public void testGetAll() {
		log.info("******all*****");
		log.info("all:"+sampleMapper.getAllRecord());
		
		List<SampleDTO> list = sampleMapper.getAllRecord();
		for(int i = 0 ;i<list.size() ; i++) {
			SampleDTO dto=list.get(i);
			log.info(dto);
		}
	}
	
	@Test
	public void getOnePerson() {
		log.info("******one*****");
		log.info("one:"+sampleMapper.getOnePerson("java02"));x
	}	
	
	@Test
	public void getOnePerson() {
		log.info("******reg*****");
		log.info("reg:"+sampleMapper.getReg("java02"));
	}	
	
	//객체 insert 해보기
	@Test
	public void testInsert() {
		log.info("******insert*****");
		SampleDTO dto = new SampleDTO();
		dto.setId("jjjva");
		dto.setAge(10);
		dto.setPw("1234");
		
		log.info(sampleMapper.insertRecord(dto));
	}
	
	//객체 update 해보기
	
	@Test
	public void testUpdate() {
		
		log.info("******update*****");
		SampleDTO dto = new SampleDTO();
		dto.setId("jjjva");
		dto.setPw("12355");
		dto.setAge(999);
		
		log.info(sampleMapper.updateRecord(dto)); 
		
	}
	
	@Test
	public void testUpdate() {
		
		log.info("******update*****");
		log.info(sampleMapper.updateRecord("jjjva","1234",00)); 
		
	}
	
	
	@Test
	public void testDelete() {
		
		log.info("******delete*****");
		log.info(sampleMapper.deleteRecord("java10")); 
		
		
	} 
	 */
	
	
	@Test
	public void testUpdate() {
		
		log.info("******update*****");
		HashMap map = new HashMap();
		map.put("id", "java01");
		map.put("pw", "1234");
		map.put("age", 1212);
		
		log.info(sampleMapper.updateRecord(map)); 
		
	}
	
	
	
	
	
	
}
