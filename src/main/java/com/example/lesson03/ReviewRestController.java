package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController //@Controller @ResponseBody -->데이터만 response 로 내릴 때 사용
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	//요청 URL : http://localhost:8080/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			//@RequestParam(value="id") int id //필수파라미터 : int
			//@RequestParam(value="id", required=true) int id // 필수 파라미터
			//@RequestParam(value="id", required=false) Integer id //비 필수 파라미터(값이 없을 수도 있기 때문에 Integer로 선언)
			
			@RequestParam(value="id",defaultValue = "1") int id //비 필수 파라미터 , 기본값1
			) {
		System.out.println("#####id:"+id);
//		if(id==null) { //@RequestParam(value="id", required=false) Integer id //비 필수 파라미터(값이 없을 수도 있기 때문에 Integer로 선언) 
//			return null;
//		}
		return reviewBO.getReview(id);
	}
}