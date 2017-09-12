<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


   안녕하세요 ${sessionScope.login.username}<br>
  <a href="ChartFormServlet">판매현황</a>
  <a href="MemberManagementServlet">회원 관리</a>
  <a href="LogoutServlet">로그아웃</a>
  

