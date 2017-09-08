package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO  login(SqlSession session,HashMap<String, String> map) {
		MemberDTO dto =  session.selectOne("login", map);
		return dto;
	}
	
	public int insertMember(SqlSession session, MemberDTO dto) {
		int n = session.insert("insertMember",dto);
		return n;
	}
	
	public MemberDTO mypage(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("mypage",userid); 
		return dto;
		
	}
	
	public int updateMember(SqlSession session, MemberDTO dto) {
		int n = session.update("updateMember",dto);
		return n;
	}
	
	public int deleteMember(SqlSession session, String userid) {
		int n = session.delete("deleteMember",userid);
		return n;
	}
	
	public String checkID(SqlSession session, String userid) {
		String str = session.selectOne("checkID",userid);
		return str;
	}

	public String checkEmail(SqlSession session, String email) {
		String str = session.selectOne("checkEmail",email);
		return str;
	}
	
	public MemberDTO findID(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto = session.selectOne("findID",map);
		return dto;
	}
	
	public MemberDTO findPasswd(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto = session.selectOne("findPasswd",map);
		return dto;
	}
	
	
	

}
