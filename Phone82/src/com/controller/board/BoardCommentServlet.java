package com.controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.board.CommentDTO;
import com.exception.MyException;
import com.service.board.CommentService;

@WebServlet("/BoardCommentServlet")
public class BoardCommentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		String username=(String)session.getAttribute("username");
		
		String boardnum=request.getParameter("boardnum");
		String content=request.getParameter("content");
			
		CommentDTO dto=new CommentDTO();
		dto.setContent(content);
		dto.setBoardnum(Integer.parseInt(boardnum));
		dto.setUsername(username);
		
		HashMap<String, Integer> map=new HashMap<>();
		map.put("boardnum", Integer.parseInt(boardnum));
		CommentService service=new CommentService();
		String target="BoardRetrieveServlet?num="+boardnum;
		List<CommentDTO> list=null;
		try {
			service.insertComment(dto);
			list=service.commentList(map);
			request.setAttribute("comment", list);
		}catch(MyException e) {
			target="error.jsp";
			e.printStackTrace();
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}