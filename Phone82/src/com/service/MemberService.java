package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class MemberService {

	public MemberDTO getMemberData(String userid) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
		   dto = dao.getMemberData(session, userid);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("getMemberData ½ÇÆÐ");
		}finally {
			session.close();
		}
		return dto;
	}

}
