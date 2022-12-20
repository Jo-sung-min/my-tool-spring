package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;
import com.board.persistence.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper; 
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri); 
	}

	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// 업데이트 결과가 1이면 true 리턴 
		return mapper.update(board) == 1;
	}

	@Override
	public boolean delete(Long bno) {
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotalCount(cri);
	}

	
	
}
