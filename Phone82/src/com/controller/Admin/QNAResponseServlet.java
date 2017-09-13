package com.controller.Admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.board.PageDTO;
import com.dto.qna.QNAPageDTO;
import com.exception.MyException;
import com.service.admin.QNAResponseService;
import com.service.board.BoardService;

/**
 * Servlet implementation class QNAResponseServlet
 */
@WebServlet("/QNAResponseServlet")
public class QNAResponseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		
		
		String searchName=request.getParameter("searchName");
		String searchValue=request.getParameter("searchValue");
		String curPage=request.getParameter("curPage");
		String perPage=request.getParameter("perPage");
		if(curPage==null) {
			curPage="1";
		}
		
		if(perPage==null) {
			perPage="10";
		}
		QNAResponseService service=new QNAResponseService();
		HashMap<String,String> map=new HashMap<>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		String target="qnaResponse.jsp";
		try {
			QNAPageDTO dto=service.page(Integer.parseInt(curPage), Integer.parseInt(perPage), map);
			System.out.println(dto);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
