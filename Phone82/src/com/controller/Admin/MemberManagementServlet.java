package com.controller.Admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.admin.AdminDTO;
import com.dto.admin.MemberMngPageDTO;
import com.dto.member.MemberDTO;
import com.service.admin.MemberManagementService;

/**
 * Servlet implementation class MemberManagementServlet
 */
@WebServlet("/MemberManagementServlet")
public class MemberManagementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberManagementService service =new MemberManagementService();
		String curPage= request.getParameter("curPage"); 
	    String curIdx= request.getParameter("curIdx");
		String perPage=request.getParameter("perPage");
	    String target ="membermanagepage.jsp";
	    String searchName=request.getParameter("searchName"); 
	    String searchValue=request.getParameter("searchValue"); 
		if(curPage==null||curPage.equals(""))
		{
			curPage="1";
		}
		if(perPage==null||curPage.equals(""))
		{
			perPage="3";
		}
		if(curIdx==null||curIdx.equals(""))
		{
			curIdx="0";
		}
		HashMap<String,String> map = new HashMap<>();
		map.put("curPage", curPage);
		map.put("perPage", perPage);
		map.put("curIdx", curIdx);
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		try {
			MemberMngPageDTO dto = service.page(map);
		
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
