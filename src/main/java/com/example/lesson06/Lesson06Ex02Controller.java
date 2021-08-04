package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private NewUserBO newUserBO;
	
	@RequestMapping("/add_name")
	public String addName() {
		return "lesson06/addName";
	}
	
	@GetMapping("/is_duplication")
	@ResponseBody //JSON 형태로 return해주기 위해 붙이는 어노테이션
	public Map<String,Boolean> idDuplication(@RequestParam("name") String name){

		Map<String,Boolean> result=new HashMap<String,Boolean>();
		boolean isDuplication= newUserBO.existNewUserByName(name);
		
		result.put("is_duplication", isDuplication);
		return result;
	}
	
}
