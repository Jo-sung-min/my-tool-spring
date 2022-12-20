package com.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.member.domain.MemberVO;
import com.member.service.MemberService;
import com.member.service.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member/*")
@Log4j
public class MemberController {

	@Autowired
	private MemberService service;
	
	
	
	@GetMapping("mypage")
	public void mypage() {
		log.info("*********mypage!!*********");
		
	}
	
	
	@GetMapping("modify")
	public void modify( Model model, Authentication auth ) {
		log.info("***********modifyform");
		//Authentication 매개변수 선언하면 principal 등 정보 꺼낼 수 있따.
		CustomUser user = (CustomUser)auth.getPrincipal();
		log.info("***********user"+user);
		MemberVO member=service.getMember(user.getUsername()); // principal.username
		model.addAttribute("member",member);
	}

	@PostMapping("modify")
	public String modifyPro(MemberVO member,Authentication auth,Model model) {
		log.info("***********modifyPro");
		member.setId(((CustomUser)auth.getPrincipal()).getUsername());// auth 에서 usename== id 꺼내 vo 에 채우기
		
		int result = service.ModifyMember(member);
		
		log.info("***********modifyPro result+" +result);
		model.addAttribute("result",result);
		
		return "member/modifyPro";
	}
	
	
	// 회원 삭제
	@GetMapping("delete")
	public void delete() {
		
	}
	
	// 회원삭제 처리
	@PostMapping("delete")
	public String deletPro(MemberVO member,Authentication auth,Model model) {
		member.setId(((CustomUser)auth.getPrincipal()).getUsername());
		int result =service.deleteMember(member);
		model.addAttribute("result",result);
		
		return "member/deletePro";
	}
	
	
}
