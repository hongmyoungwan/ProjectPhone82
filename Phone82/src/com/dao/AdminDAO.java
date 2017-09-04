package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.AdminDTO;

public class AdminDAO {

	
	public AdminDTO getAdminData(SqlSession session ,HashMap<String,String> map) {
		return session.selectOne("getAdminData",map);
	}
}
