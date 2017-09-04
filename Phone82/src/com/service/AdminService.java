package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dao.AdminDAO;
import com.dto.AdminDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class AdminService {
		
	public AdminDTO getAdmin(HashMap<String, String> map) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		AdminDTO dto=null;
		AdminDAO dao = new AdminDAO();
		try {
			dto=dao.getAdminData(session, map);
		}catch (Exception e) {
			e.printStackTrace();
			throw new MyException("���� ���� ���� ���� ����");
		}
		return dto;
	}

}
