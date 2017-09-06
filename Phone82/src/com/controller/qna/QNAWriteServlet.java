package com.controller.qna;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/QNAWriteServlet")
public class QNAWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		
		QNADTO dto=new QNADTO();
		dto.setAuthor(author);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setUserid(userid);
		QNAService service=new QNAService();
		String target="QNAListServlet";
		
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("바보");
		list.add("멍청이");

		try {
			
			for(String k: list) {
				if (content.indexOf(k)>-1) {
					request.setAttribute("key", k+"를(을) 포함하고있어요");
					target="qnaWriteForm.jsp";
					request.setAttribute("dto", dto);
				}
				else{
					service.qnainsert(dto);
					break;
				}
			}
			
		}catch(MyException e) {
			target="error.jsp";
			e.printStackTrace();
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
