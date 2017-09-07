package com.controller.qna;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.qna.QNADTO;
import com.exception.MyException;
import com.service.qna.QNAService;

@WebServlet("/QNADeleteServlet")
public class QNADeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String num=request.getParameter("num");
		String userid=(String)session.getAttribute("userid");
		QNAService service = new QNAService();
		HashMap<String,String> map=new HashMap<>();
		map.put("num",num);
		map.put("userid", userid);
		String target=null;
		try {
			QNADTO dto=service.qnaretrieve(Integer.parseInt(num));
			
			System.out.println(">>>"+dto.getUserid());
			System.out.println(userid);
			if(userid.equals(dto.getUserid())) {
				service.qnadelete(map);
				target="QNAListServlet";
				request.setAttribute("result", "글이 삭제되었습니다");
			}
			else {
				request.setAttribute("result", "본인이 작성한 글만 삭제 가능합니다");
				target="QNAListServlet";
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
