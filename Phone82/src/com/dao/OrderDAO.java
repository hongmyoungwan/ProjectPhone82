package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.OrderDTO;

public class OrderDAO {

	public int orderHistory(SqlSession session, OrderDTO dto) {
		return session.insert("addOrder",dto);
				
	}

}
