package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Controller {
	@Autowired
	private NewUserBO newUserBO;
	
	/**
	 * 사용자 추가화면
	 * @return
	 */
	@RequestMapping("/add_new_user_view")
	public String addUserView() {
		return "lesson06/addNewUser";
	}
	
	
	@PostMapping("/add_new_user")
	@ResponseBody
	public String addNewUser(
			@RequestParam("name") String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam(value="email",required=false) String email
			,@RequestParam(value="introduce",required=false) String introduce
			) {
		newUserBO.addNewUser(name, yyyymmdd, email, introduce);
		//DBinsert
		return "success";
	}
}
