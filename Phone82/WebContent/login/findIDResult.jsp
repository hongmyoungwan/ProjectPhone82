<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#login").on("click",function(event){
		location.href="LoginFormServlet";
	});
	$("#findPasswd").on("click",function(event){
		location.href="FindPasswdFormServlet";
	});
	$("#memberform").on("click",function(event){
		location.href="MemberFormServlet";
	});
});
</script>


<c:if test="${! empty mesg}">
${mesg}<br>

<button id="login"  class="button">로그인</button> &nbsp;
<button id="findPasswd"  class="button">비밀번호 찾기</button> 
</c:if>

<c:if test="${! empty mesg2}">
${mesg2}<br>

<button id="memberform"  class="button">회원가입</button> &nbsp;
</c:if>



