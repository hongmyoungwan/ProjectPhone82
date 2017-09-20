<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<td>${retrieve.num}</td><td>${retrieve.content}</td><td>${retrieve.userid}</td><td>${retrieve.writeday}</td>
<c:if test="${!empty login}">
	<c:if test="${sessionScope.login.userid=='master'}">
		<td><button id="reply">답글달기</button></td>
	</c:if>
</c:if>