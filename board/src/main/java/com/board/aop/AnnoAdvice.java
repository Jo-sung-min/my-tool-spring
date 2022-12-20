package com.board.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;


@Component 	// 스프링 빈으로 등록되기 위한 어노테이션 root에 bean 등록할필요가 없음 스캔으로 등록해야함
@Aspect		// 그림에8.26 aspect 통칭해서 말함 해당 클래스가 Aspect 를 구현한 것임을 나타냄
			// aop 관련 클래스
@Log4j
public class AnnoAdvice {
	
	/*
	 * 다 풀어쓰면
	@Pointcut("excution(* test* (..))")
	private void testPC() { }
	
	@Before("testPC()")
	public void before() {
		//공통기능 구현 코드.....
	}
	
	
	// 줄임
	@Before("excution(* test* (..))")
	public void before() {
		//공통기능 구현 코드.....
		
	}
	*/
	
	@Around("execution(* com.board.service.TestService*.*(..))")
	public Object around(ProceedingJoinPoint j) throws Throwable{
		// before
		log.info("**************before****************");
		log.info(j.getTarget());// 핵심메서드   
		log.info(Arrays.toString(j.getArgs())); // 매개변수 
								//배열을 문자열 형태로 만들어 출력
		
		// joinpoint 가 낚아챈다 사용법 request 같은거 꺼낼 수 있음
		Object[] args = j.getArgs();
		for(Object o : args) {
			if(o instanceof HttpServletRequest) {
				log.info("request 있네!!!!"); 
				HttpServletRequest request= (HttpServletRequest)o;
				request.getSession();
			}
		}
		
		
		Object obj = j.proceed(); 
		
		//after
		log.info("**************after******************");
		return obj;
	}
	
	
	/* 
	@AfterThrowing(pointcut="execution(* com.board.service.TestService*.*(..))",throwing="e")
	public void aftTh(Exception e) { // 에러를 알고싶으면 예외발생 객체 
		log.info(e.getMessage());	
					//더 크게 보고싶다 하면  Exception >> Throwable 로 받아주면됨 부모객체
		
	}
	*/
	
	
	
	
}
