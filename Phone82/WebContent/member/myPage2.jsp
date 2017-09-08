<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
	//정규식 
	var re_id = /^[A-Za-z0-9_]{4,16}$/; // 아이디 검사식
	var re_pw = /^[A-Za-z0-9_]{6,18}$/; // 비밀번호 검사식
	var re_name = /^[A-Za-z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{2,16}$/; // 이름 검사식
	var re_nums = /^[0-9]{3,4}$/; //숫자 검사식
	var re_mail = /^([\w\.-]+)@([a-z\d\.-]+)\.([a-z\.]{2,6})$/; // 이메일 검사식

	//아이디 유효성
	$("#userid").on("keyup",function(event){
		var userid = $("#userid").val();
		if(userid =='' || userid.length ==0){
			$("#userid").next().text('필수 입력 사항입니다.').css({"color":"red", "font-size":"12px"});
		} else if(!re_id.test(userid)){
			$("#userid").next().text('4자리 이상 16자리 이하 영문과 숫자를 입력하세요.').css({"color":"red", "font-size":"12px"});
		} else {
			$("#userid").next($("div")).empty();
		}
	});
	
	//아이디 중복검사 
	$("#userid").on("blur",function(){
		 var userid = $(this).val();
		 //console.log(userid);
		 if(re_id.test(userid) && userid.length != 0){
			//ajax 코드
				$.ajax({ //설정값
					type:"get",
					url: "CheckIDServlet",
					data: {
						userid:$("#userid").val()
					},
					dataType :"text",
					success : function(responseData, status, xhr){
						console.log(responseData);
						$("#resultCheckID").text(responseData).css({"color":"blue", "font-size":"12px"});
						if($("#userid").val().length < 0){$("#resultCheckID").empty();}
						// $("#resultCheckID").hide(800);
						
					},
					error: function(xhr,status,e){
						console.log(status,e);
					} 
				});//ajax
		 }
	});
	
	
	
	/* $("#passwd").on("keyup",function(event){
		var passwd = $("#passwd").val();
		if(passwd =='' || passwd.length ==0){
			$("#passwd").next().text('필수 입력 사항입니다.').css({"color":"blue", "font-size":"12px"});
		} else if(!re_pw.test(passwd)){
			$("#passwd").next().text('6자리 이상 18자리 이하 영문과 숫자를 입력하세요.').css({"color":"red", "font-size":"12px"});
		}  else {
			$("#passwd").next().text('사용가능').css({"color":"blue", "font-size":"12px"});
		}
	}); */
	
	//비밀번호 일치여부
	$("#passwd2").on("keyup",function(event){
		var passwd = $("#passwd").val();
		var passwd2 = $("#passwd2").val();
		if(passwd2 =='' || passwd.length ==0){
			$("#passwd2").next().text('필수 입력 사항입니다.').css({"color":"red", "font-size":"12px"});
		} else if(passwd != passwd2){
			$("#passwd2").next().text('비밀번호가 일치하지 않습니다.').css({"color":"red", "font-size":"12px"});
		 } else {
			$("#passwd2").next($("div")).empty();
		}
	});
	
	//이메일 중복검사
 	$("#email").on("blur",function(){
	 var email = $(this).val();
	 if(email != '' || email.length != 0 ){
		 $.ajax({
			type:"get",
			url : "CheckEmailServlet",
			data : {
				email: $("#email").val()
			},
			success : function(responseData, status, xhr){
				console.log(responseData);
				$("#resultCheckEmail").text(responseData).css({"color":"blue", "font-size":"12px"});
			},
			error: function(xhr,status,e){
				console.log(status,e);
			} 
			});
	 }
	});
	 
	
	/* $("#username").on("keyup",function(event){
		var passwd = $("#username").val();
		if(passwd =='' || passwd.length ==0){
			$("#username").next().text('필수 입력 사항입니다.').css({"color":"blue", "font-size":"12px"});
		} else if(!re_name.test(passwd)){
			$("#username").next().text('2자리 이상 16자리 이하 영문과 숫자를 입력하세요.').css({"color":"red", "font-size":"12px"});
		} else {
			$("#username").next().text('사용가능').css({"color":"blue", "font-size":"12px"});
		}
	}); */
	
	 $("form").on("submit",function(event){
		 if($("#userid").val() == '' || $("#userid").val().length == 0){
		 		alert("아이디를 입력하세요");    
		 		$("#userid").focus();
		 		event.preventDefault();
		 		//result=false;
		 } else if(!re_id.test($("#userid").val())){
		 		alert("아이디에 6자리 이상 18자리 이하 영문과 숫자를 입력하세요.");    
		 		$("#userid").focus();
		 		event.preventDefault();
		 		//result=false;
		 } else if($("#passwd").val() == '' || $("#passwd").val().length == 0){
		 		alert("비밀번호를 입력하세요");
		 		$("#passwd").focus();
		 		event.preventDefault();
		 } else if(!re_pw.test($("#passwd").val())){
			 alert("비밀번호에 6자리 이상 18자리 이하 영문과 숫자를 입력하세요.");    
		 		$("#passwd").focus();
		 		event.preventDefault();
		 } else if($("#passwd").val() != $("#passwd2").val()){
		 		alert("비밀번호가 일치하지 않습니다.");
		 		$("#passwd2").focus();
		 		event.preventDefault();
		 } else if($("#username").val() == '' || $("#username").val().length == 0){
		 		alert("이름을 입력하세요");
		 		$("#username").focus();
		 		event.preventDefault();
		 } else if(!re_name.test($("#username").val())){
				alert("이름에 2자리 이상 16자리 이하 영문과 숫자를 입력하세요.");    
		 		$("#username").focus();
		 		event.preventDefault();
		 } 
		 else if($("#post1").val() == '' || $("#post1").val().length == 0){
		 		alert("옳바른 우편번호를 입력하세요");
		 		$("#post1").focus();
		 		event.preventDefault();
		 }  else if($("#post2").val() == null || $("#post2").val().length == 0){
		 		alert("옳바른 우편번호를 입력하세요");
		 		$("#post2").focus();
		 		event.preventDefault();
		 } else if($("#addr1").val() == '' || $("#addr1").val().length == 0){
		 		alert("옳바른 주소를 입력하세요");
		 		$("#addr1").focus();
		 		event.preventDefault();
		 } else if($("#addr2").val() == '' || $("#addr2").val().length == 0){
		 		alert("옳바른 주소를 입력하세요");
		 		$("#addr2").focus();
		 		event.preventDefault();
		 } else if($("#phone1").val() == '' || $("#phone1").val().length == 0){
		 		alert("전화번호을 다시 입력하세요");
		 		$("#phone1").focus();
		 		event.preventDefault();
		 } else if(!re_nums.test($("#phone2").val())){
		 		alert("전화번호를 확인하세요.(0~9까지 정수를 입력하세요.)");
		 		console.log($("#phone2").val());
		 		$("#phone2").val()="";
		 		$("#phone2").focus();
		 		event.preventDefault();
		 } else if($("#phone2").val() == '' || $("#phone2").val().length == 0){
		 		alert("전화번호을 다시 입력하세요");
		 		$("#phone2").focus();
		 		event.preventDefault();
		 } else if($("#phone3").val() == '' || $("#phone3").val().length == 0){
		 		alert("전화번호을 다시 입력하세요");
		 		$("#phone3").focus();
		 		event.preventDefault();
		 } else if(! re_nums.test($("#phone3").val())){
			 	alert("전화번호를 확인하세요.(0~9까지 정수를 입력하세요.)");
		 		console.log($("#phone3").val());
		 		//$("#phone3").val()="";
		 		$("#phone3").focus();
		 		event.preventDefault();
		 } else if($("#email").val() == '' || $("#email").val().length == 0){
		 		alert("email을 입력하세요");
		 		$("#email").focus();
		 		event.preventDefault();
		 } else if($('div:contains("사용중")').length >0){
			 alert("중복된 아이디입니다.");
			 	$("#userid").focus();
			 	console.log($("#userid").text());
			 	//$("#userid").text()="";
		 		event.preventDefault();
		 } /* else if($('div:contains("등록된")').length >0){
			 alert("등록된 아이디입니다.");
			 	$("#email").focus();
		 		event.preventDefault();
		 } */
		 
		 
		 
			 //submit();
			 //location.href="MemberAddServlet";
			 //console.log($(this));
		 	 this.action="MemberUpdateServlet";
			 
		   
	 });
	

	
	
	
	
});


</script>

<style type="text/css">

   .blue{
     color:blue;
   }
   .red{
     color:red;
   }
   
   p{margin-left: 80px;}
.a{text-decoration: none; font-size:12px; color:#363636;}
table{border:2px solid gray; padding: 20px;  }
.button{margin-top:5px; width: 200px;padding: 10px; padding-left:30px; padding-right:30px; background-color:#363636; color:#ffffff; border: 1px solid #363636; }
.button:hover{background-color:#ffffff; color:#000000; border: 1px solid #363636;}
   
</style>

<style>
  table {
    
    border: 1px solid gray;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid gray; padding: 15px;
  }
  th{background-color: #F6F6F6; text-align: left;}
  </style>

<!-- DAUM 주소 라이브러리 시작 -->  
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/daum.js"></script> 
<!-- DAUM 주소 라이브러리 끝 -->    

<form name="myform">
<table border=1>
 <tr>
 <th>아이디</th>
  <td colspan="3" >${login.userid}<input type="hidden" name="userid" value="${login.userid}"></td>
 </tr>
 <tr>
 <th>비밀번호</th>
  <td colspan="3"><input type="password" name="passwd" id="passwd" placeholder="*비밀번호" value="${login.passwd}"></td>
 </tr>
  <tr>
 <th>비밀번호 재확인</th>
  <td colspan="3"><input type="password" name="passwd2" id="passwd2" placeholder="*비밀번호 재확인"></td>
 </tr>
 <tr>
 <th>이름</th>
  <td colspan="3">${login.username}</td>
 </tr>
 <tr>
 <th>주소</th>
  <td colspan="3">
 <!-- 다음주소 시작:다음에서 제공한것->id,name값 수정x-->
	<input name="post1" id="post1" size="5" readonly="" value="${login.post1}"> -
	<input name="post2" id="post2" size="5" readonly="" value="${login.post2}">
	<input onclick="openDaumPostcode()" type="button" value="*우편번호찾기" >
	<br>
	<input name="addr1" id="addr1" size="40" readonly=""
		placeholder="*도로명주소" value="${login.addr1}">
	<br>
	<span style="line-height: 10%;"><br></span>
	<input name="addr2" id="addr2" size="40" placeholder="*지번주소" value="${login.addr2}">
<!-- 다음주소 끝 -->
  </td>
 </tr>
  <tr>
  <th>전화번호</th>
  <td>
   <select name="phone1" id="phone1">
      <c:choose>
       <c:when test="${login.phone1 == '010'}">
         <option value="010" selected>010</option>
         <option value="011">011</option>
         <option value="017">>017</option>
       </c:when>
       <c:when test="${login.phone1 == '011'}">
         <option value="010" >010</option>
         <option value="011" selected>011</option>
         <option value="017">017</option>
       </c:when>
      <c:when test="${login.phone1 == '017'}">
         <option value="010" >010</option>
         <option value="011" >011</option>
         <option value="017" selected>017</option>
      </c:when>
    </c:choose>
     </select>
  
  - <input type="text" name="phone2" id="phone2" placeholder="" SIZE="3" placeholder="*" value="${login.phone2}" >
  - <input type="text" name="phone3" id="phone3" SIZE="3" placeholder="*" value="${login.phone3}">
  </td>
 </tr>
 <tr>
 <th>이메일</th>
  <td colspan="3"><input type="email" name="email" id="email" placeholder="*이메일" value="${login.email}"></td>
 </tr>
 
<tr>
 <td align="center" colspan="2">
  
  <button  id="memberUpdate" class="a">수정</button> 
 </td>
</tr>
</table>

</form>
<button onclick="memberDelete(myform)" class="a">탈퇴</button>

<script>

  function memberDelete(f){
	 f.action="MemberDeleteServlet"; 	
 }
  </script>
