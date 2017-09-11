package com.service.cart;

import org.apache.ibatis.session.SqlSession;

import com.dao.admin.AdminDAO;
import com.dao.cart.CartDAO;
import com.dao.cart.OrderDAO;
import com.dto.cart.OrderDTO;
import com.dto.cart.SalesDTO;
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
			if(n+n2==2) {
				SalesDTO sals= new SalesDTO(dto.getOrderName(),dto.getTelecom_num(),
						dto.getPhone_model_num(),dto.getPhone_price(),dto.getPhone_amount(),dto.getOrderdate());
			
				session.commit();
				}
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
			throw new MyException("orderHistory 실패");
		}finally {
			session.close();
		}
	}

}
