package com.board.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {


	@Autowired
	private BoardMapper mapper;
	
	
	//CRUD 기반으로 테스트 해보기
	/*
	@Test
	public void testgetList() {
		List<BoardVO> list=	mapper.getList();
		for(BoardVO vo : list) {
			log.info(vo);
		}
	}
	*/
	/*
	@Test
	public void testinsert() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트 제목");
		board.setContent("내용");
		board.setWriter("user");
		
		//mapper.insert(board);
		
		log.info("bno insert 후" + board.getBno());
		//mapper.insertSeletKey(board);
		
		assertThat(mapper.insertSeletKey(board), is(1));
		log.info("bno insert 후" + board.getBno());
	}
	*/
	/*
	@Test
	public void testRead() {
		
		BoardVO board= mapper.read(2L);  // 타입이 인트라서 롱타입으로 l 붙여줌
		log.info("*****************");
		log.info(board);
		
		
	}
	*/
	/*
	@Test
	public void testDelete() {
		assertThat(mapper.delete(7L), is(1)); 
		
	}
	*/
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(2L);
		board.setTitle("제목수정");
		board.setContent("내용수정");
		board.setWriter("이름수정");
		
		assertThat(mapper.update(board), is(1));
		
		
	}
	
	
	
	
	
	
}
