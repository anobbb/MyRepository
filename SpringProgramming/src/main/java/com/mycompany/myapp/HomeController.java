package com.mycompany.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/") // 요청을 연결함 -> http://localhost:8080/myapp/ 에서 myapp/ 즉,
							// context/의 /와 연결됨.
	public String index() {
		System.out.println("home() 실행1"); // 성능때문에 나중에 개발완료 후 지워야 함.
		logger.info("home() 실행"); // 출력여부를 조정가능하기 떄문에 안 지워도 됨(logger level조정)
		// src/main/resources->log4j.xml
		/*
		 * <!-- Application Loggers --> 
		 * <logger name="com.mycompany.myapp">
		 * <level value="off" />
		 * </logger>
		 * http://logging.apache.org/log4j/2.x/manual/customloglevels.html#
		 * CustomLoggers
		 */
		return "home"; // views == home.jsp
	}
}
