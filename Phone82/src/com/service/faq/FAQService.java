package com.service.faq;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.faq.FAQDAO;
import com.dao.qna.QNADAO;
import com.dto.faq.FAQDTO;
import com.dto.faq.FAQPageDTO;
import com.dto.qna.QNADTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class FAQService {

	public List<FAQDTO> faqList(HashMap<String,String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		FAQDAO dao=new FAQDAO();
		List<FAQDTO> list=null;
		try {
			list=dao.faqList(session,map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("faqList 실패"); 
		}finally {
			session.close();
		}
		return list;
	}
	
	public FAQPageDTO faqpage(int curPage, int perPage, HashMap<String,String> map) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		FAQDAO dao=new FAQDAO();
		FAQPageDTO dto=null;
		try {
			dto=dao.faqpage(session,curPage, perPage, map);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("faqpage 실패"); 
		}finally {
			session.close();
		}
		return dto;
	}//page end
	
	public void faqinsert(FAQDTO dto) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		FAQDAO dao=new FAQDAO();
		try {
			int n=dao.faqinsert(session,dto);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("faqinsert 실패"); 
		}finally {
			session.close();
		}
	}
	
	public void faqdelete(String searchValue) throws MyException{
		SqlSession session=MybatisTemplate.openSession();
		FAQDAO dao=new FAQDAO();
		try {
			int n=dao.faqdelete(session,searchValue);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("faqdelete 실패"); 
		}finally {
			session.close();
		}
	}
	
	public FAQDTO faqretrieve(int num) throws MyException {
		SqlSession session=MybatisTemplate.openSession();
		FAQDAO dao=new FAQDAO();
		FAQDTO dto=null;
		try {
			dto=dao.selectByNum(session, num);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new MyException("faqretrieve예외");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public void faqupdateByNum(FAQDTO dto) throws MyException {
		SqlSession session=MybatisTemplate.openSession();
		FAQDAO dao=new FAQDAO();
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