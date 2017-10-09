package com.dao.qna;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.qna.QNADTO;
import com.dto.qna.QNAPageDTO;

public class QNADAO {
	
	public List<QNADTO> qnaList(SqlSession session,HashMap<String, String> map){
		List<QNADTO> list=session.selectOne("qnaList",map);
		return list;
	}
	
	public QNAPageDTO qnapage(SqlSession session, int curPage, int perPage, HashMap<String,String> map) {
		QNAPageDTO dto=new QNAPageDTO();
		int index=(curPage-1)*perPage;
		
		int totalCount=0;
		if(map.get("searchValue")==null) {
			totalCount=session.selectOne("qnatotalCount");
			System.out.println("this SearchValue null");
		}
		else {
			totalCount=session.selectOne("qnatotalCount1",map);
		}
		List<QNADTO> list=session.selectList("qnaList",map, new RowBounds(index, perPage));	
		dto.setList(list);
		dto.setCurPage(curPage);
		dto.setPerPage(perPage);
		dto.setTotalCount(totalCount);
		dto.setSearchName(map.get("searchName"));
		dto.setSearchValue(map.get("searchValue"));
		return dto;
	}
	public int qnainsert(SqlSession session,QNADTO dto) {
		int n=session.insert("qnainsert",dto);
		return n;
	}
	
	public int qnadelete(SqlSession session,HashMap<String,String> map) {
		int n=session.delete("qnadelete",map);
		return n;
	}
	public List<QNADTO> qnaretrieve(SqlSession session, int num){
		List<QNADTO> list=session.selectList("qnaselectByNum", num);
		return list;
	}
	
	public QNADTO qnaselectByNum(SqlSession session,int num) {
		QNADTO dto=session.selectOne("qnaselectByNum",num);
		return dto;
	}
	
	public int qnareadCnt(SqlSession session,int num) {
		int n=session.update("qnareadCnt",num);
		return n;
	}
	
	public int qnaupdateByNum(SqlSession session,QNADTO dto) {
		int n=session.update("qnaupdateByNum",dto);
		return n;
	}
}
