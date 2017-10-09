package com.service.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.admin.AdminDAO;
import com.dao.admin.QNAResponseDAO;
import com.dao.cart.MemberDAO;
import com.dto.admin.MemberMngPageDTO;
import com.dto.member.MemberDTO;
import com.dto.qna.QNAPageDTO;
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
	/*public List<MemberDTO> getMemberData(HashMap<String,String> map) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		AdminDAO dao = new AdminDAO();
		List<MemberDTO> dtolist =null;
		MemberMngPageDTO mmpDTO = new MemberMngPageDTO();
		try {
			 dtolist = dao.getMemberData(session,map);
			 
		}catch(Exception e) {
			
			throw new MyException("getAllMemberData error");
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return dtolist;
		
	}*/
	
	public List<MemberDTO> memberUpdate(MemberDTO dto) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		AdminDAO dao = new AdminDAO();
		List<MemberDTO> list=null;
		int n = 0;
	
			
		try {
			 n = dao.memberUpdate(session, dto);
			 if(n<=1) {
		
				 session.commit();
				 list= getAllMemberData();
			 }
		}catch(Exception e) {
			session.rollback();
			throw new MyException("memberUpdate error");
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public List<MemberDTO> membersDelete(String[] num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		AdminDAO dao = new AdminDAO();
		List<MemberDTO> list=null;
		int n = 0;
		ArrayList<String>numlist= new ArrayList<>();
		for (String string : num) {
			numlist.add(string);
		}
		
		try {
			 n = dao.membersDelete(session, numlist);
			 if(n<=1) {
		
				 session.commit();
				 list= getAllMemberData();
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
	public MemberMngPageDTO page(HashMap<String, String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		AdminDAO dao=new AdminDAO();
		MemberMngPageDTO dto=null;
		try {
			dto=dao.page(session, map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("page 실패"); 
		}finally {
			session.close();
		}
		return dto;
	}//page end
}
