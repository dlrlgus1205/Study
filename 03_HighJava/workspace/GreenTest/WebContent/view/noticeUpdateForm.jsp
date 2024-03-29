<%@page import="notice.vo.NoticeVO"%>
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
border-collapse: collapse;
width : 60%;
}
.table_key {
	width : 10%;
	text-align: center;
}
#table_title {
	width: 90%;
}
</style>
</head>
<body>
<%
	NoticeVO vo = (NoticeVO)request.getAttribute("notice");
	
%>
<div class = "title">
	<h2>공지사항 수정</h2>
</div>

<form action="<%=request.getContextPath() %>/noticeUpdate.do"
	method="post">
	<input type="hidden" name="notice_no" value="<%=vo.getNotice_no() %>">
	
	<table border="1">
	
	<tr>
		<td class = "table_key">공지사항 제목</td>
		<td><input type="text" name="notice_title" id = "table_title"value="<%=vo.getNotice_title()%>"></td>
	</tr>
	
	<tr>
		<td class = "table_key">공지사항 내용</td>
		<td><input type="text" name="notice_content" value="<%=vo.getNotice_content()%>"></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" value="저장"> <input type="reset" value="취소">
			<tr>
	
	</table>
	
	
	
	
	</form>

</body>
</html>