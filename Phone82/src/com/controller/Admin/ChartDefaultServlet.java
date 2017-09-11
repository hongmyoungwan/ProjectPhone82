package com.controller.Admin;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.dto.cart.SalesDTO;
import com.exception.MyException;
import com.service.admin.AdminService;

/**
 * Servlet implementation class ChartFormServlet
 */
@WebServlet("/ChartDefaultServlet")
public class ChartDefaultServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		AdminService service = new AdminService();
		List<SalesDTO> list = null;
		String start= request.getParameter("start");
		String finish=request.getParameter("finish");
		System.out.println("start&&&&&&&&&& :"+ start +"finish"+ finish);
		if(start==null)
			start="2017/01/01";
		if(finish==null)
			finish="2017/12/31";
		HashMap<String,String>map = new HashMap<>();
		System.out.println("start :"+ start +"finish"+ finish);
		map.put("start", start);
		map.put("finish", finish);
		String target= "chart/chart.jsp";
		
		try {
			list=service.getSalesChartDatas(map);
		//	request.setAttribute("list", list);
			
			request.setAttribute("list", list);
			
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
