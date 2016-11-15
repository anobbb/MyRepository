package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.PhotoBoardDao;
import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardService {
	
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private PhotoBoardDao photoBoardDao;
	
	public List<PhotoBoard> list(int pageNo, int rowsPerPage){
		return photoBoardDao.selectByPage(pageNo, rowsPerPage);
	} // list
	
	public int write(PhotoBoard photoBoard){
		int row = photoBoardDao.insert(photoBoard);
		return WRITE_SUCCESS;		
	} // write
	
	public int modify(PhotoBoard photoBoard){
		int row = photoBoardDao.update(photoBoard);
		if(row == 0) { return MODIFY_FAIL; } // where 조건절이 안 맞을 경우(내 목록에서는 보이지만 그 사이에 관리자가 삭제했을 경우)
		return MODIFY_SUCCESS;
	} // modify
	
	public int remove(int bno){
		int row = photoBoardDao.delete(bno);
		if(row == 0) { return REMOVE_FAIL; } // where 조건절이 안 맞을 경우(내 목록에서는 보이지만 그 사이에 관리자가 삭제했을 경우)
		return REMOVE_SUCCESS;
	} // remove
	
	public PhotoBoard info(int bno){
		return photoBoardDao.selectByBno(bno);
	} // info
	
	public int getCount(){
		return photoBoardDao.count();
	}
}
