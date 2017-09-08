package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.member.MemberDTO;
import com.exception.MyException;
import com.service.member.MemberService;

@WebServlet("/FindIDServlet")
public class FindIDServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("email", email);
		
		MemberService service = new MemberService();
		MemberDTO dto = null;
		String target="findIDResult.jsp";
		try {
			dto = service.findID(map);
			if(dto !=null) {
				request.setAttribute("mesg", "귀하의 아이디는 "+dto.getUserid()+"입니다.");
			} else {
				request.setAttribute("mesg2", "입력하신 정보가 존재하지않습니다.");
				
			}
			//request.setAttribute("mesg", "아이디 찾기");
		} catch (MyException e) {
			e.printStackTrace();
			target="error.jsp";
		}
		
		RequestDispatcher dis =  request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
