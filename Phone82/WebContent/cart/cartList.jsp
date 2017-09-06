<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
#head {
	background-color: gray;
}

#left_side_menu{
width:20%;
height:100px;
float:left;
background-color: #ff5a1e;
text-align: left;
}
.main_content{
width:60%;
height:300px;
float:center;
background-color: white;
text-align: right;
}
</style>

<span id="left_side_menu" >
<a href="">MyPage</a><br>
<a href="">후기게시판</a><br>
<a href="">고객센터</a><br>
</span>

<table border="0" class="main_content">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default" style="text-align: center;">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr id="head">
		<td class="td_default" align="center"><input type="checkbox"
			name="allCheck" id="allCheck" onchange="allCheck(this)"> <strong>선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	<c:if test="${fn:length(cartList)==0}">
		<tr>
			<td colspan="10">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>

		<tr>
			<td height="5">
		</tr>
		<tr>
			<td class="td_default" align="center">카트에 추가된 상품이 없습니다.</td>
		</tr>
	</c:if>

	<c:if test="${fn:length(cartList)!=0}">
		<tr>
			<td colspan="10">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>



		<form name="myForm">
			<c:forEach var="xxx" items="${cartList}">


				<tr>
					<td class="td_default" width="80">
						<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. --> <input
						type="checkbox" name="check" id="check${xxx.num}" class="check"
						value="${xxx.num}">
						<br>
					</td>
					<td class="td_default" width="80">${xxx.num}</td>
					<td class="td_default" width="80"><img
						src="images/items/${xxx.simage}.jpg" border="0" align="center"
						width="80" /></td>
					<td class="td_default" width="300" style='padding-left: 30px'>${xxx.phone_name}
						<br>
					</td>
					<td class="td_default" align="center" width="110"><fmt:formatNumber
							value="${xxx.sprice}" type="currency" /></td>
					<td class="td_default" align="center" width="90"><input
						class="input_default" type="text" name="CART_AMOUNT"
						id="CART_AMOUNT${xxx.num}" style="text-align: right" maxlength="3"
						size="2" value="${xxx.samount}"></input></td>
					<td><input type="button" value="수정"
						onclick="amountUpdate('${xxx.num}')" /></td>
					<td class="td_default" align="center" width="80"
						style='padding-left: 5px'><span id="sum${xxx.num}"> <fmt:formatNumber
								value="${xxx.sprice * xxx.samount}" type="currency" />
					</span></td>
					<td><input type="button" value="주문"
						onclick="order('${xxx.num}','${xxx.userid}')">
						<c:out value="${xxx.userid}"></c:out>
						</td>
					<td class="td_default" align="center" width="30"
						style='padding-left: 10px'><input type="button" value="삭제"
						onclick="delCart('${xxx.num}')"></td>
					<td height="10"></td>
				</tr>

			</c:forEach>

		</form>
		<tr>
			<td colspan="10">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
		<tr>
			<td height="30">
		</tr>

		<tr>
			 <a class="a_black" href="#"> 계속
					쇼핑하기 </a></td>
		</tr>
		<tr>
			<td height="20">
		</tr>
	</c:if>
</table>


<script>


	function amountUpdate(num) {
		var amount = document.getElementById("CART_AMOUNT" + num).value;
		location.href = "CartAmountUpdateServlet?num=" + num + "&amount="
				+ amount;
	}
	function delCart(num) {
		location.href = "CartDeleteServlet?num="+num;
	}


	function order(num, userid) {
		console.log(userid);
		location.href = "PaymentViewServlet?num=" + num + "&userid=" + userid;

	}
</script>

<c:if test="${!empty requestScope.amountUpdate }">
	<script>
		alert('${requestScope.amountUpdate}');
	</script>
</c:if>









