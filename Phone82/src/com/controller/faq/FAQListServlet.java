package com.controller.faq;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.faq.FAQPageDTO;
import com.exception.MyException;
import com.service.faq.FAQService;


@WebServlet("/FAQListServlet")
public class FAQListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String searchValue=request.getParameter("searchValue");
		String curPage=request.getParameter("curPage");
		String perPage=request.getParameter("perPage");
		if(curPage==null) {
			curPage="1";
		}
		if(perPage==null) {
			perPage="10";
		}
		FAQService service=new FAQService();
		if(searchValue==null) {
			searchValue="";
		}
		HashMap<String,String> map=new HashMap<>();
		map.put("searchValue", searchValue);
		String target="faqList.jsp";
		try {
			System.out.println(">>"+searchValue);
			FAQPageDTO dto=service.faqpage(Integer.parseInt(curPage), Integer.parseInt(perPage), map);
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