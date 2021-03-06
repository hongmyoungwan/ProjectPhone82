package com.controller.Admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.admin.AdminDTO;
import com.service.admin.AdminService;

/**
 * Servlet implementation class AdminFormMainServlet
 */
@WebServlet("/AdminFormMainServlet")
public class AdminFormMainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String passwd= request.getParameter("passwd");
		
		//testversion admin;
		
		
		String target ="adminForm.jsp";
		HashMap<String,String>map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		AdminService service =new AdminService();
		System.out.println("admin 통과");
		HttpSession session = request.getSession();
		try {
			AdminDTO dto = service.getAdmin(map);
			
			if(dto==null) {
				target="LoginServlet";
				request.setAttribute("admin", false);
			}else
			{
				target="adminForm.jsp";
				session.setAttribute("login", dto);
			
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
