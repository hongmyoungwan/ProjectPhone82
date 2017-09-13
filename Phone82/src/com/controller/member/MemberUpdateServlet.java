package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.member.MemberDTO;
import com.exception.MyException;
import com.service.member.MemberService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		MemberDTO dto = new MemberDTO();
		dto.setUserid(userid);
		dto.setPasswd(passwd);
		dto.setUsername(username);
		dto.setPost1(post1);
		dto.setPost2(post2);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setEmail(email);
		
		MemberService service = new MemberService();
		String target = "home.jsp";
		try {
			service.updateMember(dto);
			request.setAttribute("result", "회원 수정 성공"); 
		} catch(MyException e) {
			e.printStackTrace();
			target="error.jsp";
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
