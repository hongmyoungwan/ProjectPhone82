package com.dao.faq;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.faq.FAQDTO;
import com.dto.faq.FAQPageDTO;

public class FAQDAO {
	
	public List<FAQDTO> faqList(SqlSession session, HashMap<String,String> map){
		List<FAQDTO> list=session.selectOne("faqList",map);
		return list;
	}
	
	public FAQPageDTO faqpage(SqlSession session, int curPage, int perPage, HashMap<String,String> map) {
		FAQPageDTO dto=new FAQPageDTO();
		int index=(curPage-1)*perPage;
		List<FAQDTO> list=session.selectList("faqList",map, new RowBounds(index, perPage));
		int totalCount=0;
		if(map.get("searchValue")==null) {
			totalCount=session.selectOne("faqtotalCount");
		}
		else {
			totalCount=session.selectOne("faqtotalCount1",map);
		}
		
		dto.setList(list);
		dto.setCurPage(curPage);
		dto.setPerPage(perPage);
		dto.setTotalCount(totalCount);
		dto.setSearchValue(map.get("searchValue"));
		return dto;
	}
	public int faqinsert(SqlSession session,FAQDTO dto) {
		int n=session.insert("insertqna",dto);
		return n;
	}
	
	public int faqdelete(SqlSession session,String searchValue) {
		int n=session.delete("deleteqna",searchValue);
		return n;
	}
	public List<FAQDTO> faqretrieve(SqlSession session, int num){
		List<FAQDTO> list=session.selectList("faqselectByNum", num);
		return list;
	}
	
	public FAQDTO selectByNum(SqlSession session,int num) {
		FAQDTO dto=session.selectOne("faqselectByNum",num);
		return dto;
	}
	
	public int updateByNum(SqlSession session,FAQDTO dto) {
		int n=session.update("updateByNum",dto);
		return n;
	}
	
}