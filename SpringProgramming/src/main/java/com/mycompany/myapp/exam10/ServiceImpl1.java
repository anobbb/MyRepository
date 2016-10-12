package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl1 implements Service{
	private static final Logger logger = LoggerFactory.getLogger(ServiceImpl1.class);
	
	public ServiceImpl1(){
		logger.info("ServiceImpl1 객체 생성");
	}
	
	@Override
	public void method() {
		logger.info("method 실행");
	}
}
