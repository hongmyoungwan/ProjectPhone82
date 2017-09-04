package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.AdminDTO;
import com.service.AdminService;

/**
 * Servlet implementation class AdminFormMainServlet
 */
@WebServlet("/AdminFormMainServlet")
public class AdminFormMainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminid = request.getParameter("userid");
		String adminpw= request.getParameter("passwd");

		String target ="adminform.jsp";
		HashMap<String,String>map = new HashMap<>();
		map.put("adminid", adminid);
		map.put("adminpw", adminpw);
		AdminService service =new AdminService();
		try {
			AdminDTO dto = service.getAdmin(map);
		}catch (Exception e) {
			// TODO: handle exception
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
