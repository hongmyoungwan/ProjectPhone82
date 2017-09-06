package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.PhoneListBiz;
import com.dto.PhoneDTO;
import com.exception.MyException;
import com.oracle.jrockit.jfr.RequestDelegate;


@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone_model_num = request.getParameter("phone_model_num");
		PhoneListBiz biz = new PhoneListBiz();
		String target="phoneList.jsp";
		try {
			List<PhoneDTO> dto = biz.phoneModelList(phone_model_num);
			request.setAttribute("list", dto);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target="error.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
