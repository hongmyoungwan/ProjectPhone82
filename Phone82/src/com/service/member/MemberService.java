package com.service.member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dao.member.MemberDAO;
import com.dto.member.MemberDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class MemberService {
	
	public MemberDTO login(HashMap<String, String> map) throws MyException {
		
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
			dto= dao.login(session, map);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("login 실패");
		} finally {
			session.close();
		}
		return dto;
	}
	
	public void insertMember(MemberDTO dto) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		try {
		int n = dao.insertMember(session, dto);
		if(n==1)session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("insertMember 실패");
		} finally {
			session.close();
		}
		
	}
	
public MemberDTO mypage(String userid) throws MyException {
		
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
			dto = dao.mypage(session, userid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("mypage 실패");
		} finally {
			session.close();
		}
		
		return dto;
		
	}
	
	public void updateMember(MemberDTO dto) throws MyException {
		
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		try {
			int n = dao.updateMember(session, dto);
			if(n==1) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("updateMember 실패");
		} finally {
			session.close();
		}
	
	}
	
	public void deleteMember(String userid) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		try {
			int n = dao.deleteMember(session, userid);
			if(n==1) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("deleteMember 실패");
		} finally {
			session.close();
		}
	
	}
	
	public String checkID(String userid) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		String str = null;
		try {
		str = dao.checkID(session, userid);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("checkID 실패");
		} finally {
			session.close();
		} 
		return str;
	}

	public String checkEmail(String email) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		String str = null;
		try {
			str = dao.checkEmail(session, email);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("checkEmail 실패");
		} finally {
			session.close();
		} 
		return str;
	}
	
	public MemberDTO findID(HashMap<String, String> map) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
		dto = dao.findID(session, map);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("findID 실패");
		} finally {
			session.close();
		} 
		return dto;
	}
	
	public MemberDTO findPasswd(HashMap<String, String> map) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
		dto = dao.findPasswd(session, map);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("findPasswd 실패");
		} finally {
			session.close();
		} 
		return dto;
	}

}
