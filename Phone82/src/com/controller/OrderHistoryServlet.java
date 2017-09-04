package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.OrderDTO;
import com.exception.MyException;
import com.service.OrderService;


@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		String userid = request.getParameter("userid");

		String phone_name = request.getParameter("phone_name");
		String sprice = request.getParameter("sprice");
		String scolor = request.getParameter("scolor");
		String samount = request.getParameter("samount");
		String phone_model_num = request.getParameter("phone_model_num");
		String sImage = request.getParameter("simage");

		String orderName = request.getParameter("orderName");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String payMethod = request.getParameter("payMethod");
		
		OrderDTO dto = new OrderDTO();
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setSamount(Integer.parseInt(samount));
		dto.setPhone_model_num(phone_model_num);
		dto.setScolor(scolor);
		dto.setsImage(sImage);
		dto.setSprice(Integer.parseInt(sprice));
		dto.setPhone_name(phone_name);
		dto.setPhone(phone);
		dto.setUserid(userid);
		dto.setPost1(post1);
		dto.setPost2(post2);
		dto.setPayMethod(payMethod);
		dto.setOrderName(orderName);
		dto.setNum(Integer.parseInt(num));
		
		
		
		
		 OrderService service = new OrderService();
		 
		 String target="orderHistory.jsp";
		 try {
		 service.orderHistory(dto,num);
	
		 request.setAttribute("oDTO", dto);
	
		 // request.setAttribute("cart", "장바구니에"+gName+" 상품이 잘 담겼습니다.");
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
