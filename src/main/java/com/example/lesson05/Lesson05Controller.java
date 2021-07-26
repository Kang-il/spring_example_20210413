package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	@RequestMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@RequestMapping("/ex02")
	public String ex02(Model model) {
		
		//list
		List<String> fruits=new ArrayList<String>();
		
		fruits.add("apple");
		fruits.add("melon");
		fruits.add("peach");
		fruits.add("grape");
		fruits.add("mango");
		
		model.addAttribute("fruits", fruits);
		
		//List<Map>
		List<Map<String, Object>> users=new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map1= new HashMap<String,Object>();
		
		map1.put("name", "최강일");
		map1.put("age", 27);
		map1.put("hobby", "노래하기");
		
		users.add(map1);
		
		map1=new HashMap<String,Object>();

		map1.put("name", "최강삼");
		map1.put("age", 25);
		map1.put("hobby", "축구하기");
		
		users.add(map1);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
	@RequestMapping("/ex03")
	public String ex03(Model model) {
		Date today = new Date();
		model.addAttribute("today", today);
		
		return "lesson05/ex03";
	}
	
}
