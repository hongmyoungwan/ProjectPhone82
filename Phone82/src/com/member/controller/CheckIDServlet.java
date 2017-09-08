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

@WebServlet("/CheckIDServlet")
public class CheckIDServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		
		MemberService service = new MemberService();
		String target="checkID.jsp";
		try {
			String str = service.checkID(userid);
			if(userid.equals(str)) {
				request.setAttribute("mesg", "이미 사용중인 아이디입니다.");
			} else if(userid != " " || userid.length() != 0 ) {
				request.setAttribute("mesg", userid +"는 사용 가능한 아이디입니다.");
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
