package com.service.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.board.BoardDAO;
import com.dto.board.BoardDTO;
import com.dto.board.PageDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class BoardService {

	public List<BoardDTO> boardList(HashMap<String,String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		BoardDAO dao=new BoardDAO();
		List<BoardDTO> list=null;
		try {
			list=dao.boardList(session,map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("boardList 실패"); 
		}finally {
			session.close();
		}
		return list;
	}
	
	public PageDTO page(int curPage, int perPage, HashMap<String, String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		BoardDAO dao=new BoardDAO();
		PageDTO dto=null;
		try {
			dto=dao.page(session,curPage, perPage, map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("page 실패"); 
		}finally {
			session.close();
		}
		return dto;
	}//page end
	
	public void insertBoard(BoardDTO dto) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		BoardDAO dao=new BoardDAO();
		try {
			int n=dao.insertBoard(session,dto);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("insertBoard 실패"); 
		}finally {
			session.close();
		}
	}
	
	public void deleteBoard(HashMap<String,String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		BoardDAO dao=new BoardDAO();
		try {
			int n=dao.deleteBoard(session,map);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("deleteBoard 실패"); 
		}finally {
			session.close();
		}
	}
	
	public BoardDTO retrieve(int num) throws MyException {
		SqlSession session=MybatisTemplate.openSession();
		BoardDAO dao=new BoardDAO();
		BoardDTO dto=null;
		try {
			int n=dao.readCnt(session, num);
			if(n==1) {
				session.commit();	
			}
			dto=dao.selectByNum(session, num);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new MyException("retrieve예외");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public void updateByNum(BoardDTO dto) throws MyException {
		SqlSession session=MybatisTemplate.openSession();
		BoardDAO dao=new BoardDAO();
		try {
			int n=dao.updateByNum(session, dto);
			if(n==1) {
				session.commit();	
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new MyException("update예외");
		}finally {
			session.close();
		}
	}
}
