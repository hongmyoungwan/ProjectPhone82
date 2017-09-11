package com.controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.board.PageDTO;
import com.exception.MyException;
import com.service.board.BoardService;


@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String searchName=request.getParameter("searchName");
		String searchValue=request.getParameter("searchValue");
		String curPage=request.getParameter("curPage");
		String perPage=request.getParameter("perPage");
		if(curPage==null) {
			curPage="1";
		}
		
		if(perPage==null) {
			perPage="10";
		}
		BoardService service=new BoardService();
		HashMap<String,String> map=new HashMap<>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		String target="boardList.jsp";
		try {
			PageDTO dto=service.page(Integer.parseInt(curPage), Integer.parseInt(perPage), map);
			
			request.setAttribute("page", dto);
			request.setAttribute("perPage", perPage);
			
		} catch (MyException e) {
			target="error.jsp";
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dis=request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
