package com.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dto.board.BoardDTO;
import com.exception.MyException;
import com.service.board.BoardService;

@WebServlet("/BoardUpdateServlet2")
public class BoardUpdateServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
HashMap<String, String> map = new HashMap<>();
		
		// Create a factory for disk-based file items
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// Configure a repository (to ensure a secure temp location is used)
				ServletContext servletContext = this.getServletConfig().getServletContext();
				File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
				factory.setRepository(repository);

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				// 파일크기
				upload.setFileSizeMax(1024*1024*2);		// 개별적인 파일 크기
				upload.setSizeMax(1024*1024*5);				// 전체 크기
				String fileName = null;
				 long sizeInBytes = 0;
				 String contentType = null;
				// Parse the request
				try {
					List<FileItem> items = upload.parseRequest(request);
					Iterator<FileItem> iter = items.iterator();
					
					while (iter.hasNext()) {
					    FileItem item = iter.next();

					    if (item.isFormField()) {
					        // type="text"
					    	
					    	String name = item.getFieldName();
					        String value = item.getString("UTF-8");
					        map.put(name, value);
					        boolean isInMemory = item.isInMemory();
					        
					    	System.out.println(name+"\t"+value);
					    	System.out.println(contentType+"\t"+isInMemory+"\t"+sizeInBytes);
					    } else {
					    	// type="file"
					    	if(item!=null) {
					    	fileName = item.getName();
					    	map.put("board_image", fileName);
					    	contentType = item.getContentType();
					    	sizeInBytes = item.getSize();
					    	 File uploadedFile = new File("C:\\upload",fileName);
					    	 item.write(uploadedFile);
					    	}
					    	
					    }
					}//
					
					request.setCharacterEncoding("UTF-8");
					
					String num=map.get("num");
					
					String title=map.get("title");
					String author=map.get("author");
					String content=map.get("content");
					content = content.replace("\r\n","<br>");
					String board_image = map.get("board_image");
					/*if(board_image==null) {
						board_image=null;
					}*/
					
					BoardDTO dto=new BoardDTO();
					dto.setAuthor(author);
					dto.setTitle(title);
					dto.setContent(content);
					dto.setNum(Integer.parseInt(num));
					dto.setBoard_image(board_image);
					BoardService service=new BoardService();
					String target="BoardListServlet";
					
					ArrayList<String> list=new ArrayList<String>();
					list.add("바보");
					list.add("멍청이");

					try {
						if(title!="" && content!="") {
							for(String k: list) {
								if (content.indexOf(k)>-1) {
									request.setAttribute("key", k+"를(을) 포함하고있어요");
									request.setAttribute("dto", dto);
									target="boardWriteForm.jsp";
								}else {
									service.updateByNum2(dto);
									break;
								}
							}
						}
						else {
							request.setAttribute("writenull", "제목과 내용에 빈칸이 있는지 확인해주세요");
							request.setAttribute("dto", dto);
							target="boardWriteForm.jsp";
						}
						
					}catch(MyException e) {
						target="error.jsp";
						e.printStackTrace();
					}
					
					RequestDispatcher dis=request.getRequestDispatcher(target);
					dis.forward(request, response);
					
					
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					request.setCharacterEncoding("UTF-8");
					
					String num=map.get("num");
					
					String title=map.get("title");
					String author=map.get("author");
					String content=map.get("content");
					content = content.replace("\r\n","<br>");
					
					System.out.println(">>>>>>>>"+title+"\t"+author+"\t"+content);
					
					BoardDTO dto=new BoardDTO();
					dto.setAuthor(author);
					dto.setTitle(title);
					dto.setContent(content);
					dto.setNum(Integer.parseInt(num));

					BoardService service=new BoardService();
					String target="BoardListServlet";
					
					ArrayList<String> list=new ArrayList<String>();
					list.add("바보");
					list.add("멍청이");

					try {
						if(title!="" && content!="") {
							for(String k: list) {
								if (content.indexOf(k)>-1) {
									request.setAttribute("key", k+"를(을) 포함하고있어요");
									request.setAttribute("dto", dto);
									target="boardWriteForm.jsp";
								}else {
									
									service.updateByNum(dto);
									
									break;
								}
							}
						}
						else {
							request.setAttribute("writenull", "제목과 내용에 빈칸이 있는지 확인해주세요");
							request.setAttribute("dto", dto);
							target="boardWriteForm.jsp";
						}
						
					}catch(MyException me) {
						target="error.jsp";
						me.printStackTrace();
						System.out.println("1");
					}
					
					RequestDispatcher dis=request.getRequestDispatcher(target);
					dis.forward(request, response);
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
