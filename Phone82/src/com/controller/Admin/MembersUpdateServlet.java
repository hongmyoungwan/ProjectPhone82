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
		String num =request.getParameter("num");
		String[] nums=num.split("/");
		
		if(num!=null) {
			
			for (String string : nums) {

				System.out.println(string);
			}
				
		}
		
		try {
			List<MemberDTO> list= service.membersDelete(nums);
			
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
