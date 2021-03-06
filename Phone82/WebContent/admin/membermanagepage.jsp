<%@page import="com.dto.admin.MemberMngPageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<table border="1" style="float: right;" align="center" frame=void>

	<tr class="columhead">

		<td class="checkBoxAll"><input type="checkbox" name="boxAll"
			id="boxAll"></td>
		<td>회원번호</td>
		<td>아이디</td>
		<td>사용자이름</td>
		<td>사용자이메일</td>
		<td>전화번호</td>
		<td>주소</td>
		<td></td>
	</tr>
	<c:set var="count" value="0" />
	<c:set var="list" value="${membermanagepage.m_list}" />
	<c:forEach var="item" items="${list}" varStatus="status">
		<tr class="columbody" id="z${item.member_num}">

			<td class="checkBox"><input type="checkbox" name="check"
				class="box" id="box${item.member_num}" value="${item.member_num}" />
			</td>
			<td>${item.member_num}</td>
			<td align="left"><input type="text"
				id="userid${item.member_num}" value="${item.userid}" size="10"></td>
			<td align="left"><input type="text"
				id="username${item.member_num}" value="${item.username}" size="10"></td>
			<td align="left"><input type="text" id="email${item.member_num}"
				value="${item.email}" size="20"></td>
			<td align="left"><input type="text"
				id="phone1${item.member_num}" value="${item.phone1}" size="2">
				<input type="text" id="phone2${item.member_num}"
				value="${item.phone2}" size="2"> <input type="text"
				id="phone3${item.member_num}" value="${item.phone3}" size="2"></td>
			<td align="left">( <input type="text"
				id="post1${item.member_num}" value="${item.post1}" size="2">-
				<input type="text" id="post2${item.member_num}"
				value="${item.post2}" size="2">) <input type="text"
				id="addr1${item.member_num}" value="${item.addr1}" size="10">
				<input type="text" id="addr2${item.member_num}"
				value="${item.addr2}" size="10">
			</td>
			<td><input style="background-color: lime;"
				id="updateMember${item.member_num}" value="회원 수정" type="button"
				size="20"></td>

		</tr>
	</c:forEach>
	<tr>
		<td colspan="8" align="center">
		<c:set var="dto"
				value="${membermanagepage}"/> 
	<c:set var="dto"
				value="${membermanagepage}"/> 
				<c:set var="curPage" value="${dto.curPage}"/>
				<c:set var="totalCount"	value="${dto.getTotalCount()}"></c:set>
				<c:set var="length"	value="${dto.curIdx*curPage*dto.perPage}"/>
				<fmt:parseNumber integerOnly="true" var="totalNum" value="${totalCount/dto.perPage}" />
			<c:if test="${totalCount%dto.perPage==0}">
				<c:set var="totalNum" value="${totalNum+1}" />
			</c:if> <c:set var="paggingIdx" value="${dto.curIdx*dto.perPage}" /> <a
			href="MemberManagementServlet?curPage=${paggingIdx}&curIdx=${dto.curIdx}">
				&lt; </a> <c:forEach begin="${paggingIdx+1}" end="${totalNum+1}"
				varStatus="status">

				<c:if test="${curPage==status.index}">
   			
   				${status.index}&nbsp;
   			</c:if>
				<c:if test="${curPage!=status.index}">

					<a
						href="MemberManagementServlet?curPage=${status.index}&curIdx=${dto.curIdx}">${status.index}</a>&nbsp;
   			</c:if>

			</c:forEach> <a
			href="MemberManagementServlet?curPage=${1+(pageIndex+1)*totalNum}&curIdx=${dto.curIdx}">
				&gt; </a> 
				</td>
	</tr>
	<tr>
		<td colspan="7" align="center"><select id="searchName">
				<option value="userid">아이디</option>
				<option value="member_num">회원번호</option>
		</select> <input type="text" id="searchValue""> <input type="button"
			id="searchButton" value="검색"> <%
 	MemberMngPageDTO bpage = (MemberMngPageDTO) request.getAttribute("membermanagepage");
 	int perPage = bpage.getPerPage();
 %> <select id="perPage">
				<option value="10" <%if (perPage == 10) {%> selected <%}%>>10</option>
				<option value="20" <%if (perPage == 20) {%> selected <%}%>>20</option>
				<option value="30" <%if (perPage == 30) {%> selected <%}%>>30</option>

		</select></td>
		<td colspan="8" style="text-align: right;"><input
			id="deleteMember" value="회원 삭제" type="button"></td>
	</tr>
</table>


