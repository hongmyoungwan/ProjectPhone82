package com.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.admin.AdminDTO;
import com.dto.cart.SalesDTO;
import com.dto.member.MemberDTO;

public class AdminDAO {

	public AdminDTO getAdminData(SqlSession session, HashMap<String, String> map) {
		return session.selectOne("getAdminData", map);
	}

	public List<SalesDTO> getSalesChartDatas(SqlSession session, HashMap<String, String> map) {

		List<SalesDTO> list = session.selectList("getSalesChartDatas", map);

		return list;
	}

	public List<MemberDTO> getAllMemberData(SqlSession session) {
		// TODO Auto-generated method stub
		
		List<MemberDTO> list=session.selectList("getAllMemberData");
		
		return list;
	}

	public List<MemberDTO> getMemberData(SqlSession session, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		int curPage= Integer.parseInt(map.get("curPage"));
		int curIdx= Integer.parseInt(map.get("curIdx"));
		int perPage= Integer.parseInt(map.get("perPage"));
		
		List<MemberDTO> list=session.selectList("getAllMemberData",null, new RowBounds(1,3));
		
		return list;
	}
	public int membersDelete(SqlSession session, ArrayList<String> num) {
		int n = 0;
		try {
			n = session.delete("membersDelete", num);
		} catch (Exception ex) {
			System.out.println("dberror");
			ex.printStackTrace();
		}
		System.out.println(n);
		return n;
	}

}
