package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	//#######SELECT EX
	public Review selectReview(@Param("id") int id);
	
	//#######INSERT EX
	public int insertReview(Review review);//Review 객체의 내용을 row 로 추가할 것이다.
	public int insertReviewAsField(
			@Param("storeName") String storeName
			,@Param("menu") String munu
			,@Param("userName") String userName
			,@Param("point") double point
			,@Param("review") String review
			);
	
	//#######UPDATE EX
	public int updateReview(
			@Param("id") int id
			,@Param("review") String review);
	
	//#######DELETE EX
	public int deleteReviewById(int id);
}
