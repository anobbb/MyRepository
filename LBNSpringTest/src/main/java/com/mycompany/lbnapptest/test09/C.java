package com.mycompany.lbnapptest.test09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C {
	private static final Logger logger = LoggerFactory.getLogger(C.class);
	//C는 D에 의존한다
	private D d;
	
	public C(D d) {
		logger.info("C 객체 생성");
		this.d = d;
	}
	
	public void method(){
		logger.info("method 실행");
		d.method();
	}
}
