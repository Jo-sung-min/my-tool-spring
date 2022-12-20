package com.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	
	//select 문으로 DB에서 현재 시간 가져오는 작업 예시
	
	// 어노테이션 이용하여 SQL 문 실행 
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	//XML + 인터페이스 같이 사용
	//레코드가 여러개이면 List<String> 이렇게 리스트로 묶어서 리턴받으면 됨
	public String getTime2();
	
	
	
}
