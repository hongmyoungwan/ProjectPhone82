package com.dao.cart;

import org.apache.ibatis.session.SqlSession;

import com.dto.cart.OrderDTO;

public class OrderDAO {

	public int orderHistory(SqlSession session, OrderDTO dto) {
		return session.insert("addOrder",dto);
				
	}

}
