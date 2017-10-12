package com.controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.member.MemberDTO;
import com.service.admin.MemberManagementService;

/**
 * Servlet implementation class MembersUpdateServlet
 */
@WebServlet("/MembersUpdateServlet")
public class MembersUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	MemberManagementService service =new MemberManagementService();
		
		String target ="admin/membermanagepage.jsp";
		String userid =request.getParameter("userid");
		String member_num =request.getParameter("member_num");
		String username =request.getParameter("username");
		String email =request.getParameter("email");
		String phone1 =request.getParameter("phone1");
		String phone2 =request.getParameter("phone2");
		String phone3 =request.getParameter("phone3");
		String post1 =request.getParameter("post1");
		String post2 =request.getParameter("post2");
		String addr1 =request.getParameter("addr1");
		String addr2 =request.getParameter("addr2");
		
		MemberDTO dto = new MemberDTO();
		dto.setUserid(userid);
		dto.setUsername(username);
		dto.setEmail(email);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setPost1(post1);
		dto.setPost2(post2);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setMember_Num(member_num);
		try {
			List<MemberDTO> list= service.memberUpdate(dto);
			
			for (MemberDTO memberDTO : list) {
				System.out.println(memberDTO.toString());
			}
			request.setAttribute("membermanagepage", list);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			target="error.jsp";
		}
		
		RequestDispatcher dis =request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
