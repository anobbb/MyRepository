
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
	      
	      
	      int rowsPerPage = 8;
	      int pagesPerGroup = 5;
	      
	      int totalBoardNo = photoBoardService.getCount();//전체 게시물 수 구하기
	      
	      int totalPageNo = (totalBoardNo/rowsPerPage)+((totalBoardNo%rowsPerPage!=0)?1:0);//전체 페이지수
	      int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);//전체 그룹수
	      
	      int groupNo = (intPageNo-1)/pagesPerGroup + 1;//현재 그룹의 번호
	      int startPageNo = (groupNo-1)*pagesPerGroup + 1;//그룹의 첫번째 번호 구하기
	      int endPageNo = startPageNo + pagesPerGroup - 1;//그룹의 마지막 번호 구하기
	      
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
		/*
		 *
		 // 브라우저에서 보여주지 않고 강제로 다운로드할 경우
		//파일명 한글일 경우 encoding해서 16진수화 함
		String fileName = savedfile;
		fileName = URLEncoder.encode(fileName,"UTF-8"); //파일 이름을 UTF-8로 인코딩을 함 
	    response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");  
		*/
		
		String mimeType = request.getServletContext().getMimeType(fileName);
	    response.setContentType(mimeType);
	    
	    //파일을 다운받게함, \"파일명\" -> 문자인식, 
		OutputStream os = response.getOutputStream();
		
		//실제 파일의 경로 얻기(URL상의 경로)
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
	
} // class

