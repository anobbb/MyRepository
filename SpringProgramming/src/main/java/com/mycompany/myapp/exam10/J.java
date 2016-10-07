package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class J {
	private static final Logger logger = LoggerFactory.getLogger(J.class);
	
	private H h;
	private G g;
	
	@Autowired
	public J(H h, G g){
		logger.info("J 객체 생성");
		this.h = h;
		this.g = g;
	}
	
	public void method(){
		logger.info("method 생성");
		h.method();
		g.method();
	}
}
