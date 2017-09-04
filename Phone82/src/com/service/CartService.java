package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.CartDAO;
import com.dto.CartDTO;
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
			throw new MyException("cartAllList 실패");
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
			throw new MyException("amountUpdate 실패");
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
			throw new MyException("delCart 실패");
		} finally {
			session.close();
		}
	}

	public CartDTO orderConfirm(int num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		CartDTO dto = null;
		try {
			dto = dao.orderConfirm(session, num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("orderConfirm 실패");
		} finally {
			session.close();
		}
		return dto;
	}

}
