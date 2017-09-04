package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.CartService;
import com.service.MemberService;

/**
 * Servlet implementation class PaymentViewServlet
 */
@WebServlet("/PaymentViewServlet")
public class PaymentViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num =request.getParameter("num");
		String userid =request.getParameter("userid");
		
		System.out.println("paymentView 29"+ userid);
		CartService service = new CartService();
		MemberService mservice= new MemberService();
		 String target="payment.jsp";
	    try {
			CartDTO cDto=service.orderConfirm(Integer.parseInt(num));
			MemberDTO mDto=mservice.getMemberData(userid);
			
			
			request.setAttribute("cDTO", cDto);
			request.setAttribute("mDTO", mDto);
			System.out.println(mDto.toString());
	//	request.setAttribute("cart", "장바구니에"+gName+" 상품이 잘 담겼습니다.");
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
