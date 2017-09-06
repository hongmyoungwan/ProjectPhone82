package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.PhoneDTO;



public class PhoneListDAO {

	public List<PhoneDTO> PhoneList(SqlSession session) {
		List<PhoneDTO> list = session.selectList("PhoneList");
		System.out.println(list);
		return list;
	}
	public PhoneDTO phoneRetrieve(SqlSession session, String telecom_num) {
		PhoneDTO dto = session.selectOne("phoneRetrieve",telecom_num);
		return dto;
	}
	public List<PhoneDTO> phoneModelList(SqlSession session,String phone_model_num) {
		List<PhoneDTO> list = session.selectList("phoneModelList",phone_model_num);
		System.out.println(list);
		return list;
	}
	
}
