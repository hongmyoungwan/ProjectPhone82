package com.dao.list;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.list.PhoneDTO;



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
	public int PhoneAdd(SqlSession session,HashMap<String, String> map) {
		int n = session.insert("PhoneAdd",map);
		return n;
	}
	public int phoneUpdate(SqlSession session, HashMap<String, String> map) {
		int n = session.update("phoneUpdate",map);
		return n;
	}
	public int phoneDelete(SqlSession session,String telecom_num) {
		int n = session.delete("phoneDelete",telecom_num);
		return n;
	}
}
