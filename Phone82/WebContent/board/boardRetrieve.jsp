<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<h1>상세보기</h1>
<div id="div" align="center">
<hr>
<form action="BoardUpdateServlet" method="post">
<input type="hidden" name="num" value="${retrieve.num}">
<input type="hidden" name="author" value="${retrieve.author}">
<table>
<tr>
<td bgcolor="silver">글번호</td><td>${retrieve.num}</td>
</tr>
<tr>
<td bgcolor="silver">작성일</td><td>${retrieve.writeday}</td>
</tr>
<tr>
<td bgcolor="silver">조회수</td><td>${retrieve.readCnt}</td>
</tr>
<tr>
<td bgcolor="silver">제목</td><td><input type="text" name="title" value="${retrieve.title}" size="50"><br></td>
</tr>
<tr>
<td bgcolor="silver">작성자</td><td>${retrieve.author}<br></td>
</tr>
<tr>
<td bgcolor="silver">내용</td><td><textarea rows="30" cols="100" name="content">${retrieve.content}</textarea></td>
</tr>
</table>
<hr>
<input type="submit" value="수정">
</form>
<button id="List" onclick="boardList()">목록</button>
<button id="Delete" onclick="boardDelete()">삭제</button>
<br>
댓글 ${comment.size()}
<table border="1">
<c:if test="${comment.size()!=0}">
<c:forEach var="comment" items="${comment}">
<tr>
<td>${comment.username}</td>
<td>${comment.commentday}</td>
</tr>
<tr>
<td colspan="2">${comment.content}</td>
</tr>
</c:forEach>
</c:if>
<tr>
<td><textarea rows="5" cols="80" id="comment">xx</textarea>
<td><button onclick="boardComment(event)">comment</button></td>
</tr>
</table>

</div>


<script>
	function boardReply(){
		location.href="BoardReplyServlet?title=${retrieve.title}&content=${retrieve.content}";	
	}
	
	function boardList(){
		location.href="BoardListServlet";
	}
	
	function boardDelete(){
		location.href="BoardDeleteServlet?num=${retrieve.num}";
	}
	function boardComment(e){
		console.log($("textarea:last").text());
		if($("textarea:last").text()==null){
			e.preventDefault();
		}
		else{
			var x=$("textarea:last").text();
			console.log(x);
			location.href="BoardCommentServlet?boardnum=${retrieve.num}&content="+x;
		}
		
	}
</script>