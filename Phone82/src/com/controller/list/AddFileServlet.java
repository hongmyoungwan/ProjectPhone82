package com.controller.list;

import java.io.File;
import java.io.IOException;
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

import com.biz.list.PhoneListBiz;
import com.dto.list.PhoneDTO;


@WebServlet("/AddFileServlet")
public class AddFileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
					
					HashMap<String, String> map = new HashMap<>();
					
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
					    	
					    	fileName = item.getName();
					    	map.put("phone_image", fileName.substring(0,fileName.length()-4));
					    	contentType = item.getContentType();
					    	sizeInBytes = item.getSize();
					    	 File uploadedFile = new File("C:\\Users\\acorn\\git82\\Phone2\\WebContent\\images",fileName);
					    	 item.write(uploadedFile);
					    	 System.out.println(fileName.substring(0,fileName.length()-4));
					    	
					    }
					}//
					
					PhoneListBiz biz = new PhoneListBiz();
					
					String telecom_num = map.get("telecom_num");
					String phone_model_num = map.get("phone_model_num");
					String phone_name = map.get("phone_name");
					String phone_content = map.get("phone_content");
					String phone_price = map.get("phone_price");
					String phone_image = map.get("phone_image");
					
					PhoneDTO dto = new PhoneDTO(telecom_num, phone_model_num, phone_name, phone_content, Integer.parseInt(phone_price), phone_image);
					
					biz.PhoneAdd(map);
					RequestDispatcher dis = request.getRequestDispatcher("PhoneListServlet");
					dis.forward(request, response);
					
					
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
			}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
