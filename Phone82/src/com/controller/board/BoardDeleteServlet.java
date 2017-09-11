package com.controller.board;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.board.BoardDTO;
import com.dto.member.MemberDTO;
import com.exception.MyException;
import com.service.board.BoardService;

@WebServlet("/BoardDeleteServlet")
public class BoardDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String num=request.getParameter("num");
		MemberDTO mdto=(MemberDTO)session.getAttribute("login");
		String userid=mdto.getUserid();
		BoardService service = new BoardService();
		HashMap<String,String> map=new HashMap<>();
		map.put("num",num);
		map.put("userid", userid);
		String target=null;
		try {
			BoardDTO dto=service.retrieve(Integer.parseInt(num));
			
			System.out.println(userid);
			if(userid.equals(dto.getUserid())) {
				service.deleteBoard(map);
				target="BoardListServlet";
				request.setAttribute("result", "글이 삭제되었습니다");
				
			}
			else {
				request.setAttribute("result", "본인이 작성한 글만 삭제 가능합니다");
				target="BoardListServlet";
			}
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
