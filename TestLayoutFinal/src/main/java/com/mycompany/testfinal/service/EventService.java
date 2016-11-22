package com.mycompany.testfinal.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.testfinal.dao.EventDao;
import com.mycompany.testfinal.dto.Event;

@Component
public class EventService {
	
	@Autowired
	private EventDao eventDao;
	
//--------------------------------------------------
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	public int write(Event event){
		int row = eventDao.insert(event);
		return WRITE_SUCCESS;
	}
	 
	public int modify(Event event){
		int row = eventDao.update(event);	
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCCESS;
	}
	
	public int remove(int eid){
		int row = eventDao.delete(eid);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	} 
	
	public Event info(int eid){
		return eventDao.selectByEid(eid);		
	}
	
	public List<Event> getList(String sid){
		return eventDao.selectAll(sid);
	}
}
