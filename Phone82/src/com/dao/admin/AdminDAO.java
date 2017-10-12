package com.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.admin.AdminDTO;
import com.dto.admin.MemberMngPageDTO;
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

	/*public List<MemberDTO> getMemberData(SqlSession session, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		int curPage= Integer.parseInt(map.get("curPage"));
		int curIdx= Integer.parseInt(map.get("curIdx"));
		int perPage= Integer.parseInt(map.get("perPage"));
		
		List<MemberDTO> list=session.selectList("getAllMemberData",null, new RowBounds(1,3));
		
		return list;
	}*/
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

	public int memberUpdate(SqlSession session, MemberDTO dto) {
		// TODO Auto-generated method stub
		int n=0;
			
			n = session.update("memberUpdate", dto);
		
		return n;
	}

	public MemberMngPageDTO page(SqlSession session, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		int curPage= Integer.parseInt(map.get("curPage"));
		int curIdx= Integer.parseInt(map.get("curIdx"));
		int perPage= Integer.parseInt(map.get("perPage"));
		int index=((curPage-1))*perPage;
		System.out.println("index"+index);
		index*=(1+curIdx);
	
		int totalCount=0;System.out.println(map.get("searchValue"));
		if(map.get("searchValue")==null) {
			totalCount=session.selectOne("MembertotalCount");
		}
		else {
			totalCount=session.selectOne("MembertotalCount1",map);
		}
		
		MemberMngPageDTO dto = new MemberMngPageDTO();
		List<MemberDTO> list=session.selectList("getAllMemberData",map, new RowBounds(index,perPage));
		dto.setM_list(list);
		dto.setCurIdx(curIdx);
		dto.setCurPage(curPage);
		dto.setPerPage(perPage);
		dto.setTotalCount(totalCount);
		dto.setSearchName(map.get("searchName"));
		dto.setSearchValue(map.get("searchValue"));
		return dto;
	}

	
}
