package com.service.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.admin.AdminDAO;
import com.dao.cart.CartDAO;
import com.dao.cart.OrderDAO;
import com.dto.cart.CartDTO;
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
				System.out.println("구매성공");
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

	public List<OrderDTO> orderList(String userid) throws MyException {
		// TODO Auto-generated method stub
	
			SqlSession session = MybatisTemplate.openSession();
			List<OrderDTO> list = null;
			OrderDAO dao = new OrderDAO();
			try {
				list = dao.orderList(session, userid);
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("orderList error");
			} finally {
				if (session != null)
					session.close();
			}
			return list;
	
	}

}
