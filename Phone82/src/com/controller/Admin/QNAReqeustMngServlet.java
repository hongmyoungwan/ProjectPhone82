package com.controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.admin.AdminDTO;
import com.dto.faq.FAQDTO;
import com.dto.qna.QNADTO;
import com.exception.MyException;
import com.service.admin.QNAResponseService;
import com.service.faq.FAQService;
import com.service.qna.QNAService;

/**
 * Servlet implementation class QNAReqeustServlet
 */
@WebServlet("/QNAReqeustMngServlet")
public class QNAReqeustMngServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String num=request.getParameter("num");
		String textValue= request.getParameter("textValue");
		String target="admin/qnaRetrieve.jsp";
		System.out.println("textValue \t"+textValue);
		if(num.equals(""))
		{
			System.err.println("num is null FAQRetrieveServlet 26 line");
			
		}
		QNAResponseService service=new QNAResponseService();
		QNADTO dto= new QNADTO();
		HttpSession session =request.getSession();
		if(session.getAttribute("login")==null)
		{
			request.setAttribute("mesg","로그인이 필요한 작업입니다.");
			RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
			dis.forward(request,response);
			return;
		}
		dto.setContent(textValue);
		dto.setNum(Integer.parseInt(num));
		dto.setUserid(((AdminDTO)session.getAttribute("login")).getAdminid());
		try {
			QNADTO _dto=service.qnaMngretrieve(dto);
			
			System.out.println(_dto);
			request.setAttribute("retrieve", _dto);
			
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
