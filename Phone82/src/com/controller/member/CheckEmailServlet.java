package com.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.MyException;
import com.service.MemberService;

@WebServlet("/CheckEmailServlet")
public class CheckEmailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		MemberService service = new MemberService();
		String target="checkEmail.jsp";
		try {
			String str = service.checkEmail(email);
			if(email.equals(str)) {
				request.setAttribute("mesg", "등록된 이메일입니다.");
			} else if(email != " " || email.length() != 0 ) {
				request.setAttribute("mesg", email+"는 사용 가능한 이메일입니다.");
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("mesg", "오류");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
