package com.spring.mapper;

import java.util.List;

import com.spring.dto.SampleDTO;

public interface DynamicMapper {
	//아이디 받고 있으면 1 리턴해주는 메서드
	public int selectIf(String id); 
	
	public int selectIf2(SampleDTO dto); 
	
	public int selectTrim(SampleDTO dto);
	
	public int updateTest(SampleDTO dto);
	
	public int selectIn(List<String> list);
	
	public int updateKey(SampleDTO dto);
	
	public int insertKey(SampleDTO dto);
	
	
	
}
