package com.member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import lombok.extern.log4j.Log4j;


@Log4j 
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
				log.info("****************logout success handler*****************");
				
				// 보던 페이지로 돌어가는 처리(loginSuccessHandler 와 동일)
				response.sendRedirect(request.getHeader("referer"));
				
				
			}
				
	}

