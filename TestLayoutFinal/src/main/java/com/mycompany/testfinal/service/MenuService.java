package com.mycompany.testfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.testfinal.dao.MenuDao;
import com.mycompany.testfinal.dto.Menu;

@Component 
public class MenuService {
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> list(int pageNo, int rowsPerPage, String sid){
		
		/*if( != null){
			return menuDao.searchBySid(sid);
		}*/
		return menuDao.selectByPage(pageNo, rowsPerPage, sid);
	}
	
	public int write(Menu menu){
		menuDao.insert(menu);
		return WRITE_SUCCESS;
	}
	
	public int modify(Menu menu){
		int row = menuDao.update(menu);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCCESS;
	}
	
	public int remove(int mid){
		int row = menuDao.delete(mid);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	}
	
	public Menu info(int mid){
		return menuDao.selectByMid(mid);
	}
	
	public int getCount(){
		return menuDao.count();
	}
}
