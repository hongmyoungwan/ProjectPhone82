<%@page import="com.dto.qna.QNADTO"%>
<%@page import="com.dto.qna.QNAPageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("[id^='a']").on("click",function(){
		var x=$(this).children("td").eq(0).text();
				location.href="QNARetrieveServlet?num="+x; 
		});
	});
</script>

<h1>QNA</h1>
<hr>
<c:if test="${!empty requestScope.key}">
	<script>
	alert("${requestScope.key}");
	</script>
</c:if>
<c:if test="${!empty requestScope.writeNull}">
	<script>
	alert("${requestScope.writeNull}");
	</script>
</c:if>

<div align="center">
<form action="QNAWriteServlet" method="post">
<input type="hidden" name="author" value="${sessionScope.login.username}">
<br>
<h3 align="left" style="margin-left: 220px">문의하기</h3>
<table>
<tr>
<td bgcolor="silver">문의제목</td><td><input type="text" name="title" value="${dto.title}" size="50"><br></td>
</tr>
<tr>
<td bgcolor="silver">작성자</td><td>${sessionScope.login.username}</td>
</tr>
<tr>
<td bgcolor="silver">문의내용</td><td><textarea rows="30" cols="100" name="content">${dto.content}</textarea></td>
</tr>
</table>
<input type="submit" value="문의하기">
<input type="reset" value="취소">
</form>
<br><br>
<h3 align="left" style="margin-left: 220px">나의 문의내역</h3>
<table>
	<colgroup>
	<col width="100"/>
	<col width="400"/>
	<col width="100"/>
	<col width="100"/>
	<col width="100"/>
	</colgroup>
		<tr bgcolor="silver">
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:set var="list" value="${page.getList()}"></c:set>
		<c:if test="${list.size()==0}">
			<tr>
			<td colspan="5" align="center">게시물이 없습니다</td>
			</tr>
		</c:if>
		<c:if test="${list.size()!=0}">
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.num}</td>
				<td>${dto.title}</td>
				<td>${dto.author}</td>
				<td>${dto.writeday}</td>
				<td>${dto.readCnt}</td>
			</tr>
			
			</c:forEach>
			
		</c:if>
		</table>
		
		<table>
		<tr>
		<td colspan="5" align="center"><jsp:include page="/qnapage.jsp"></jsp:include></td>
		</tr>
	</table>
	<hr>

	
</div>
