package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.ReplyVO;
import com.board.persistence.ReplyMapper;

@Service
public class ReplyserviceImpl implements ReplyService {

	
	@Autowired
	private ReplyMapper mapper;
	
	
	@Override
	public int add(ReplyVO vo) {
		return 	mapper.add(vo);
	}

	@Override
	public ReplyVO getReply(Long repno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(ReplyVO vo) {
		return mapper.modify(vo);
	}

	@Override
	public int delete(Long repno) {
		
		return mapper.delete(repno);
	}

	@Override
	public List<ReplyVO> getList(Long bno) {
		return mapper.getList(bno);
	}

}
