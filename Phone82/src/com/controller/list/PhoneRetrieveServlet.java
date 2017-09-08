package com.controller.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.list.PhoneListBiz;
import com.dto.list.PhoneDTO;
import com.exception.list.MyException;


@WebServlet("/PhoneRetrieveServlet")
public class PhoneRetrieveServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String telecom_num = request.getParameter("telecom_num");
		
		PhoneListBiz biz = new PhoneListBiz();
		String target = "phoneRetrieve.jsp";
		try {
			PhoneDTO dto = biz.phoneRetrieve(telecom_num);
			request.setAttribute("dto", dto);
		} catch (MyException e) {
			e.getMessage();
		}
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
