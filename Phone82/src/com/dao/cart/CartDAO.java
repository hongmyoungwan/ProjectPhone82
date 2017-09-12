package com.dao.cart;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.cart.CartDTO;

public class CartDAO {

	
	
	
	public List<CartDTO> cartAllList(SqlSession session , String userid) {
		
		return session.selectList("cartAllList",userid);
	}

	public int amountUpdate(SqlSession session, HashMap<String, Integer> map) { // ���� update
		
		return session.update("amountUpdate", map);
	}

	public int delItem(SqlSession session, int num) {	//������ ����
		// TODO Auto-generated method stub
		
		return session.delete("deleteItem", num);
	}

	public CartDTO orderConfirm(SqlSession session, int num) { //�ֹ� Ȯ��â

		return session.selectOne("orderConfirm",num);
	}

	public int insertItem(SqlSession session, CartDTO dto) {
		// TODO Auto-generated method stub
		int n=0;
		try {
		 n=session.insert("insertItem",dto);
		}
		catch(Exception e) {
			System.out.println("CartDAO Error");
			e.printStackTrace();
		}
		 return n;
	}
}
