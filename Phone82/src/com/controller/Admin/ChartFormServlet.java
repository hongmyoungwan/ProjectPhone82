package com.controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.SalesDTO;
import com.exception.MyException;
import com.service.AdminService;

/**
 * Servlet implementation class ChartFormServlet
 */
@WebServlet("/ChartFormServlet")
public class ChartFormServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		AdminService service = new AdminService();
		List<SalesDTO> list = null;
		String target= "chart.jsp";
		try {
			list=service.getSalesChartDatas();
			for (SalesDTO salesDTO : list) {
				System.out.println(salesDTO.toString());
			}
			request.setAttribute("charttable", list);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dis= request.getRequestDispatcher(target);
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
