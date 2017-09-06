package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.AdminDTO;
import com.dto.SalesDTO;

public class AdminDAO {

	
	public AdminDTO getAdminData(SqlSession session ,HashMap<String,String> map) {
		return session.selectOne("getAdminData",map);
	}

	public List<SalesDTO> getSalesChartDatas(SqlSession session) {
		
		return session.selectList("getSalesChartDatas");
	}
}
