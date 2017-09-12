<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico">
<title>Admin</title>
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
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(()=>{
		$("#deleteMember").on("click",()=>{
			var checkbox= document.querySelectorAll(".box");
			var checkboxList=[];
		 	   for(i=0;i<checkbox.length;i++){
		 		
		 		   if(checkbox[i].checked){
		 			  checkboxList.push('{"num":'+checkbox[i].value+'}');
		 			  
		 		   }
		 			  
		 	   }
		 	  console.log(checkboxList);
		 	 var aaa= checkboxList.join('');
		 	
		 	  $.ajax({
		 		 type:"get",
					url:"MembersDeleteServlet",
					dataType:"text",
					data:{
						num:aaa
					},
					success:(responseData,status,xhr)=>{
						
					
						$("#result").html(responseData);
						$("div#initView").empty();
					},
					error:(xhr,status,e)=>{
						
						console.log(e);
						
					}
		 	  });
		});
	});
</script>
</head>
<body>
<h1>관리자페이지</h1>
<jsp:include page="admin/adminForm.jsp" flush="true" /><br>
<hr>
<div id="#result">
</div>
<div id="#initView">
<jsp:include page="admin/membermanagepage.jsp" flush="true" /><br>
</div>
</body>
</html>