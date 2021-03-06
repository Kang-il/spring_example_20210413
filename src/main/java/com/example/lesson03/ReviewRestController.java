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
	
	
	//#####SELECT EX
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
	
	//#####INSERT EX
	//요청 URL : http://localhost/lesson03/ex02
	@RequestMapping("/lesson03/ex02")
	public String ex02() {
		Review review=new Review();
		review.setStoreName("보람 삼겹살");
		review.setMenu("삼겹혼밥세트");
		review.setUserName("신보람");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 적당하네요.");
		
		int row=reviewBO.insertReview(review); //INSERT 된 row 수를 리턴 받는다.
		
		return "success row count:"+row; // @ ResponseBody로 인해 String 값 자체가 responseBody에 담긴다
	}
	
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		int row=reviewBO.insertReviewAsField("도미노피자","콤비네이션R","신바다",5.0,"역시 맛있다!!!");
		return "success row count:"+row;
	}
	
	
	//#####UPDATE EX
	//요청 URL : http://localhost:8080/lesson03/ex03?id=21&review=삼겹살은 역시 맛있어~~
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id") int id
			,@RequestParam("review") String review
			) {
		int row = reviewBO.updateReview(id,review);
		return "변경완료 : " + row ;
	}
	
	
	//#####DELETE EX
	//요청 URL : http://localhost:8080/lesson03/ex04?id=20
	@RequestMapping("/lesson03/ex04")
	public String ex04(@RequestParam( value="id",required=true ) int id) {
		int row=reviewBO.deleteReviewById(id);
		return "삭제완료 : " + row;
	}
}
