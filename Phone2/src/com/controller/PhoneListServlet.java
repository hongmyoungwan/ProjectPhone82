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


@WebServlet("/PhoneListServlet")
public class PhoneListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PhoneListBiz biz = new PhoneListBiz();
		String target = "phoneList.jsp";
		try {
			List<PhoneDTO> list = biz.PhoneList();
			System.out.println(list);
			request.setAttribute("list", list);
		} catch (MyException e) {
			e.getMessage();
		}
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
