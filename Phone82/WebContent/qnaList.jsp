<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
 body{
 	font:14px/1.8 Arial,Helvetica, sans-serif;
 }
 .frame{
 	width:800px;
 	margin: 0 auto;
 	border: 1px solid #aaa;
 }
 .header{
 	padding : 40px 10px;
 	text-align : center;
 	background : #eee;
 	margin-bottom : 20px;
 }
 .logo{
 	font-size : 2em;
 	font-weight : bold;
 	background:#eee;
 	color: #fff;
 	display : inline-block;
 	padding : 0 8px;
 }
 .container{
 	overflow:hidden;
 }

.nav{
	float: left;
	width: 150px;
	background: #eee;
	color : #fff;
	margin-right: 50px;
}
.nav-list{
	list-style:none;
	margin:0;
	padding: 10px 0;
}
.nav-item{
	margin: 4px 0;
}
.nav-link{
	display:block;
	text-decoration: none;
	padding: 4px 10px;
	color: #fff;
}
.nav-link:hover{
	background: #5457de;
}
.content{
	float: left;
	width : 600px;
}
.footer{
	text-align:center;
	border-top: 1px solid #aaa;
	margin: 20px 20px 0;
	font-size: 12px;
}
.container{
	display: table;
	
	background: url
}
.nav, .content{
	display: table-cell;
}
.content{
	background:#fff;
}

 
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${!empty requestScope.result}">
	<script>
	alert("${requestScope.result}");
	</script>
</c:if>
<div class="frame"><jsp:include page="menu/top.jsp" flush="true"/>
<div class="header">
<div class="logo"><a href="home.jsp"><img src="images/ddd.png"></a> </div>
</div>
<jsp:include page="qna/qnaList.jsp"></jsp:include>
<div class="footer">
		<p class="copyright">&copy;copy</p>
	</div>
</div>	
</body>
</html>