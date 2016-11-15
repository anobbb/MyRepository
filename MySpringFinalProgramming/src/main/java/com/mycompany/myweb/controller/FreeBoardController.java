package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.service.FreeBoardService;
 
@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session){
		/* 원래 모든 요청 파라메터는 String으로 넘어옴
		 * int로 변환하면 페이지넘버가 정상적으로 넘어오면 괜찮지만 null이거나 기타 등등..이면 예외가 발생함
		 * 예외 상황 방지를 위해서 @RequestParam(defaultValue="1")int pageNo을 사용하여 defaultValue를 지정해 줄 수 있음
		 */
		
		int intPageNo = 1;
	      if (pageNo == null) { //client에 없는 경우
	         pageNo = (String) session.getAttribute("pageNo");
	         if (pageNo != null) {
	            intPageNo = Integer.parseInt(pageNo);
	         }
	      } else { // client와 session에 모두 없는 경우
	         intPageNo = Integer.parseInt(pageNo);
	      }
	      session.setAttribute("pageNo", String.valueOf(intPageNo));//세션에 현재 저장된 페이지 전달
	      
	      
	      int rowsPerPage = 10;
	      int pagesPerGroup = 5;
	      
	      int totalBoardNo = freeBoardService.getCount();//전체 게시물 수 구하기
	      
	      int totalPageNo = (totalBoardNo/rowsPerPage)+((totalBoardNo%rowsPerPage!=0)?1:0);//전체 페이지수
	      int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);//전체 그룹수
	      
	      int groupNo = (intPageNo-1)/pagesPerGroup + 1;//현재 그룹의 번호
	      int startPageNo = (groupNo-1)*pagesPerGroup + 1;//그룹의 첫번째 번호 구하기
	      int endPageNo = startPageNo + pagesPerGroup - 1;//그룹의 마지막 번호 구하기
	      
	      if (groupNo == totalGroupNo) {
	         endPageNo = totalPageNo;
	      }
	      List<FreeBoard> list = freeBoardService.list(intPageNo, rowsPerPage);
	      
	      model.addAttribute("pageNo",intPageNo);
	      model.addAttribute("rowsPerPage",rowsPerPage);
	      model.addAttribute("pagesPerGroup",pagesPerGroup);
	      model.addAttribute("totalBoardNo",totalBoardNo);
	      model.addAttribute("totalPageNo",totalPageNo);
	      model.addAttribute("totalGroupNo",totalGroupNo);
	      model.addAttribute("groupNo",groupNo);
	      model.addAttribute("startPageNo",startPageNo);
	      model.addAttribute("endPageNo",endPageNo);
	      model.addAttribute("list",list);
				
		return "freeboard/list";
	} // list
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(){
		return "freeboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(FreeBoard freeBoard, HttpSession session){
		String mid = (String)session.getAttribute("login");
		freeBoard.setBwriter(mid);
		int result = freeBoardService.write(freeBoard);
		if(result == FreeBoardService.WRITE_FAIL){
			return "freeboard/write";
		} else{
			return "redirect:/freeboard/list";
		}
	} // write
	
	@RequestMapping("/info")
	public String info(int bno, Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		freeBoard.setBhitcount(freeBoard.getBhitcount() + 1);
		freeBoardService.modify(freeBoard);
		model.addAttribute("freeboard", freeBoard);
		return "freeboard/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		model.addAttribute("freeboard", freeBoard);
		return "freeboard/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(FreeBoard freeBoard){
		FreeBoard dbFreeBoard = freeBoardService.info(freeBoard.getBno());
		freeBoard.setBhitcount(dbFreeBoard.getBhitcount());
		freeBoardService.modify(freeBoard);
		return "redirect:/freeboard/list";
	} // modify
	
	@RequestMapping("/remove")
	public String remove(int bno){
		freeBoardService.remove(bno);
		return "redirect:/freeboard/list";
	}
	
} // class



/*
@RequestMapping("/list")
public String list(
		String pageNo,	
		@ModelAttribute("pageNo") Integer sessionPageNo, Model model, HttpSession session){
									//int는 null이 없으므로 integer로 !
	System.out.println(pageNo);
	System.out.println(sessionPageNo);
	
	int intPageNo = 1;
	
	if(pageNo != null){ 
		intPageNo = Integer.parseInt(pageNo);
	}else if(sessionPageNo != null) {
		intPageNo = sessionPageNo;
	}
	

	int rowsPerPage = 10;
	int pagesPerGroup = 5;
	
	int totalBoardNo = freeBoardService.getCount();
	
	int totalPageNo = (totalBoardNo/rowsPerPage) + ((totalBoardNo%rowsPerPage!=0)?1:0);
	int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
	
	int groupNo = (intPageNo-1)/pagesPerGroup + 1;
	int startPageNo = (groupNo-1)*pagesPerGroup + 1;
	int endPageNo = startPageNo + pagesPerGroup - 1;
	if(groupNo == totalGroupNo) { endPageNo = totalPageNo; }
	
	List<FreeBoard> list = freeBoardService.list(intPageNo, rowsPerPage);
	
	model.addAttribute("pageNo", intPageNo);
	model.addAttribute("rowsPerPage", rowsPerPage);
	model.addAttribute("pagesPerGroup", pagesPerGroup);
	model.addAttribute("totalBoardNo", totalBoardNo);
	model.addAttribute("totalPageNo", totalPageNo);
	model.addAttribute("totalGroupNo", totalGroupNo);
	model.addAttribute("groupNo", groupNo);
	model.addAttribute("startPageNo", startPageNo);
	model.addAttribute("endPageNo", endPageNo);
	model.addAttribute("list", list);
			
	return "freeboard/list";
} // list
*/