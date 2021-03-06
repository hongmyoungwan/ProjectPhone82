package com.service.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.admin.AdminDAO;
import com.dto.admin.AdminDTO;
import com.dto.cart.SalesDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class AdminService {
		
	public AdminDTO getAdmin(HashMap<String, String> map)  {
		SqlSession session = MybatisTemplate.openSession();
		AdminDTO dto=null;
		AdminDAO dao = new AdminDAO();
		try {
			dto=dao.getAdminData(session, map);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			if(session!=null)
				session.close();
		}
		return dto;
	}
	public List<SalesDTO> getSalesChartDatas(HashMap<String, String> map) throws MyException {
		
		SqlSession session =MybatisTemplate.openSession();
		List<SalesDTO> list=null;
		AdminDAO dao= new AdminDAO();
		try {
			
			list= dao.getSalesChartDatas(session,map);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new MyException("getSalesChartDatas ddds");
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}

}
