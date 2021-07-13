package com.example.lesson01;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController //@Controller + @ResponseBody :데이터를 내릴 때 주로 사용한다.
//ResponseBody 기반으로 데이터를 내리는 것
public class Ex01RestController {

	//요청 URL: http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해서 String 을 리턴 해 본다";
	}
	
	@RequestMapping("/4")
	public Map<String,String> printMap(){
		Map<String, String> map=new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		return map;
		
	}
	
	@RequestMapping("/5")
	public Data printData() {
		Data data=new Data();
		
		data.setId(1);
		data.setName("최강일");
		
		return data; //일반 bean 객체도 json으로 내려간다 (jackson 라이브러리 때문에)
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data=new Data();
		data.setId(2);
		data.setName("최강이");
		
		//크롬 > Network 탭 응답값 확인
		//return new ResponseEntity<>(data,HttpStatus.OK); //200ok
		return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
