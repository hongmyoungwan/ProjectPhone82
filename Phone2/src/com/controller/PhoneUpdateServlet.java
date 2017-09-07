package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.PhoneListBiz;
import com.exception.MyException;


@WebServlet("/PhoneUpdateServlet")
public class PhoneUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String telecom_num = request.getParameter("telecom_num");
		String phone_content = request.getParameter("phone_content");
		String phone_price = request.getParameter("phone_price");
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("telecom_num", telecom_num);
		map.put("phone_content", phone_content);
		map.put("phone_price", phone_price);
		
		PhoneListBiz biz = new PhoneListBiz();
		
		try {
			biz.phoneUpdate(map);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("PhoneListServlet");
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
