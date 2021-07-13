package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller //handlerMapping  -- 요청 처리
public class TestController {
	
	
	
	//Service 클래스 -- 로직 호출하여 처리하여 결과를 리턴 하는 것
	@ResponseBody
	@RequestMapping("/test1")//어떤 URL이 찍히는지 handlerMapping
	public String helloWorld() {
		return "Hello World!!!";
	}
	 
	
	// 서버는 클라이언트로 부터 요청을 가질 수 있도록 URL을 가지고 있다
	// 서버의(컴퓨터) 의 IP 주소 또는 도메인으로 접속할 수 있다.
	//1. 도메인 https://naver.com
	//2. IP https://202.179.177.22 ...
	//웹 서버는 http 프로토콜 형식으로 DB는 MYSQL 프로토콜 형식으로 데이터를 전송한다.
	
	// 프로토콜 명 ://ip주소 또는 도메인 명:포트번호/경로
	
	
	
}
