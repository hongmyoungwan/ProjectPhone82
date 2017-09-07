<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<form action="AddFileServlet" method="post" enctype="multipart/form-data">
<table border="1">
			<tr>
				<td>카테고리<input type="text" name="telecom_num"></td>
			</tr>
			<tr>
				<td>폰모델<input type="text" name="phone_model_num"></td>
			</tr>
			<tr>
				<td>폰이름<input type="text" name="phone_name"></td>
			</tr>
			<tr>
				<td>내용<input type="text" name="phone_content"></td>
			</tr>
			<tr>
				<td>가격<input type="text" name="phone_price"></td>
			</tr>
			<tr>
				<td>폰사진<input type="file" name="phone_image"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="등록"><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>