package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.lesson04.bo.NewStudentBO;
import com.example.lesson04.model.NewStudent;

@RequestMapping("/lesson04/ex02")
@Controller
public class NewStudentController {
	
	@Autowired
	private NewStudentBO newStudentBO;
	
	//요청URL http://localhost:8080/lesson04/ex02/1
	@RequestMapping(path="/1",method = RequestMethod.GET)
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute NewStudent newStudent//name 태그의 값과 일치하는 setter를 이용해 값을 세팅할 것
			,Model model
			){
		//INSERT DB -->  SELECT (해당 문)
		//가장 마지막으로 추가된 데이터를 가져오는 것은 TIMING ISSUE 발생 가능성이 있음.
		//insertDB
		newStudentBO.addNewStudent(newStudent); //xml파일에서 INSERT쿼리 실행 후 자동으로 id값이 채워짐
		
		
		//기존 객체에 새로운 객체값을 내리는 것 보다 view에 내려주는 객체는 새로 만들어 주는 것이 좋음
		NewStudent newStudent02 = newStudentBO.getNewStudentById(newStudent.getId());
		
		model.addAttribute("result", newStudent02);
		model.addAttribute("subject", "학생 정보");
		
		return "lesson04/afterAddStudent"; //추가된 학생 정보를 나타내는 JSP
	}
	
}
