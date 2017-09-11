package com.dao.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.board.CommentDTO;

public class CommentDAO {
	
	public List<CommentDTO> commentList(SqlSession session,HashMap<String, Integer> map){
		List<CommentDTO> list=session.selectList("commentList",map);
		return list;
	}
	
	public int insertComment(SqlSession session,CommentDTO dto) {
		int n=session.insert("insertComment",dto);
		return n;
	}
	
	public int deleteComment(SqlSession session,HashMap<String,String> map) {
		int n=session.delete("deleteComment",map);
		return n;
	}
	
	
}