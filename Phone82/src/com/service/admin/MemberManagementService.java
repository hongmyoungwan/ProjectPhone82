package com.service.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.admin.AdminDAO;
import com.dao.cart.MemberDAO;
import com.dto.member.MemberDTO;
import com.exception.list.MyException;
import com.mybatis.MybatisTemplate;

public class MemberManagementService {
	
	
	public List<MemberDTO> getAllMemberData() throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		AdminDAO dao = new AdminDAO();
		List<MemberDTO> dtolist =null;
		
		try {
			 dtolist = dao.getAllMemberData(session);
			 
		}catch(Exception e) {
			
			throw new MyException("getAllMemberData error");
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return dtolist;
		
	}

	public List<MemberDTO> membersDelete(int num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		AdminDAO dao = new AdminDAO();
		List<MemberDTO> list=null;
		int n = 0;
		
		try {
			 n = dao.membersDelete(session, num);
			 if(n==0) {
				 list= getAllMemberData();
				 session.commit();
			 }
		}catch(Exception e) {
			session.rollback();
			throw new MyException("membersDelete error");
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

}
