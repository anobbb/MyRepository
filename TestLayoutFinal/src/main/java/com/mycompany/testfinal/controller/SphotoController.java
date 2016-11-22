package com.mycompany.testfinal.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.testfinal.dto.Sphoto;
import com.mycompany.testfinal.service.SphotoService;

@Controller
@RequestMapping("/sphoto")
public class SphotoController {
	private static final Logger logger = LoggerFactory.getLogger(SphotoController.class);
	
	@Autowired
	private SphotoService sphotoService;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "sphoto/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Sphoto sphoto, HttpSession session){
		
		try {
			String sid = (String)session.getAttribute("login");
			sphoto.setSid(sid);
			
			for(MultipartFile photo: sphoto.getPhoto()){
			String savedfile = new Date().getTime()+photo.getOriginalFilename();
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo"+savedfile);
			
			photo.transferTo(new File(realpath));
			sphoto.setSpic_savedfile(savedfile);
			
			logger.info(realpath);
			
			sphoto.setSpic_mimetype(photo.getContentType());
			
			int result = sphotoService.write(sphoto);
			
			}
			
			return "redirect:/index";
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "sphoto/write";
		}
		
	}
	
	
}
