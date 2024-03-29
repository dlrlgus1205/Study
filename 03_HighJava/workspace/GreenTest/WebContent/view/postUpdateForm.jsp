<%@page import="member.vo.MemberVO"%>
<%@page import="post.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.title {
display : flex;
justify-content : center;
margin : 10rem auto;
padding : 0;
}
h2 { 
margin : 0 auto;
padding : 0;
font-size : 3rem;
}
table {
margin : 0 auto;
padding : 0;
border : 0;
border-collapse: collapse;
width : 75%;
}
td {
	width: 100%;
}
.table_key {
	width : 10%;
	text-align: center;
}
#table_title {
	width: 100%;
	margin : 20px 0;
}
#table_body {
	width : 100%;
	height : 300px;
	margin-bottom : 40px;
}
.btn{
    padding : 1rem 3rem;
	background-color: #568A35 !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
	color : #fff !important;
    transition: .3s;
    margin : 10px;
}

.btn:hover{
	background: #fff !important;
	color: #568a35 !important;
}
</style>
</head>
<body>
<%MemberVO mvo = (MemberVO)session.getAttribute("login"); 
	if(mvo!=null){%>
		<%@ include file = "/html/header_login.jsp" %>
	<%}else{%>
		<%@ include file = "/html/header_logout.jsp" %>
	<% }%>
	<br><br><br><br>
<%
	PostVO vo = (PostVO)request.getAttribute("post");
	
%>
<div class = "title">
	<h2>게시글 수정</h2>
</div>

<form action="<%=request.getContextPath() %>/postUpdate.do"
	method="post">
	<input type="hidden" name="post_no" value="<%=vo.getPost_no() %>">
	
	<table border="1">
	
	<tr>
		<td class = "table_key">게시글 제목</td>
		<td><input type="text" name="post_title" id = "table_title" value="<%=vo.getPost_title()%>"></td>
	</tr>
	
	<tr>
		<td class = "table_key">게시글 내용</td>
		<td><input type="text" name="post_content" id = "table_body" value="<%=vo.getPost_content()%>"></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" value="저장" class = "btn"> <input type="reset" value="취소" class = "btn">
			<tr>
	
	</table>
	
	
	
	
	</form>
	<br><br><br>
<%@ include file = "/html/footer.jsp" %>
</body>
</html>