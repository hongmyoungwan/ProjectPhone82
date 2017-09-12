package com.dao.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.board.BoardDTO;
import com.dto.board.PageDTO;

public class BoardDAO {
	
	public List<BoardDTO> boardList(SqlSession session,HashMap<String, String> map){
		List<BoardDTO> list=session.selectOne("boardList",map);
		return list;
	}
	
	public PageDTO page(SqlSession session, int curPage, int perPage, HashMap<String,String> map) {
		PageDTO dto=new PageDTO();
		int index=(curPage-1)*perPage;
		List<BoardDTO> list=session.selectList("boardList",map, new RowBounds(index, perPage));
		int totalCount=0;
		if(map.get("searchValue")==null) {
			totalCount=session.selectOne("totalCount");
		}
		else {
			totalCount=session.selectOne("totalCount1",map);
		}
		
		dto.setList(list);
		dto.setCurPage(curPage);
		dto.setPerPage(perPage);
		dto.setTotalCount(totalCount);
		dto.setSearchName(map.get("searchName"));
		dto.setSearchValue(map.get("searchValue"));
		return dto;
	}
	public int insertBoard(SqlSession session,BoardDTO dto) {
		int n=session.insert("insertBoard",dto);
		return n;
	}
	
	
	public int deleteBoard(SqlSession session,HashMap<String,String> map) {
		int n=session.delete("deleteBoard",map);
		return n;
	}
	public List<BoardDTO> retrieve(SqlSession session, int num){
		List<BoardDTO> list=session.selectList("selectByNum", num);
		return list;
	}
	
	public BoardDTO selectByNum(SqlSession session,int num) {
		BoardDTO dto=session.selectOne("selectByNum",num);
		return dto;
	}
	
	public int boardreadCnt(SqlSession session,int num) {
		int n=session.update("boardreadCnt",num);
		return n;
	}
	
	public int updateByNum(SqlSession session,BoardDTO dto) {
		int n=session.update("updateByNum",dto);
		return n;
	}
	
}
