package com.dao.cart;

import org.apache.ibatis.session.SqlSession;

import com.dto.cart.OrderDTO;
import com.dto.cart.SalesDTO;

public class OrderDAO {

	public int orderHistory(SqlSession session, OrderDTO dto) {
	
		return session.insert("addOrder",dto);
				
	}
	public int insertSales(SqlSession session,SalesDTO dto ) {
		return session.insert("addSales",dto);
	}

}
