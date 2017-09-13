package com.controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.faq.FAQDTO;
import com.dto.qna.QNADTO;
import com.exception.MyException;
import com.service.admin.QNAResponseService;
import com.service.faq.FAQService;
import com.service.qna.QNAService;

/**
 * Servlet implementation class QNAReqeustServlet
 */
@WebServlet("/QNAReqeustServlet")
public class QNAReqeustServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String num=request.getParameter("num");
		String target="admin/qnaRetrieve.jsp";
		
		if(num.equals(""))
		{
			System.err.println("num is null FAQRetrieveServlet 26 line");
			return;
		}
		QNAResponseService service=new QNAResponseService();
		try {
			QNADTO dto=service.qnaretrieve(Integer.parseInt(num));
			request.setAttribute("retrieve", dto);
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target="error.jsp";
		}
		RequestDispatcher dis=request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
