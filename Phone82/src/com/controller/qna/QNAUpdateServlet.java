package com.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.qna.QNADTO;
import com.exception.MyException;
import com.service.qna.QNAService;

@WebServlet("/QNAUpdateServlet")
public class QNAUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		
		String num=request.getParameter("num");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		
		QNADTO dto=new QNADTO();
		dto.setNum(Integer.parseInt(num));
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setContent(content);
		
		QNAService service = new QNAService();
		String target="QNAListServlet";
		try {
			service.qnaupdateByNum(dto);
		} catch (MyException e) {
			e.printStackTrace();
			target="error.jsp";
		}
		
		
		RequestDispatcher dis=request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
