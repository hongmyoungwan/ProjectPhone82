package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.member.MemberDTO;
import com.exception.MyException;
import com.service.member.MemberService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		if(request.getAttribute("admin")==null) {
			
			RequestDispatcher dis = request.getRequestDispatcher("AdminFormMainServlet");
			dis.forward(request, response);
			return;
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		
		MemberService service = new MemberService();
		
		String target = "home.jsp";
		try {
			MemberDTO dto = service.login(map);
			if(dto==null) {
				target="LoginFormServlet";
				request.setAttribute("mesg", "아이디와 비밀번호가 일치하지 않습니다.");
			} else {
				target="home.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("login", dto);
				//request.setAttribute("result", "로그인 성공");
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("mesg", e.getMessage());
			target="LoginFormServlet";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
