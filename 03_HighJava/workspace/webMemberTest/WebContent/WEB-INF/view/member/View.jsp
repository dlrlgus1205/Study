<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"/>
<title>Insert title here</title>
<style>
	h1 {
		text-align : center;
	}
	table{
		margin : 0 auto;
		border : 1px solid black;
		border-collapse : collapse;
	}
	td {
		padding:5px;
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$("#btnUpdate").on("click", function(){
		var form = document.getElementById("memberForm");
		form.method = "GET";
		form.action = "<%=request.getContextPath()%>/memberUpdate.do";
		form.submit();
	});
	
	$("#btnDelete").on("click", function(){
		var form = document.getElementById("memberForm");
		form.action = "<%=request.getContextPath()%>/memberDelete.do";
		form.submit();
	});
	
	$("#btnList").on("click", function(){
		location.href = "<%=request.getContextPath()%>/memberList.do";
	});
});
</script>
</head>
<body>

<% 	MemberVo memVo = (MemberVo)request.getAttribute("memberVo"); %>

<h1>회원 정보 상세보기</h1>
<form name = "memberForm" id = "memberForm" >
	<input type = "hidden" id = "mem_id" name = "mem_id" value = "<%=memVo.getMem_id()%>">
<table border = "1">
<tbody>
	<tr>
		<td colspan = "2" style = "text-align : center;">
			<img src = "<%=request.getContextPath() %>/images/imageView.do?memID=<%=memVo.getMem_id() %>" width = "200" height = "140">
		</td>
	</tr>
	<tr>
		<td>회원ID</td>
		<td><%=memVo.getMem_id()%></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=memVo.getMem_pass()%></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><%=memVo.getMem_name()%></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><%=memVo.getMem_tel()%></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><%=memVo.getMem_addr()%></td>
	</tr>
	<tr>
		<td colspan = "2" style = "text-align : center;">
			<input id = "btnUpdate" type = "button" value = "수정"> 
			<input id = "btnDelete" type = "button" value = "삭제"> 
			<input type = "button" id = "btnList" value = "회원목록">
		</td>
	</tr>
</tbody>
</table>
</form>
</body>
</html>