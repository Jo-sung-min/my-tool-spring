package com.board1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board1.domain.Board1VO;
import com.board1.persistence.Board1Mapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class Board1ServiceImpl implements Board1Service {
	
	@Autowired
	private Board1Mapper mapper;

	@Override
	public void register(Board1VO board) {
		mapper.insert(board);
		
		
	}

	@Override
	public Board1VO getOne(int bno) {
		return null;
	}

	@Override
	public boolean modify(Board1VO board) {
		return false;
	}

	@Override
	public boolean deldete(int bno) {
		return false;
	}

	@Override
	public int getTotal() {
		return 0;
	}
	
	
	
	

	
}
