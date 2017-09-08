package com.dao.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.admin.AdminDTO;
import com.dto.cart.SalesDTO;
import com.dto.member.MemberDTO;

public class AdminDAO {

	
	public AdminDTO getAdminData(SqlSession session ,HashMap<String,String> map) {
		return session.selectOne("getAdminData",map);
	}

	public List<SalesDTO> getSalesChartDatas(SqlSession session, HashMap<String, String> map) {
			
		List<SalesDTO> list= session.selectList("getSalesChartDatas",map);
	
		return list;
	}

	public List<MemberDTO> getAllMemberData(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("getAllMemberData");
	}

	public int membersDelete(SqlSession session) {
		
		return session.delete("membersDelete");
	}
	

}

