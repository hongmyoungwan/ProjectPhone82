package com.controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.admin.AdminDTO;
import com.dto.member.MemberDTO;
import com.service.admin.MemberManagementService;

/**
 * Servlet implementation class MemberManagementServlet
 */
@WebServlet("/MemberManagementServlet")
public class MemberManagementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberManagementService service =new MemberManagementService();
		
		String target ="membermanagepage.jsp";
		try {
			List<MemberDTO> dto = service.getAllMemberData();
			for (MemberDTO memberDTO : dto) {
				System.out.println(dto.toString());
			}
			request.setAttribute("membermanagepage", dto);
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
