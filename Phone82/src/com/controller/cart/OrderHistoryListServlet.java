package com.controller.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.cart.OrderDTO;
import com.dto.member.MemberDTO;
import com.exception.MyException;
import com.service.cart.OrderService;


@WebServlet("/OrderHistoryListServlet")
public class OrderHistoryListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String userid = request.getParameter("userid");
		
		
		
		 OrderService service = new OrderService();
		 if(userid==null || userid.equals("")) {
			 HttpSession session = request.getSession();
			 userid=((MemberDTO)(session.getAttribute("login"))).getUserid();
		 }
		 String target="orderHistoryList.jsp";
		 try {
		 List<OrderDTO> list= service.orderList(userid);
	
		 request.setAttribute("list",list);
	
		 // request.setAttribute("cart", "��ٱ��Ͽ�"+gName+" ��ǰ�� �� �����ϴ�.");
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
