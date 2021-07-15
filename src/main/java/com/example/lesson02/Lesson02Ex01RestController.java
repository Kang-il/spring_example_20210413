package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.model.UsedGoods;


@RestController
public class Lesson02Ex01RestController {
	
	@Autowired //직접 DAO를 부를 순 있지만 계층적으로 좋은 구조는 아니다.!
	private UsedGoodsBO usedGoodsBO; 
	
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01(){
		List<UsedGoods> usedGoodsList=usedGoodsBO.getUsedGoodsList();
		return usedGoodsList;
	}
	
	
}

//spring framework
//root-context.xml
//web.xml
//application.xml