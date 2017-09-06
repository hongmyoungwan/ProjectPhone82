<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../xxx.css">
<link rel="stylesheet" href="//cdn.jsdelivr.net/gh/xpressengine/xeicon@2.3.3/xeicon.min.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$(".m24").on("click",function(){
			console.log("sfsd0", $(this).val());
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
					v1:$(this).val()
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
			console.log("1");
			$.ajax({
				type:"get",
				url:"calc2.jsp",
				data:{
					v1:$("#result").val(),
					v2:$("#result1").val()
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
</script>
</head>
<body>

	<table border="0">
		<tr>
			<td rowspan="9"><img src="images/${dto.phone_image}.jpg" width="300" height="500"></td>
			<td colspan="2"><h3>${dto.phone_name }</h3></td>
			<td></td>
		</tr>
		
		<tr>
			<td>색상,용량</td>
			<td align="center">
				<a href=""><i class="xi-radiobox-blank xi-2x"></i></a>
				<a href=""><i class="xi-full-moon xi-2x"></i></a>
				
			</td>
			<td></td>
		</tr>
		
		<tr>
			<td>가입유형</td>
			<td>
				<input type="button" value="기기변경" class="button" title="기기변경은 이 버튼을 눌러주세요!">
				<input type="button" value="신규가입" class="button" title="신규가입 환영합니다!!">
				<input type="button" value="번호이동" class="button" title="번호 이동하실 분은 이 버튼을 클릭!">
			</td>
			<td>
				매월 납부하실 금액<br>
				<div id="result"></div>
			</td>
		</tr>
		<tr>
			<td>분할상환기간</td>
			<td><input type="button" value="24" class="m24" >
			<input type="button" value="30" class="m24">
			<input type="button" value="36"  class="m24"></td>
			<td colspan="">
				한달 요금 가격<br>
				<div id="result1"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<select class="rate">
					<option value="87890">LTE 데이터 선택 87.8</option>
					<option value="76890">LTE 데이터 선택 76.8</option>
					<option value="65890">LTE 데이터 선택 65.8</option>
					<option value="54890">LTE 데이터 선택 54.8</option>
					<option value="54890">LTE 데이터 선택 49.3</option>
					<option value="43890">LTE 데이터 선택 43.8</option>
					<option value="38890">LTE 데이터 선택 38.3</option>
					<option value="32890">LTE 데이터 선택 32.8</option>
					<option value="109890">LTE 데이터 선택 109</option>
				</select>
				<input type="button" class="plus" value="총합계 금액">
			</td>
			<td colspan="4">
				한달 총 납부 금액<br>
				<div id="result2"></div>
			</td>
		</tr>
		<tr>
			<td>지원금 유형</td>
			<td>
				<input type="button" value="단말할인" class="button"title="단말기 요금 할인은 여기!">
				<input type="button" value="요금할인" class="button"title="요금 할인을 원하시는 분은 여기!">
			</td>
		</tr>
		<tr>
			<td>약정 기간</td>
			<td><input type="button" value="24개월" class="button" title="약정기간은 24개월 밖에 안되네요 ㅠㅠ"></td>
		</tr>
		<tr>
			<td>고객 유형</td>
			<td>
				<input type="button" value="개인" class="button" title="만 19세이상 성인">
				<input type="button" value="미성년자" class="button" title="만 19세미만">
				<input type="button" value="법인" class="button" title="법인">
				<input type="button" value="외국인" class="button" title="foreigner">
			</td>
		</tr>
		<tr>
			<td>단말기 가격</td>
			<td><input type="text" value="${dto.phone_price}" id="price"></td>
		</tr>
	</table>
</body>
</html>