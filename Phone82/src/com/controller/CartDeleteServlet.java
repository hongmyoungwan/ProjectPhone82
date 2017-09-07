package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.MyException;
import com.service.CartService;

/**
 * Servlet implementation class CartDeleteServlet
 */
@WebServlet("/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String num= request.getParameter("num");
		CartService service = new CartService();
		
		 String target="CartListView";
	    try {
			service.delItem(Integer.parseInt(num));
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target= "error.jsp";
		}
		
	    RequestDispatcher dis = request.getRequestDispatcher(target);
	    dis.forward(request, response);
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
