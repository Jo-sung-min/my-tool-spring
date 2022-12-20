package com.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.log4j.Log4j;

//8.26 공통기능 구현해놓을 클래스
@Log4j
public class Advice {
	public void beforeAD() {
		log.info("================before advice==============");
		log.info("================before advice==============");
		log.info("================before advice==============");
		
	}
	public void afterAop() {
		log.info("================after advice==============");
		log.info("================after advice==============");
		log.info("================after advice==============");
		
	}
	
	
	public void afterReturning() {
		log.info("================afterReturning advice==============");
		log.info("================afterReturning advice==============");
		log.info("================afterReturning advice==============");
		
	}
	
	public void afterThrowing() {
		log.info("================afterThrowing advice==============");
		log.info("================afterThrowing advice==============");
		log.info("================afterThrowing advice==============");
		
	}
	/*
 		around advice 메서드 구현방법
 		첫번째 매개변수로 ProceedingJoinPoint 가필요함 j 로지정
 		리턴타입 Object 타입으로, 가던길 가라(타겟으로~) j.proceed() 호출하여
 			Object obj= j.proceed(); 위에작성하면 before
 			아래 작성하면 after
 		리턴받은 값을 리턴해주는 형태로 작성 해야함.
	 */	
	
	public Object around(ProceedingJoinPoint j) throws Throwable{
		log.info("================around before 발생!!==============");
		
			Object obj= j.proceed();
			
		log.info("================around after 발생!!! ==============");
		return obj; 
	}
}
