package com.member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j;


//접근 제한시 처리해줄 클래스
@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		log.error("접근거부핸들러 실행!!!*****");
		log.info(accessDeniedException);
		
		//접근 제한시 처리할 것 있으면 처리해주기 
		
		
		//접근 제한 에러 페이지로 이동
		response.sendRedirect("/common/accessError");
		
	}

	
	
}
