package com.dao.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.qna.QNADTO;
import com.dto.qna.QNAPageDTO;

public class QNAResponseDAO {
	public List<QNADTO> qnaList(SqlSession session,HashMap<String, String> map){
		List<QNADTO> list=session.selectOne("qnaList",map);
		return list;
	}
	
	public QNAPageDTO qnapage(SqlSession session, int curPage, int perPage, HashMap<String,String> map) {
		QNAPageDTO dto=new QNAPageDTO();
		int curIdx = Integer.parseInt(map.get("curIdx"));
		int index=((curPage-1))*perPage;
		System.out.println("index"+index);
		index*=(1+curIdx);
		List<QNADTO> list=session.selectList("AdminQNAboardList",map, new RowBounds(index, perPage));
		int totalCount=0;
		if(map.get("searchValue")==null) {
			totalCount=session.selectOne("AdminQNAtotalCount");
		}
		else {
			totalCount=session.selectOne("AdminQNAtotalCount1",map);
		}
		
		dto.setList(list);
		dto.setCurPage(curPage);
		dto.setPerPage(perPage);
		dto.setCurIdx(curIdx);
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
		/*int n=session.selectOne("AdminQNAselectCounter",num);
		if(n<=1)
			session.update("updateAnswer",num);*/
		QNADTO dto=session.selectOne("AdminQNAselectByNum",num);
		return dto;
	}
	
	public int qnareadCnt(SqlSession session,int num) {
		int n=session.update("qnareadCnt",num);
		return n;
	}
	public int qnaAnswer(SqlSession session,QNADTO dto) {
		System.out.println("test");
		int n=session.insert("AdminQNAinsertBoard",dto);
		return n;
	}
	public int qnaupdateByNum(SqlSession session,QNADTO dto) {
		int n=session.update("qnaupdateByNum",dto);
		return n;
	}
}
