package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.AdminDAO;
import com.dto.AdminDTO;
import com.dto.MonthSales;
import com.dto.SalesDTO;
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
			throw new MyException("어드민 계정 갖고 오기 실패");
		}
		finally {
			if(session!=null)
				session.close();
		}
		return dto;
	}
	public List<MonthSales> getSalesChartDatas(HashMap<String, String> map) throws MyException {
		
		SqlSession session =MybatisTemplate.openSession();
		List<MonthSales> list=null;
		AdminDAO dao= new AdminDAO();
		try {
			list= dao.getSalesChartDatas(session,map);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new MyException("getSalesChartDatas 실패");
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}

}
