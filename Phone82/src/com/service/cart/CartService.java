package com.service.cart;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.cart.CartDAO;
import com.dto.cart.CartDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class CartService {

	public List<CartDTO> cartAllList(String userid) throws MyException {// 
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		List<CartDTO> dto = null;
		try {
			dto = dao.cartAllList(session, userid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("cartAllList error");
		} finally {
			if (session != null)
				session.close();
		}
		return dto;
	}// cartAllList

	public void amountUpdate(HashMap<String, Integer> map) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		try {
			int n = dao.amountUpdate(session, map);
			if (n == 1)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("amountUpdate error");
		} finally {
			session.close();
		}

	}

	public void delItem(int num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		try {
			int n = dao.delItem(session, num);
			if (n == 1)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("delCart error");
		} finally {
			session.close();
		}
	}

	public CartDTO orderConfirm(CartDTO dto2) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		CartDTO dto = null;
		try {
			dto = dao.orderConfirm(session, dto2);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("orderConfirm error");
		} finally {
			session.close();
		}
		return dto;
	}

	public void insertItem(CartDTO dto) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		int n=0;
		try {
			n = dao.insertItem(session, dto);
			if(n==1)
				session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new MyException("insertItem error");
		} finally {
			session.close();
		}
		
	}

	public String createOrderNum() throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		String number;
		try {
			number = String.valueOf(dao.createOrderNum(session));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("amountUpdate error");
		} 
		return number;
	}

}
