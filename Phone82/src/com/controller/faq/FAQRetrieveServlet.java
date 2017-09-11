package com.controller.faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.faq.FAQDTO;
import com.exception.MyException;
import com.service.faq.FAQService;

@WebServlet("/FAQRetrieveServlet")
public class FAQRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num=request.getParameter("num");
		String target="faqRetrieve.jsp";
		
		if(num.equals(""))
		{
			System.err.println("num is null FAQRetrieveServlet 26 line");
			return;
		}
		FAQService service=new FAQService();
		try {
			FAQDTO dto=service.faqretrieve(Integer.parseInt(num));
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
	doGet(request, response);
	}

}