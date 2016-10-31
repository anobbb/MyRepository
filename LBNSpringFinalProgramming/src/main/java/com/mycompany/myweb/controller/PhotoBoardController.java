package com.mycompany.myweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.PhotoBoard;
import com.mycompany.myweb.service.PhotoBoardService;

@Controller
@RequestMapping("/photoboard")
public class PhotoBoardController {

	@Autowired
	private PhotoBoardService photoBoardService;
	
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session){
		
		int intPageNo = 1;
	      if (pageNo == null) { 
	         pageNo = (String) session.getAttribute("pageNo");
	         if (pageNo != null) {
	            intPageNo = Integer.parseInt(pageNo);
	         }
	      } else { 
	         intPageNo = Integer.parseInt(pageNo);
	      }
	      session.setAttribute("pageNo", String.valueOf(intPageNo));
	      
	      
	      int rowsPerPage = 8;
	      int pagesPerGroup = 5;
	      
	      int totalBoardNo = photoBoardService.getCount();
	      
	      int totalPageNo = (totalBoardNo/rowsPerPage)+((totalBoardNo%rowsPerPage!=0)?1:0);
	      int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);
	      
	      int groupNo = (intPageNo-1)/pagesPerGroup + 1;
	      int startPageNo = (groupNo-1)*pagesPerGroup + 1;
	      int endPageNo = startPageNo + pagesPerGroup - 1;
	      
	      if (groupNo == totalGroupNo) {
	         endPageNo = totalPageNo;
	      }
	      List<PhotoBoard> list = photoBoardService.list(intPageNo, rowsPerPage);
	      
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
				
		return "photoboard/list";
	} // list
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(){
		return "photoboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(PhotoBoard photoBoard, HttpSession session){
		try {
			String mid = (String)session.getAttribute("login");
			photoBoard.setBwriter(mid);
			
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			
			String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename();
			// 저장할 파일의 절대 경로, realpath부분이 실제 파일 저장 실행 코드
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + savedfile); 
			// C:/users/.....실제 workspace
			photoBoard.getPhoto().transferTo(new File(realpath)); // 실제 파일을 파일시스템에 저장(!=DB)
			
			photoBoard.setSavedfile(savedfile); // DB저장내용: 파일명
			
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType()); // DB저장내용: 파일 타입
			
			int result = photoBoardService.write(photoBoard);
			return "redirect:/photoboard/list";
		} catch(Exception e){
			e.printStackTrace();
			return "photoboard/write";
		}
	} // write
	
	@RequestMapping("/showPhoto")
	public void showPhoto(String savedfile, HttpServletRequest request, HttpServletResponse response){
		try{
		String fileName = savedfile;
		
		
		String mimeType = request.getServletContext().getMimeType(fileName);
	    response.setContentType(mimeType);
	    
	    //파일을 다운받게함, \"파일명\" -> 문자인식, 
		OutputStream os = response.getOutputStream();
		
		String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/" + fileName);
		InputStream is = new FileInputStream(filePath);
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while((byteNum = is.read(values)) != -1) {
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close();
		os.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	} // showPhoto
	
	@RequestMapping("/info")
	public String info(int bno, Model model){
		PhotoBoard photoBoard = photoBoardService.info(bno);
		photoBoard.setBhitcount(photoBoard.getBhitcount() + 1);
		photoBoardService.modify(photoBoard);
		model.addAttribute("photoboard", photoBoard);
		return "photoboard/info";
	} // info
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model){
		PhotoBoard photoBoard = photoBoardService.info(bno);
		model.addAttribute("photoboard", photoBoard);
		return "photoboard/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(PhotoBoard photoBoard,HttpSession session){
		PhotoBoard dbPhotoBoard = photoBoardService.info(photoBoard.getBno());
		photoBoard.setBhitcount(dbPhotoBoard.getBhitcount());
		photoBoardService.modify(photoBoard);
		try {
			String mid = (String)session.getAttribute("login");
			photoBoard.setBwriter(mid);
			
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			
			String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename();
			
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + savedfile); 
			
			photoBoard.getPhoto().transferTo(new File(realpath)); 
			
			photoBoard.setSavedfile(savedfile); 
			
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType()); // DB저장내용: 파일 타입
			
			int result = photoBoardService.write(photoBoard);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/photoboard/list";
	}
	
	@RequestMapping("/remove")
	public String remove(int bno){
		photoBoardService.remove(bno);
		return "redirect:/photoboard/list";
	}
	
} // class
