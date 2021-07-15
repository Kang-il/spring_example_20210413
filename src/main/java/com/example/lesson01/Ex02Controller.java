package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //JSP를 내려줄 때는 @ResponseBody 가 사용되지 않는다.
//@ResponseBody --> data를 통으로 내릴 때 사용

public class Ex02Controller {
	//요청 url - http://localhost/lesson01/ex02/1
	
	@RequestMapping("/lesson01/ex02/1")
	//ResponseBody 가 아닌 상태로 String 을 리턴하면
	//ViewResolver에 의해 리턴 된 String 의 이름의 view를 찾고 view 화면이 구성된다.
	public String ex02_1() {
		//WEB-INF/jsp  <lesson01/ex02>  .jsp
		return "lesson01/ex02"; //jsp view 이름
	}
}
