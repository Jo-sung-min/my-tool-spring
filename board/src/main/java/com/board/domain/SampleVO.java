package com.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data					// 기본생성자만 만들어줌
@AllArgsConstructor		// 모든 변수를 매개변수로 갖는 생성자. (기본생성자 대신만들어줌)
@NoArgsConstructor		//기본 생성자만드는 어노테이션
public class SampleVO {


	
	
	private Integer num;
	private String name;
	private String addr;
	
}
