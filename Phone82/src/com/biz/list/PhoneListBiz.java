package com.biz.list;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.list.PhoneListDAO;
import com.dto.list.PhoneDTO;
import com.exception.list.MyException;
import com.mybatis.MybatisTemplate;


public class PhoneListBiz {

	public List<PhoneDTO> PhoneList( )throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		PhoneListDAO dao = new PhoneListDAO();
		List<PhoneDTO> dto = null;
		try {
		   dto = dao.PhoneList(session);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("PhoneList 실패");
		}finally {
			session.close();
		}
		return dto;
	}//PhoneList()
	public PhoneDTO phoneRetrieve(String telecom_num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		PhoneListDAO dao = new PhoneListDAO();
		PhoneDTO dto = null;
		
		try {
			dto=dao.phoneRetrieve(session, telecom_num);
			}catch(Exception e) {
				e.printStackTrace();
				throw new MyException("phoneRetrieve 실패");
			}finally {
				session.close();
			}
		return dto;
	}
	
	
	public List<PhoneDTO> phoneModelList(String phone_model_num )throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		PhoneListDAO dao = new PhoneListDAO();
		List<PhoneDTO> dto = null;
		try {
		   dto = dao.phoneModelList(session,phone_model_num);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("phoneModelList 실패");
		}finally {
			session.close();
		}
		return dto;
	}//PhoneList()
	
	public void PhoneAdd(HashMap<String, String> map) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		PhoneListDAO dao = new PhoneListDAO();
		try {
			int n = dao.PhoneAdd(session, map);
			if(n==1) session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("PhoneAdd 실패");
		}finally {
			session.close();
		}
	}
	
	
	public void phoneUpdate(HashMap<String, String> map) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		PhoneListDAO dao = new PhoneListDAO();
		try {
			int n = dao.phoneUpdate(session, map);
			if(n==1) session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("phoneUpdate 실패");
		}finally {
			session.close();
		}
	}
	
	
	public void phoneDelete(String telecom_num) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		PhoneListDAO dao = new PhoneListDAO();
		try {
			int n = dao.phoneDelete(session, telecom_num);
			if(n==1) session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("phoneDelete 실패");
		}finally {
			session.close();
		}
	}
	
	
	
	
	
	
	
	
	
}
