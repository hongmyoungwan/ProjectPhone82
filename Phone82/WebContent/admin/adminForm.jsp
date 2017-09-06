<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


   안녕하세요 ${sessionScope.login.username}
  <a href="">판매현황</a>
  <a href="ChartFormServlet">핸드폰 관리</a>
  <a href="">회원 관리</a>
  <a href="LogoutServlet">로그아웃</a>
  

