package com.spring.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data // 중요 ***** Get Set 자동생성
public class SampleDTOList {

	
	// Sample DTO 객체를 여러개 담는 리스트를 변수로 갖는 DTO
	private List<SampleDTO> list; // list[0].id=AAA, list[1].id=BBB
	
	public SampleDTOList() {
		list= new ArrayList<>();
		
	}
	
	
	
	
}
