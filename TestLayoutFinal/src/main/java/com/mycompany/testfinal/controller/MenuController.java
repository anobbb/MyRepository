package com.mycompany.testfinal.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.testfinal.dto.Menu;
import com.mycompany.testfinal.service.MenuService;


@Controller
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/menu/list")
	public String list(String pageNo, Model model, HttpSession session){
		
		String sid = (String) session.getAttribute("login");
	
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 8;
		int pagesPerGroup = 5;
		
		int totalBoardNo = menuService.getCount();
		
		int totalPageNo = (totalBoardNo/rowsPerPage) + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Menu> list = menuService.list(intPageNo, rowsPerPage, sid);
		
		model.addAttribute("sid",sid);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		
		return "menu/list";
	
	} // list
	
	
	@RequestMapping(value = "/menu/register", method=RequestMethod.GET)
	public String registerForm(HttpSession session){
		return "/menu/registerForm";
	} 
	
	@RequestMapping(value = "/menu/register", method=RequestMethod.POST)
	public String register(HttpSession session, Menu menu){
		logger.info("ggg");
		try {
			String sid = (String)session.getAttribute("login");
			menu.setSid(sid);
			logger.info(""+sid);
			String msavedfile = new Date().getTime() + menu.getPhoto().getOriginalFilename();
			
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + msavedfile);
			logger.info(realpath);
			menu.getPhoto().transferTo(new File(realpath));
			menu.setMsavedfile(msavedfile);
			menu.setMmimetype(menu.getPhoto().getContentType());
			
			int result = menuService.write(menu);
			logger.info(""+result);
			return "redirect:/menu/list";		
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			return "menu/registerForm";
		}
	} // register
	
	
	@RequestMapping("/menu/showPhoto")
	public void showPhoto(String msavedfile, HttpServletRequest request, HttpServletResponse response){
		try{
			String fileName = msavedfile;
			String mimeType = request.getServletContext().getMimeType(fileName);
			response.setContentType(mimeType);
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/" + fileName);
			InputStream is = new FileInputStream(filePath);
			
			byte[] values = new byte[1024];
			int byteNum = -1;
			while((byteNum = is.read(values)) != -1){
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	} // showPhoto 
	
	@RequestMapping(value="/menu/info")
	public String info(int mid, Model model){
		Menu menu = menuService.info(mid);
		menuService.modify(menu);
		model.addAttribute("menu", menu);
		return "menu/info";
	} // info
	
	@RequestMapping(value="/menu/modify", method=RequestMethod.GET)
	public String modifyForm(int mid, Model model){
		Menu menu = menuService.info(mid);
		model.addAttribute("menu", menu);
		return "menu/modify";
	} // modifyForm
	
	
	@RequestMapping(value="/menu/modify", method=RequestMethod.POST)
	public String modify(Menu menu, HttpSession session, Model model){
		
		try{
			// String sid = (String)session.getAttribute("login");
			// menu.setSid(sid);
			
			String msavedfile = new Date().getTime() + menu.getPhoto().getOriginalFilename();
			
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + msavedfile);
			logger.info("realpath : "+realpath);
			menu.getPhoto().transferTo(new File(realpath));
			menu.setMsavedfile(msavedfile);
			menu.setMmimetype(menu.getPhoto().getContentType());
			menuService.modify(menu);
		}catch(Exception e){}
		return "redirect:/menu/list";
	} //modify
	
	@RequestMapping("/menu/remove")
	public String remove(int mid){
		menuService.remove(mid);
		return "redirect:/menu/list";
	}

} // class
