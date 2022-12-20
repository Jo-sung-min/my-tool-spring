package com.board.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/upload/*")
@Log4j
public class UploadController {

	
	
	@GetMapping("uploadForm")
	public void upload() {
		log.info("upload!!!!!!!!!!!!!!!!!!!!");
		
		
	}
	
	@PostMapping("uploadPro")
	public void uploadPro(String msg, MultipartHttpServletRequest request) {// msg(text), img(file)
		log.info("********upload pro*******");
		log.info(msg);
		try {
			//전송한 파일 정보 꺼내기
			MultipartFile mf = request.getFile("img");
			log.info(mf.getOriginalFilename());
			log.info(mf.getSize());
			log.info(mf.getContentType());
			
			
			// 파일 저장 경로 구하기
			String path =request.getRealPath("/resources/save");  // 서버상 save 폴더 위치
			log.info("save"+path);
			
			// 새 파일명 생성
			String uuid=UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
			log.info(uuid);
			//업로드한 파일 확장자만 가져오기
			String orgName=mf.getOriginalFilename();
			//zzang.jpg
			String ext= orgName.substring(orgName.lastIndexOf("."));
			// 저장할 파일명
			String newFileName= uuid + ext;
			log.info("***********uuid"+uuid);
			//저장할 파일 전체 경로
			String imgPath = path+"\\"+newFileName;
			log.info("*****imgPath"+imgPath);

			// 파일 저장
			File copyFile = new File(imgPath);
			mf.transferTo(copyFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	// 다운로드 버튼 띄운 화면
	@GetMapping("helloDown")
	public void helloDown() {
		
	}
	// 다운 요청 처리
	@GetMapping("download")
	public ModelAndView down() {
		//다운시킬 파일
		
		File f = new File("E:\\sungmin\\mm.jpg");
		
		//생성자 매개변수
		//String veiwName		: view 이름대신-> xml 지정한 DownloadView 빈의 id 값 root 에 있음 
		//String modelName		: 파라미터명 지정 (이름) 
		//Object modelObject	: 데이터(다운시킬 파일) 
		
		ModelAndView mv = new ModelAndView("fileDown","downloadFile",f);
			
		
		return mv;
	} 
	
	
	
	
	
}
