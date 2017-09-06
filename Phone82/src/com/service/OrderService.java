package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dao.CartDAO;
import com.dao.OrderDAO;
import com.dto.OrderDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class OrderService {

	public void orderHistory(OrderDTO dto, String num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO dao = new OrderDAO();
		CartDAO cdao= new CartDAO();
		try {
			int n = dao.orderHistory(session, dto);
			int n2= cdao.delItem(session,Integer.parseInt(num));
			if(n+n2==2) session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
			throw new MyException("orderDone ½ÇÆÐ");
		}finally {
			session.close();
		}
	}

}
