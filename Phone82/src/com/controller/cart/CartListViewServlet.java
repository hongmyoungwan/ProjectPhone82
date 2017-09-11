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

import com.dto.cart.CartDTO;
import com.dto.member.MemberDTO;
import com.exception.MyException;
import com.service.cart.CartService;

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/CartListView")
public class CartListViewServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
//		MemberDTO mem = (MemberDTO)session.getAttribute("login"); 
//		if(mem==null) {
//			
//		}
		MemberDTO mem = new MemberDTO("test","1","tester","444","555","요기","죠기","010","1111","2222","dfsfs");
		CartService service = new CartService();
		String target ="cartList.jsp";
		try {
			System.out.println("cartlistvier 36 :"+mem.getUserid());
			List<CartDTO> list = service.cartAllList(mem.getUserid());
			request.setAttribute("cartList", list);
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target ="error.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
