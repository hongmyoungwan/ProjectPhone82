package com.controller.cart;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.MyException;
import com.service.cart.CartService;

/**
 * Servlet implementation class CartAmountUpdateServlet
 */
@WebServlet("/CartAmountUpdateServlet")
public class CartAmountUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num= request.getParameter("num");
		String amount= request.getParameter("amount");

	    HashMap<String, Integer> map = new HashMap<>();
	    map.put("phone_amount", Integer.parseInt(amount));
	    map.put("num", Integer.parseInt(num));
		
		CartService service = new CartService();
		
		 String target="CartListView";
	    try {
			service.amountUpdate(map);
			request.setAttribute("amountUpdate", "수량수정이 성공하였습니다.");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target= "error.jsp";
		}
		
	    RequestDispatcher dis = request.getRequestDispatcher(target);
	    dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
