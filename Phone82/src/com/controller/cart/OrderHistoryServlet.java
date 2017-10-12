package com.controller.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.cart.OrderDTO;
import com.exception.MyException;
import com.service.cart.OrderService;


@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		String userid = request.getParameter("userid");
		
		String phone_name = request.getParameter("phone_name");
		String phone_price = request.getParameter("phone_price");
		String phone_amount = request.getParameter("phone_amount");
		String phone_model_num = request.getParameter("phone_model_num");
		String phone_image = request.getParameter("phone_image");

		String orderName = request.getParameter("orderName");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String payMethod = request.getParameter("payMethod");
		String telecom_num = request.getParameter("telecom_num");
		OrderDTO dto = new OrderDTO();
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setPhone_amount(Integer.parseInt(phone_amount));
		dto.setPhone_model_num(phone_model_num);
		dto.setPhone_image(phone_image);
		dto.setPhone_price(Integer.parseInt(phone_price));
		dto.setPhone_name(phone_name);
		dto.setPhone(phone);
		dto.setUserid(userid);
		dto.setPost1(post1);
		dto.setPost2(post2);
		dto.setPayMethod(payMethod);
		dto.setOrderName(orderName);
		dto.setNum(Integer.parseInt(num));
		System.out.println("telecom_num"+telecom_num );
		dto.setTelecom_num(telecom_num);
		
		
		
		
		 OrderService service = new OrderService();
		 
		 String target="orderHistory.jsp";
		 try {
		 service.orderHistory(dto,num);
	
		 request.setAttribute("oDTO", dto);
	
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
