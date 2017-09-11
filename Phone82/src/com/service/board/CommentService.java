package com.service.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.board.CommentDAO;
import com.dto.board.CommentDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class CommentService {

	public List<CommentDTO> commentList(HashMap<String,Integer> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		CommentDAO dao=new CommentDAO();
		List<CommentDTO> list=null;
		try {
			list=dao.commentList(session,map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("commentList 실패"); 
		}finally {
			session.close();
		}
		return list;
	}
	
	
	
	public void insertComment(CommentDTO dto) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		CommentDAO dao=new CommentDAO();
		try {
			int n=dao.insertComment(session,dto);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("insertComment 실패"); 
		}finally {
			session.close();
		}
	}
	
	public void deleteComment(HashMap<String,String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		CommentDAO dao=new CommentDAO();
		try {
			int n=dao.deleteComment(session,map);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("deleteComment 실패"); 
		}finally {
			session.close();
		}
	}
	
	
	
}