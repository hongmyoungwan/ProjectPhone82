<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 body{
 	font:14px/1.8 Arial,Helvetica, sans-serif;
 }
 .frame{
 	width:1000px;
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
 	background:#5457de;
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
a:link { color: red; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: blue; text-decoration: underline;}
</style>

</head>
<body>
<div class="frame"><a href="">회원가입</a> &nbsp;&nbsp;&nbsp;<a href="">로그인</a>
<div class="header">
<div class="logo"><a href="home.html">Phone82</a> </div>
</div>
	<div class="container">
		<div class="nav">
		<ul class="nav-list">
			<li class="nav-item"><a href="PhoneListServlet" style="color:red">휴대폰 리스트</a></li>
			<li class="nav-item"><a href="ListServlet?phone_model_num=galaxy">갤럭시 제품만 보기</a></li>
			<li class="nav-item"><a href="ListServlet?phone_model_num=iphone">아이폰만 보기</a></li>
		</ul>
		</div>
		<div class="content">
		<jsp:include page="phone/updateForm.jsp"/>
		</div>
	</div>
	<div class="footer">
		<p class="copyright">&copy;copy</p>
	</div>
</div>

</body>
</html>