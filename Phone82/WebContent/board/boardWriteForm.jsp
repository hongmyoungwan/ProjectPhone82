<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<c:if test="${!empty requestScope.key}">
	<script>
	alert("${requestScope.key}");
	</script>
</c:if>
<c:if test="${!empty requestScope.writenull}">
	<script>
	alert("${requestScope.writenull}");
	</script>
</c:if>

<h1>글쓰기</h1>
<hr>
<div align="center">
<form action="BoardWriteServlet" method="post">
<input type="hidden" name="author" value="${sessionScope.login.username}">
<table>
<tr>
<td bgcolor="silver">제목</td><td><input type="text" name="title" value="${dto.title}" size="50"><br></td>
</tr>
<tr>
<td bgcolor="silver">작성자</td><td>${sessionScope.login.username}</td>
</tr>
<tr>
<td bgcolor="silver">내용</td><td><textarea rows="30" cols="100" name="content">${dto.content}</textarea></td>
</tr>
</table>
<input type="submit" value="쓰기">
<input type="reset" value="취소">

</form>
<hr>
<div align="left"><button onclick="boardList()">목록</button></div>
</div>


<script>
	function boardList(){
		location.href="BoardListServlet";
	}
</script>



