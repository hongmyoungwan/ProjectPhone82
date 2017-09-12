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

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * Servlet implementation class MembersDeleteServlet
 */
@WebServlet("/MembersDeleteServlet")
public class MembersDeleteServlet extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	MemberManagementService service =new MemberManagementService();
		
		String target ="admin/membermanagepage.jsp";
		String num =request.getParameter("num");
		
		if(num!=null) {
			
				System.out.println(num.split(""));
				return;
		}
		
		try {
			List<MemberDTO> list= service.membersDelete(Integer.parseInt(num));
			
			request.setAttribute("list", list);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			target="error.jsp";
		}
		
		RequestDispatcher dis =request.getRequestDispatcher(target);
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
