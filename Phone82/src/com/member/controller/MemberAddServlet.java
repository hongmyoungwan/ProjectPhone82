package com.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MemberService;

@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String username = request.getParameter("username");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone1 = request.getParameter("phone1");
		String phone2= request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email = request.getParameter("email");
		
		MemberDTO dto = new MemberDTO(userid, passwd, username, post1, post2, addr1, addr2, phone1, phone2, phone3, email);
		
		MemberService service = new MemberService();
		String target = "home.jsp";
		
		try {
			service.insertMember(dto);
			request.setAttribute("result", "회원가입을 축하합니다.");
		
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target = "error.jsp";
			request.setAttribute("mesg", "옳바른 정보를 입력해주세요");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
