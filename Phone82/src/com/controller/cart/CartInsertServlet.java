package com.controller.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.cart.CartDTO;
import com.dto.member.MemberDTO;
import com.service.cart.CartService;

/**
 * Servlet implementation class CartInsertServlet
 */
@WebServlet("/CartInsertServlet")
public class CartInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userid = request.getParameter("userid");
		String phone_model_num=request.getParameter("phone_model_num");
		String phone_name=request.getParameter("phone_name");
		String phone_price=request.getParameter("phone_price");
		String phone_image=request.getParameter("phone_image");
		String telecom_num=request.getParameter("telecom_num");
		int phone_amount=1;
		String target="CartListView";
		CartService service = new CartService();
		CartDTO dto = new CartDTO();
		MemberDTO mem = new MemberDTO();
		HttpSession session = request.getSession();
		if(userid==null) {
			mem= (MemberDTO)session.getAttribute("login");
			System.out.println(mem);
			userid =mem.getUserid();
		}
		dto.setPhone_amount(phone_amount);
		dto.setPhone_image(phone_image);
		dto.setPhone_model_num(phone_model_num);
		dto.setPhone_name(phone_name);
		dto.setPhone_price(Integer.parseInt(phone_price));
		dto.setUserid(userid);
		dto.setTelecom_num(telecom_num);
		try {
			service.insertItem(dto);
			request.setAttribute("dto", dto);
		}catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
