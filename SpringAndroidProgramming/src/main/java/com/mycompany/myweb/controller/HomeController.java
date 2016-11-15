package com.mycompany.myweb.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Light;

@Controller
public class HomeController {
	//1025
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/")
	public String index() {
		logger.info("index() 실행");	
		return "index";
	} 
	
	@RequestMapping("/lightList")
	public String lightList(Model model){
		List<Light> list = new ArrayList<>();
		list.add(new Light("light1.png", "light1_large.png", "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검정색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		list.add(new Light("light2.png", "light2_large.png", "인테리어 조명2", "개인등으로 사용하면 좋습니다. 흰색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		list.add(new Light("light3.png", "light3_large.png", "인테리어 조명3", "샤워등으로 사용하면 좋습니다. 흑색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		list.add(new Light("light4.png", "light4_large.png", "인테리어 조명4", "서재등으로 사용하면 좋습니다. 밤색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		list.add(new Light("light5.png", "light5_large.png", "인테리어 조명5", "현관등으로 사용하면 좋습니다. 빨간색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		list.add(new Light("light6.png", "light1_large.png", "인테리어 조명6", "거실등으로 사용하면 좋습니다. 검정색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		list.add(new Light("light7.png", "light2_large.png", "인테리어 조명7", "개인등으로 사용하면 좋습니다. 흰색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		list.add(new Light("light8.png", "light3_large.png", "인테리어 조명8", "샤워등으로 사용하면 좋습니다. 흑색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		list.add(new Light("light9.png", "light4_large.png", "인테리어 조명9", "서재등으로 사용하면 좋습니다. 밤색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		list.add(new Light("light10.png", "light5_large.png", "인테리어 조명10", "현관등으로 사용하면 좋습니다. 빨간색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
		
		model.addAttribute("list", list);
		return "lightList";
	}
	
}
