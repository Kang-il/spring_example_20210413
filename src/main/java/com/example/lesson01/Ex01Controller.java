package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/lesson01/ex01") 
// 위의 URL주소를 먼저 읽고 하위에 있는 동일 어노테이션의 URL을 합치는 것
// 메소드에 붙은 mapping보다 먼저 읽는다
@Controller //Controller Spring bean : 스프링이 관리해 주는 객체
public class Ex01Controller { //Controller : 스프링에서 사용되는 용어
	
	//요청 URL : http://localhost/lesson01/ex01/1
	@RequestMapping("/1") //Controller과 함께 있어야 함 URL주소 맵핑
	@ResponseBody //Return 되는 값을 HTML Response Body로 보낸다.
	public String printString() {
		String text="예제 1번<br> 문자열을 <b>response body</b> 로 보내는 예제.";
		return text;
	}
	
	//요청URL : http://localhost/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String,Object> printMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("apple", 4);
		map.put("banana", 10);	
		map.put("orange", 125);	
		map.put("grape", 67);	
		
		// map을 리턴하면 json으로 나타난다.
		// -- build.gradle :dependencies --
		// web starter에 jackson이라는 라이브러리가 포함되어 있기 때문
		return map;
	}
}
