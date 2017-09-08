<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
<!--
.columhead {
	background-color: #eee;
	text-align: center;
	font-weight: bold;
}

.columbody {
	background-color: #DDDDFF;
	text-align: center;
	font-weight: normal;
}

table {
	width: 80%;
	
	border-collapse:collapse;
	border-right:none;
	border-left:none;
	border-top:none;
	border-bottom:none;
}

th, td {
	
	padding: 10px;
}
-->
</style>

<form name=memManageform>
	<table border="1" style="float: right; width: 80%;" align="center" frame=void>

		<tr class="columhead">
			<td>No.</td>
			<td class="checkBoxAll"><input type="checkbox" name="boxAll"
				id="boxAll"></td>
			<td>아이디</td>
			<td>사용자이름</td>
			<td>사용자이메일</td>
			<td>전화번호</td>
			<td>주소</td>
		</tr>
		<c:forEach var="item" items="${membermanagepage}">
			<tr class="columbody">
				<td>1</td>
				<td class="checkBox"><input type="checkbox" name="box" id="box">
				</td>
				<td>${item.userid}</td>
				<td>${item.username}</td>
				<td>${item.email}</td>
				<td>${item.phone1+item.phone2+item.phone3}</td>
				<td>${item.post1}${item.post2}${item.addr1}${item.addr2}</td>

			</tr>
		</c:forEach>
		<tr>
			<td colspan="7"><jsp:include page="../adminmemberpagging.jsp"
					flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td colspan="7" style="text-align: right; ">
			<button onclick="deleteMember(this)"> 회원 삭제</button>
			<button onclick="updateMember(this)"> 수정 삭제</button>
			</td>
		</tr>
	</table>

</form>
<script>
	function deleteMember(f){
		  location.href="memberDeleteServlet?userid="+num;
	}

</script>]





