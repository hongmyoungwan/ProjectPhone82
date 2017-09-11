package com.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.member.MemberDTO;
import com.dto.qna.QNADTO;
import com.exception.MyException;
import com.service.qna.QNAService;

@WebServlet("/QNAWriteServlet")
public class QNAWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
		MemberDTO mdto=(MemberDTO)session.getAttribute("login");
		String userid=mdto.getUserid();
		
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		
		QNADTO dto=new QNADTO();
		dto.setAuthor(author);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setUserid(userid);
		QNAService service=new QNAService();
		String target="QNAListServlet";
		
		try {
			if(title!="" && content!="") {
				service.qnainsert(dto);
			}
			else {
				request.setAttribute("writeNull", "제목과 내용에 빈칸이 있는지 확인해주세요");
				request.setAttribute("dto", dto);
				target="qnaWriteForm.jsp";
			}
			
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
