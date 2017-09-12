<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<form name=memManageform>
	<table border="1" style="float: right; width: 80%;" align="center" frame=void>

		<tr class="columhead">
			
			<td class="checkBoxAll"><input type="checkbox" name="boxAll"
				id="boxAll"></td>
			<td>아이디</td>
			<td>사용자이름</td>
			<td>사용자이메일</td>
			<td>전화번호</td>
			<td>주소</td>
		</tr>
		<c:set var="count" value="0"/>
		<c:forEach var="item" items="${membermanagepage}" varStatus="status">
			<tr class="columbody">
				
				<td class="checkBox"><input type="checkbox" name="box" class="box" id="box${item.member_num}" value="${item.member_num}"/>
				</td>
				<td>${item.userid}</td>
				<td>${item.username}</td>
				<td>${item.email}</td>
				<td>${item.phone1+item.phone2+item.phone3}</td>
				<td>${item.post1}${item.post2}${item.addr1}${item.addr2}</td>

			</tr>
		</c:forEach>
		<tr>
			<td colspan="6"><jsp:include page="../adminmemberpagging.jsp"
					flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td colspan="6" style="text-align: right; ">
			<input id="deleteMember" value="회원 삭제" type="button"> 
			<button onclick="updateMember(this)"> 수정 </button>
			</td>
		</tr>
	</table>

</form>
<script>
/* 	function deleteMember(f){
		 var checkbox= document.querySelectorAll(".box");
	 
		   console.log(checkbox.length);
	 	   for(i=0;i<checkbox.length;i++){
	 		
	 		   if(checkbox[i].checked)
	 			   console.log(checkbox[i].value);
	 	   }
	}
 */
</script>





