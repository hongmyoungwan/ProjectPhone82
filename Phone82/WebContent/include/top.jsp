<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    

<c:if test="${ empty sessionScope.login }">
  <a href="LoginFormServlet">로그인</a>
  <a href="MemberFormServlet">회원가입</a>
  <a href="">게시판</a>
</c:if>
<c:if test="${ ! empty sessionScope.login }">
   안녕하세요 ${sessionScope.login.username}
  <a href="LogoutServlet">로그아웃</a>
  <a href="MyPageServlet">마이페이지</a>
  <a href="CartListServlet">장바구니</a>
   <a href="">게시판</a>
</c:if>





