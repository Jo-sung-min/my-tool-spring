package com.spring.mapper;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.dto.SampleDTO;

public interface SampleMapper {
	
	//test 테이블에서 전체 레코드 수 가져오는 쿼리문
	public int getCount();
	
	//test 테이블에서 age 컬럼의 값중 가장 큰 수 리턴
	public int testGetMaxAge();
	
	//test 테이블 모든컬럼 dto 에 담아서 리턴해보기 모든 데이터
	public List<SampleDTO> getAllRecord();
	
	//id 값을 주고 그 아이디에 해당하는 그 레코드 한줄 가져오기
	public SampleDTO getOnePerson(String id ); 

	//id 주고 id 에 해당하는 reg 컬럼값만 가져오기
	public Timestamp getReg(String id );
	
	//test 테이블에 회원정보 전달해서 저장시키기
	public int insertRecord(SampleDTO dto); 
	
	//test 테이블에 dto 수정시키기
	public int updateRecord(SampleDTO dto); 
	
	//파라미터 하나 업데이트
	public int updateRecord(@Param("id") String id ,@Param("pw") String pw,@Param("age") int age); 
	
	//해쉬맵으로 업데이트
	public int updateRecord(HashMap data); 
	
	//delete
	public int deleteRecord(String id);
	
}
