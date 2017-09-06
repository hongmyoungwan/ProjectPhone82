package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;

public class MemberDAO {

	
	


	public MemberDTO getMemberData(SqlSession session, String userid) {
		
		return session.selectOne("getMemberData",userid);
	}
}
