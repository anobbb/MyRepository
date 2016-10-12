package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class G {
	private static final Logger logger = LoggerFactory.getLogger(G.class);
	
	public G(){
		logger.info("G 객체 생성");
	}
	
	public void method(){
		logger.info("method 생성");
	}
}
