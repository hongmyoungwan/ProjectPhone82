package com.controller.qna;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.qna.QNAPageDTO;
import com.exception.MyException;
import com.service.qna.QNAService;



@WebServlet("/QNAListServlet")
public class QNAListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String userid="admin";
		HttpSession session=request.getSession();
		session.setAttribute("userid", userid);
		session.setAttribute("username", "관리자");
		
		String searchName=request.getParameter("searchName");
		String searchValue=request.getParameter("searchValue");
		String curPage=request.getParameter("curPage");
		String perPage=request.getParameter("perPage");
		if(curPage==null) {
			curPage="1";
		}
		if(perPage==null) {
			perPage="3";
		}
		QNAService service=new QNAService();
		HashMap<String,String> map=new HashMap<>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		String target="qnaList.jsp";
		try {
			QNAPageDTO dto=service.qnapage(Integer.parseInt(curPage), Integer.parseInt(perPage), map);
			request.setAttribute("page", dto);
			request.setAttribute("perPage", perPage);
		} catch (MyException e) {
			target="error.jsp";
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dis=request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
