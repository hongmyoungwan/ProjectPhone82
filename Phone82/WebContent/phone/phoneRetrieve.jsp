<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../xxx.css">
<link rel="stylesheet" href="//cdn.jsdelivr.net/gh/xpressengine/xeicon@2.3.3/xeicon.min.css">
<style type="text/css">
   .important{
     font-weight: bold;
     font-size;
   }
   .blue{
     border-color:blue;
   }
   .imgst1 {
	width : 220px;
	height : 400px;
	display : inline-table;
	border : 0px;
}
   
</style>
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$(".typeButton").on("click",function(event){
			$(this).siblings().css("border","2px outset rgb(221, 221, 221)");
			$(this).css("border","2px solid black");
			
    	});
		$(".m24").on("click",function(event){
			$(this).siblings().css("border","2px outset rgb(221, 221, 221)");
			$(this).css("border","2px solid black");
			
    	});
		$(".color").on("click",function(event){
			$(this).siblings().css("border","2px outset rgb(221, 221, 221)");
			$(this).css("border","2px solid black");
			
    	});
		$(".support").on("click",function(event){
			$(this).siblings().css("border","2px outset rgb(221, 221, 221)");
			$(this).css("border","2px solid black");
			
    	});
		$(".type").on("click",function(event){
			$(this).siblings().css("border","2px outset rgb(221, 221, 221)");
			$(this).css("border","2px solid black");
			
    	});
		$(".aaa").on("click",function(event){
			$(this).siblings().css("border","2px outset rgb(221, 221, 221)");
			$(this).css("border","2px solid black");
			
    	});
	});
	$(document).ready(function(){
		$(".m24").on("click",function(){
			$.ajax({
				type:"get",
				url:"calc.jsp",
				data:{
					v1:$(this).val(),
					v2:$("#price").val()
				},
				dataType:"text",
				success:function(responseData,status,xhr){
					console.log(responseData);
					$("#result").text(responseData);
				},
				error:function(xhr,status,error){
					console.log(error);
				}
			});
		});
	});
	
	$(document).ready(function(){
		$(".rate").on("click",function(){
			
			$.ajax({
				type:"get",
				url:"calc1.jsp",
				data:{
					v1:$(".rate").val()
				},
				dataType:"text",
				success:function(responseData,status,xhr){
					console.log(responseData);
					$("#result1").text(responseData);
				},
				error:function(xhr,status,error){
					console.log(error);
				}
			});
		});
	});
	$(document).ready(function(){
		$(".plus").on("click",function(){
			console.log(">>>>>>>>>>>"+$("#result").text()+$("#result1").text());
			$.ajax({
				type:"get",
				url:"calc2.jsp",
				data:{
					v1:$("#result").text(),
					v2:$("#result1").text()
				},
				dataType:"text",
				success:function(responseData,status,xhr){
					console.log(responseData);
					$("#result2").text(responseData);
				},
				error:function(xhr,status,error){
					console.log(error);
				}
			});
		});
		
	});
	$(document).ready(function(){
		$("#img_black").on("click", function(){
			 $("#img").attr("src", "images/${dto.phone_image}_black.jpg");
		});
		$("#img_white").on("click", function(){
			 $("#img").attr("src", "images/${dto.phone_image}.jpg");
		});
	});
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<table border="0" align="center" >
		<tr>
			<td rowspan="9">
				<table border="0">
					<tr>
						<td><input type="button" value="<"></td>
						<td><img id="img" src="images/${dto.phone_image}" class="imgst1"></td>
						<td><input type="button" value=">"></td>
					</tr>
				</table>
			</td>
			<th colspan="2">${dto.phone_name }</th>
			<td colspan="2"></td>
		</tr>
		
		<tr>
			<td>색상,용량 </td>
			<td>
				<!-- <a href="" id="img_black"><i class="xi-radiobox-blank xi-2x" style="color:black"></i></a>
				<a href=""><i class="xi-full-moon xi-2x" style="color:black"></i></a> -->
				<button id="img_black" class="color">검은색</button>
				<button id="img_white" class="color">흰색</button> 
				<%-- &nbsp;&nbsp;&nbsp;&nbsp;<a href="PhoneColorServlet?telecom_num=${dto.telecom_num}&color=black" ><img src="images/black.png" width="30"></a>
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="PhoneColorServlet" ><img src="images/white.png" width="30"></a> --%>
			</td>
			
		</tr>
		
		<tr>
			<td>가입유형</td>
			<td>
				<input type="button" value="기기변경" class="typeButton" title="기기변경은 이 버튼을 눌러주세요!">
				<input type="button" value="신규가입" class="typeButton" title="신규가입 환영합니다!!">
				<input type="button" value="번호이동" class="typeButton" title="번호 이동하실 분은 이 버튼을 클릭!">
			</td>
			<td>
				<font size="2">기기 값</font><br>
				<div id="result"></div>
			</td>
		</tr>
		<tr>
			<td>분할상환기간</td>
			<td><input type="button" value="24" class="m24">
			<input type="button" value="30" class="m24">
			<input type="button" value="36"  class="m24"></td>
			<td colspan="">
				<font size="2">요금</font><br>
				<div id="result1"></div>
			</td>
		</tr>
		<tr>
			<td>요금제</td>
			<td >
				<select class="rate">
					<option value="87890">LTE 데이터 선택 87.8</option>
					<option value="76890">LTE 데이터 선택 76.8</option>
					<option value="65890">LTE 데이터 선택 65.8</option>
					<option value="54890">LTE 데이터 선택 54.8</option>
					<option value="54890">LTE 데이터 선택 49.3</option>
					<option value="43890">LTE 데이터 선택 43.8</option>
					<option value="38890">LTE 데이터 선택 38.3</option>
					<option value="32890">LTE 데이터 선택 32.8</option>
					<option value="109890" selected>LTE 데이터 선택 109</option>
				</select>&nbsp;&nbsp;&nbsp;
				 <input type="button" class="plus" value="총합계 금액">
			</td>
			<td colspan="4">
				<font size="2">총합 </font><br>
				<div id="result2"></div>
			</td>
		</tr>
		<tr>
			<td>지원금 유형</td>
			<td>
				<input type="button" id="a" value="단말할인" class="support"title="단말기 요금 할인은 여기!">
				<input type="button"  value="요금할인" class="support"title="요금 할인을 원하시는 분은 여기!">
			</td>
		</tr>
		<tr>
			<td>약정 기간</td>
			<td><input type="button" value="24개월" class="aaa" title="약정기간은 24개월 밖에 안되네요 ㅠㅠ"></td>
		</tr>
		<tr>
			<td>고객 유형</td>
			<td>
				<input type="button" value="개인" class="type" title="만 19세이상 성인">
				<input type="button" value="미성년자" class="type" title="만 19세미만">
				<input type="button" value="법인" class="type" title="법인">
				<input type="button" value="외국인" class="type" title="foreigner">
			</td>
		</tr>
		<tr>
			<td>단말기 가격</td>

			

			<td><input type="text" value="${dto.phone_price}" id="price" readonly="readonly"></td>

		</tr>
		<tr>
			<td></td>
			<td colspan="3"><a href="PaymentViewServlet?phone_model_num=${dto.phone_model_num}
			&phone_name=${dto.phone_name}&phone_price=${dto.phone_price}&phone_image=${dto.phone_image}
			&telecom_num=${dto.telecom_num}">주문하기</a>  
			<a href="CartInsertServlet?phone_model_num=${dto.phone_model_num}
			&phone_name=${dto.phone_name}&phone_price=${dto.phone_price}&phone_image=${dto.phone_image}
			&telecom_num=${dto.telecom_num}">장바구니 담기</a>
			<br><a href="updateForm.jsp?telecom_num=${dto.telecom_num}">수정</a>    &nbsp;
			 <a href="PhoneDeleteServlet?telecom_num=${dto.telecom_num}">삭제</a></td>
			
		</tr>
	</table>

</body>
</html>