package com.mycompany.lbnapptest.test09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceDImpl1 implements ServiceD{
	private static final Logger logger = LoggerFactory.getLogger(ServiceDImpl1.class);
	
	public ServiceDImpl1(){
		logger.info("ServiceDImpl1 객체 생성");
	}
	
	@Override
	public void method() {
		logger.info("method 실행");
	}

}
