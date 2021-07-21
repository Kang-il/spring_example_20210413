package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04/ex01")
@Controller

public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
	
	//요청 URL : http://localhost:8080/lesson04/ex01/1
	@RequestMapping(path = "/1" , method = RequestMethod.GET )//경로외 다른 속성 추가시 path 를 붙임. 
	public String addUserView() {
		return "lesson04/addUser"; //suffix prefix 제외 한 view 경로
	}
	
	@PostMapping("/add_user") //POST 메서드만 받아오는 Annotation
	public String addUser(
			@RequestParam("name") String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam(value="email" , required = false) String email //비 필수 파라미터
			,@RequestParam(value = "introduce", required = false) String introduce //비 필수 파라미터
			//email 과 introduce는 비 필수이므로 null값이 넘어올 수 있도록 해준다.
			) {
		//Request->Response
		
		newUserBO.insertNewUser(name, yyyymmdd, email, introduce);
		
		//return : 성공이 되었는지 태그를 입혀 다른 화면으로 넘길 것
		//결과jsp
		return "/lesson04/afterAddUser"; //
	}
	
	

	/**
	 * 가장 최근에 추가된 사람 한 명 가져오기
	 * @return
	 */
	//요청URL http://localhost:8080/lesson04/ex01/get_last_user
	@GetMapping("/get_last_user")
	public String getLastUser(Model model) {//view 화면에 데이터를 담아 넘겨주는 객체
		//ModelAndView : 결과값을 담고 뷰페이지로 리턴하는 객채
		//ModelAndView 는 요즘 잘 사용하지 않는 객체..
		NewUser newUser=newUserBO.selectLastUser() ;
		
		//.addAttribute -- 첫 번째 매개변수 "key" 두 번째 매개변수 "value"(Object 어떤 객체든 담을 수 있다.)
		model.addAttribute("result", newUser); //결과 jsp에 view결과 객체값을 넘겨준다.
		model.addAttribute("subject", "회원정보");		
		
		return "/lesson04/getLastUser";
	}
	
	
}
