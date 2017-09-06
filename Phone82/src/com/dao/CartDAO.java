package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {

	
	
	
	public List<CartDTO> cartAllList(SqlSession session , String userid) {
		
		return session.selectList("cartAllList",userid);
	}

	public int amountUpdate(SqlSession session, HashMap<String, Integer> map) { // 수량 update
		
		return session.update("amountUpdate", map);
	}

	public int delItem(SqlSession session, int num) {	//아이템 제거
		// TODO Auto-generated method stub
		
		return session.delete("deleteItem", num);
	}

	public CartDTO orderConfirm(SqlSession session, int num) { //주문 확인창

		return session.selectOne("orderConfirm",num);
	}
}
