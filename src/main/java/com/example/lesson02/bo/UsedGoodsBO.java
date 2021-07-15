package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service //비즈니스 로직이 담기는 용도의 스프링 빈 등록
public class UsedGoodsBO { //businessObject
	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	public List<UsedGoods> getUsedGoodsList(){
		return usedGoodsDAO.selectUsedGoodsList();
	}
	
}
