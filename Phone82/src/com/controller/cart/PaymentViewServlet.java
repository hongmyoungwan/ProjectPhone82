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
import com.exception.MyException;
import com.service.cart.CartService;
import com.service.member.MemberService;

/**
 * Servlet implementation class PaymentViewServlet
 */
@WebServlet("/PaymentViewServlet")
public class PaymentViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String num =request.getParameter("num");
		String userid = request.getParameter("userid");
		String phone_model_num=request.getParameter("phone_model_num");
		String phone_name=request.getParameter("phone_name");
		String phone_price=request.getParameter("phone_price");
		String phone_image=request.getParameter("phone_image");
		String telecom_num=request.getParameter("telecom_num");
		String phone_amount=request.getParameter("phone_amount");
	
		CartService service = new CartService();
		CartDTO dto = new CartDTO();
		MemberDTO mem = new MemberDTO();
		HttpSession session = request.getSession();
		if(num==null) {
			try {
				num = service.createOrderNum();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(userid==null) {
			mem= (MemberDTO)session.getAttribute("login");
			System.out.println(mem);
			userid =mem.getUserid();
		}
		if(phone_amount==null || phone_amount.equals("")) {
			phone_amount="1";
		}
		dto.setPhone_amount(Integer.parseInt(phone_amount));
		dto.setPhone_image(phone_image);
		dto.setPhone_model_num(phone_model_num);
		dto.setPhone_name(phone_name);
		dto.setPhone_price(Integer.parseInt(phone_price));
		dto.setUserid(userid);
		dto.setTelecom_num(telecom_num);
		dto.setNum(Integer.parseInt(num));
		MemberService mservice= new MemberService();
			
		 String target="payment.jsp";
	    try {
			//CartDTO cDto=service.orderConfirm(dto);
			MemberDTO mDto=mservice.mypage(userid);
			
			//System.out.println(cDto.toString());
			request.setAttribute("cDTO", dto);
			request.setAttribute("mDTO", mDto);
			System.out.println(mDto.toString());
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
