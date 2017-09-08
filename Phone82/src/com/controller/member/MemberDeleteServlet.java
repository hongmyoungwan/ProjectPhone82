package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exception.MyException;
import com.service.member.MemberService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		MemberService service = new MemberService();
		String target = "home.jsp";
		
		try {
			service.deleteMember(userid);
			request.setAttribute("result", "회원탈퇴 성공");
			HttpSession session = request.getSession();
			session.invalidate();
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target="MyPageServlet";
			request.setAttribute("mesg", "옳바른 정보를 입력해주세요.");
		}

	
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
