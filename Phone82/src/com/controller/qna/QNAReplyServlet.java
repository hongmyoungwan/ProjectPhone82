package com.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.qna.QNADTO;
import com.exception.MyException;
import com.service.qna.QNAService;


@WebServlet("/QNAReplyServlet")
public class QNAReplyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num=request.getParameter("num");
		
		String target="qnaData.jsp";
		QNAService service=new QNAService();
		QNADTO dto=null;
		try {
			dto = service.qnaretrieve(Integer.parseInt(num));
			request.setAttribute("retrieve", dto);
		} catch (MyException e) {
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
