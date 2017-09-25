<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



   <c:set var="dto" value="${page}"></c:set>
   <c:set var="curPage" value="${dto.curPage}"></c:set>
   <c:set var="perPage" value="${perPage}"></c:set>
   <c:set var="curIdx" value="${dto.curIdx}"/>
   <c:set var="totalCount" value="${dto.getTotalCount()}"></c:set>
   	<c:set var="length" value="${curIdx*curPage*perPage}"/>
   	<fmt:parseNumber integerOnly="true" var="totalNum" value="${totalCount/perPage}" />
   	<c:if test="${totalCount%perPage==0}">
   		<c:set var="totalNum" value="${totalNum+1}"/>
   	</c:if>
   	
   	<c:set var="paggingIdx" value="${curIdx*perPage}"/>
   	<c:forEach begin="${paggingIdx+1}" end="${totalNum+1}" varStatus="status"> 
   			
   			<c:if test="${curPage==status.index}">
   			
   				<c:out value="${status.index}"/>&nbsp;
   			</c:if>
   		
   	</c:forEach>
