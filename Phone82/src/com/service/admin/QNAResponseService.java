package com.service.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.admin.QNAResponseDAO;
import com.dao.board.BoardDAO;
import com.dto.qna.QNADTO;
import com.dto.board.BoardDTO;
import com.dto.board.PageDTO;
import com.dto.qna.QNAPageDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class QNAResponseService {
	public List<QNADTO> boardList(HashMap<String,String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		QNAResponseDAO dao=new QNAResponseDAO();
		List<QNADTO> list=null;
		try {
			list=dao.qnaList(session,map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("boardList 실패"); 
		}finally {
			session.close();
		}
		return list;
	}
	
	public QNAPageDTO page(int curPage, int perPage, HashMap<String, String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		QNAResponseDAO dao=new QNAResponseDAO();
		QNAPageDTO dto=null;
		try {
			dto=dao.qnapage(session,curPage, perPage, map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("page 실패"); 
		}finally {
			session.close();
		}
		return dto;
	}//page end
	
	public void insertBoard(QNADTO dto) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		QNAResponseDAO dao=new QNAResponseDAO();
		try {
			int n=dao.qnainsert(session,dto);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("insertBoard 실패"); 
		}finally {
			session.close();
		}
	}
	public void insertBoard2(QNADTO dto) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		QNAResponseDAO dao=new QNAResponseDAO();
		try {
			int n=dao.qnainsert(session,dto);
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
		QNAResponseDAO dao=new QNAResponseDAO();
		try {
			int n=dao.qnadelete(session,map);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("deleteBoard 실패"); 
		}finally {
			session.close();
		}
	}
	
	public QNADTO retrieve(int num) throws MyException {
		SqlSession session=MybatisTemplate.openSession();
		QNAResponseDAO dao=new QNAResponseDAO();
		QNADTO dto=null;
		try {
			int n=dao.qnareadCnt(session, num);
			if(n==1) {
				session.commit();	
			}
			dto=dao.qnaselectByNum(session, num);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new MyException("retrieve예외");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public void updateByNum(QNADTO dto) throws MyException {
		SqlSession session=MybatisTemplate.openSession();
		QNAResponseDAO dao=new QNAResponseDAO();
		try {
			int n=dao.qnaupdateByNum(session, dto);
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

	public QNADTO qnaretrieve(int num) throws MyException {
		SqlSession session=MybatisTemplate.openSession();
		QNAResponseDAO dao=new QNAResponseDAO();
		QNADTO dto=null;
		try {
			int n=dao.qnareadCnt(session, num);
			if(n==1) {
				session.commit();	
			}
			dto=dao.qnaselectByNum(session, num);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new MyException("retrieve예외");
		}finally {
			session.close();
		}
		return dto;
	}
}