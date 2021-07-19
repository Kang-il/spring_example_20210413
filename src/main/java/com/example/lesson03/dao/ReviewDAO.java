package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(@Param("id") int id);
	public int insertReview(Review review);//Review 객체의 내용을 row 로 추가할 것이다.
	public int insertReviewAsField(
			@Param("storeName") String storeName
			,@Param("menu") String munu
			,@Param("userName") String userName
			,@Param("point") double point
			,@Param("review") String review
			);
}
