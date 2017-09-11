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

import com.dto.board.BoardDTO;
import com.dto.board.CommentDTO;
import com.exception.MyException;
import com.service.board.BoardService;
import com.service.board.CommentService;

@WebServlet("/BoardRetrieveServlet")
public class BoardRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num=request.getParameter("num");
		String target="boardRetrieve.jsp";
		
		System.out.println(">"+num);
		BoardService service=new BoardService();
		CommentService cservice=new CommentService();
		HashMap<String,Integer> map=new HashMap<>();
		map.put("boardnum", Integer.parseInt(num));
		List<CommentDTO> list=null;
		try {
			list=cservice.commentList(map);
			BoardDTO dto=service.retrieve(Integer.parseInt(num));
			request.setAttribute("retrieve", dto);
			request.setAttribute("comment",list);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target="error.jsp";
		}
		RequestDispatcher dis=request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}