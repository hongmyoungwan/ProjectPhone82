package com.service.qna;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.qna.QNADAO;
import com.dto.qna.QNADTO;
import com.dto.qna.QNAPageDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class QNAService {

	public List<QNADTO> qnaList(HashMap<String,String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		QNADAO dao=new QNADAO();
		List<QNADTO> list=null;
		try {
			list=dao.qnaList(session,map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("qnaList 실패"); 
		}finally {
			session.close();
		}
		return list;
	}
	
	public QNAPageDTO qnapage(int curPage, int perPage, HashMap<String, String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		QNADAO dao=new QNADAO();
		QNAPageDTO dto=null;
		try {
			dto=dao.qnapage(session,curPage, perPage, map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("qnapage 실패"); 
		}finally {
			session.close();
		}
		return dto;
	}//page end
	
	public void qnainsert(QNADTO dto) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		QNADAO dao=new QNADAO();
		try {
			int n=dao.qnainsert(session,dto);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("qnainsert 실패"); 
		}finally {
			session.close();
		}
	}
	
	public void qnadelete(HashMap<String,String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		QNADAO dao=new QNADAO();
		try {
			int n=dao.qnadelete(session,map);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("qnadelete 실패"); 
		}finally {
			session.close();
		}
	}
	
	public QNADTO qnaretrieve(int num) throws MyException {
		SqlSession session=MybatisTemplate.openSession();
		QNADAO dao=new QNADAO();
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
			throw new MyException("qnaretrieve예외");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public void qnaupdateByNum(QNADTO dto) throws MyException {
		SqlSession session=MybatisTemplate.openSession();
		QNADAO dao=new QNADAO();
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
}
