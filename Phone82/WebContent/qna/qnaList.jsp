<%@page import="com.dto.qna.QNAPageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#perPage").on("change",function(){
			var x=$("#perPage").val();
			location.href="QNAListServlet?perPage="+x;
			
		});
	});
	function boardSearch(f){
		f.action="QNAListServlet";
	};
	function boardWrite(){
		location.href="QNAWriteFormServlet";
	}
</script>

<h1>글목록보기</h1>
<div align="right"><button onclick="boardWrite()">글쓰기</button></div>
<div align="center">
<hr>
<form name="myForm">
<table>
	<colgroup>
	<col width="100"/>
	<col width="1000"/>
	<col width="200"/>
	<col width="200"/>
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
				<td><a href="QNARetrieveServlet?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.author}</td>
				<td>${dto.writeday}</td>
				<td>${dto.readCnt}</td>
			</tr>
			</c:forEach>
		</c:if>
		</table>
		<hr>
		<table>
		<tr>
		<td colspan="5" align="center"><jsp:include page="/qnapage.jsp"></jsp:include></td>
		</tr>
	</table>

<table>
	<tr>
			<td colspan="5"><select name="searchName">
					<option value="title">제목</option>
					<option value="author">작성자</option>
			</select>
			<input type="text" name="searchValue">
			<% QNAPageDTO bpage=(QNAPageDTO)request.getAttribute("page");
				int perPage=bpage.getPerPage();%>
			
			<select id="perPage">
			<option value="10" <%if(perPage==10){ %>selected <% }%>>10</option>
			<option value="20" <%if(perPage==20){ %>selected <% }%>>20</option>
			<option value="30" <%if(perPage==30){ %>selected <% }%>>30</option>
			</select>
			</td>
		</tr>
		
</table>
</form>
</div>
