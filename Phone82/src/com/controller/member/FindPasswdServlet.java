package com.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MemberService;

@WebServlet("/FindPasswdServlet")
public class FindPasswdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("username", username);
		map.put("email", email);
		
		HttpSession session = request.getSession();
		
		MemberService service = new MemberService();
		MemberDTO dto = null;
		String target="findPasswdResult.jsp";
		try {
			dto = service.findPasswd(map);
			if(dto != null) {
				String passwd = dto.getPasswd(); 
				request.setAttribute("mesg", dto.getUsername()+"님의 비밀번호는 "+passwd+"입니다.");
				session.setAttribute("userid", userid);
			} else {
				request.setAttribute("mesg2", "입력하신 정보가 존재하지않습니다.");
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis =  request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
