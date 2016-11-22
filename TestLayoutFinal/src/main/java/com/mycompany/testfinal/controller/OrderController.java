package com.mycompany.testfinal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.testfinal.dto.DetailOrder;
import com.mycompany.testfinal.dto.Extra;
import com.mycompany.testfinal.dto.ExtraOrder;
import com.mycompany.testfinal.dto.Menu;
import com.mycompany.testfinal.dto.Order;
import com.mycompany.testfinal.dto.OrderItem;
import com.mycompany.testfinal.service.ExtraOrderService;
import com.mycompany.testfinal.service.ExtraService;
import com.mycompany.testfinal.service.MenuService;
import com.mycompany.testfinal.service.OrderItemService;
import com.mycompany.testfinal.service.OrderService;

//이명진
@Controller
@RequestMapping("/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	ExtraOrderService extraOrderService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	MenuService munuService;
	
	@Autowired
	ExtraService extraService;
	
	
	//주문전체 내역 페이지
	@RequestMapping("/list")
	public String list(String pageNo,Model model,HttpSession session){
		int intPageNo = 1;
		if(pageNo == null){
			pageNo = (String)session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		}else{
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		int totalBoardNo = orderService.getCount();
		int totalPageNo = totalBoardNo/rowsPerPage+((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup+((totalPageNo%pagesPerGroup!=0)?1:0);
		int groupNo = (intPageNo-1)/pagesPerGroup+1;
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		int endPageNo = startPageNo + pagesPerGroup-1;
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Order> list = orderService.listAll(intPageNo, rowsPerPage);
		
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		
		model.addAttribute("list", list);
		
		return "order/list";
	}
	//주문내역 기간보기
	@RequestMapping(value="/termList", method=RequestMethod.POST)
	public String termList(String date1, String date2, String pageNo, Model model, HttpSession session) throws ParseException{
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date term1 = transFormat.parse(date1);
		Date term2 = transFormat.parse(date2);
		
		logger.info(""+term1);
		logger.info(""+term2);
		
		int intPageNo = 1;
		if(pageNo == null){
			pageNo = (String)session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		}else{
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		int totalBoardNo = orderService.getCount();
		int totalPageNo = totalBoardNo/rowsPerPage+((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup+((totalPageNo%pagesPerGroup!=0)?1:0);
		int groupNo = (intPageNo-1)/pagesPerGroup+1;
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		int endPageNo = startPageNo + pagesPerGroup-1;
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Order> list = orderService.listTerm(intPageNo, rowsPerPage, term1, term2);
		
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("list", list);
			
		return "order/termList";
	}
	
	//주문내역 상세보기(1개 주문 당)
	@RequestMapping(value="/detailList", method=RequestMethod.GET)
	public String detailList(int ogid, Model model){
		//1주문당 (품목, 수량, 사이드, 가격) -> 구해서 같이 넘겨야 됨
		List<OrderItem> orderItems = orderItemService.allOrderItemByOgid(ogid);
		List<DetailOrder> detailOrders = new ArrayList<>();
		
		int totalprice = 0 ;
		for(int i=0;i<orderItems.size();i++){
			DetailOrder detailOrder = new DetailOrder();
			String xname = ""; int itemprice = 0;
			
			Menu menu = munuService.info(orderItems.get(i).getMid());
			detailOrder.setMname(menu.getMname());//품목
			logger.info("품목:"+detailOrder.getMname());
			detailOrder.setSameItemCount(orderItems.get(i).getOrdercount());//수량
			logger.info("수량:"+detailOrder.getSameItemCount());
			itemprice += menu.getMprice();
			
			//주문 품목에 대한 모든 사이드 찾기
			List<ExtraOrder> extraOrders = extraOrderService.allExtraOrderByoneOid(orderItems.get(i).getOid());
			logger.info("extraOrders.size(): "+extraOrders.size());
			
			for(int j=0;j<extraOrders.size();j++){
				Extra extra = extraService.info(extraOrders.get(j).getXid());
				xname += extra.getXname()+" ";
				itemprice += extra.getXprice();
			}
			detailOrder.setXname(xname);//사이드 이름들
			logger.info("사이드 이름들:"+detailOrder.getXname());
			
			
			int tempitemprice = itemprice*orderItems.get(i).getOrdercount();
			detailOrder.setSameItemPrice(tempitemprice);//1주문 동일 품목(메뉴 사이드) 가격
			totalprice += tempitemprice;
			logger.info("가격:"+detailOrder.getSameItemPrice());
			
			detailOrder.setTotalprice(totalprice);//1 주문 총가격
			detailOrder.setOghowpay(orderService.SearchOne(ogid).getOghowpay());//결제 방법
			detailOrders.add(i,detailOrder);
		}
		
		model.addAttribute("detailOrders", detailOrders);
		
		
		
		return "order/detailList";
	}
	
	//주문하기(진행 중)
	@RequestMapping(value="/orderItems",method=RequestMethod.GET)
	public String orderForm(){
		return "order/orderForm";
	}
	
	//-------------------------------------------------------------------------------
	
	//메뉴 전체 검색
	@RequestMapping(value="/allMenuSearch",method=RequestMethod.GET)
	public String allMenuSearch(){
		
		return "order/allMenuSearch";
	}
	
	//메뉴 커피or티 검색 //메뉴 단어 검색
	@RequestMapping(value="/someMenuSearch",method=RequestMethod.GET)
	public String someMenuSearch(String mname){
		logger.info("mname: "+mname);
		
		return "order/someMenuSearch";
	}
	
	
	//주문하기(진행 중)
	@RequestMapping(value="/orderItems",method=RequestMethod.POST)
	public String order(){
		
			
		return "redirect:/order/list";
	}
	
}
