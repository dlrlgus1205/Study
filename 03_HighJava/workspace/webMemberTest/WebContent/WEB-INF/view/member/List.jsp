<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
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
		padding : 5px;
	}
</style>
<script type = "text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$("#addBtn").on("click", function(){
		location.href = "<%=request.getContextPath()%>/memberInsert.do";
	});
});
</script>
</head>
<body>
<%
	List<MemberVo> memList = (List<MemberVo>)request.getAttribute("memberList");
%>
<h1>회원 목록 보기</h1>	
<table border = "1">
	<thead>
		<tr>
			<td colspan = "5" style = "text-align : right;">
				<input type = "button" id = "addBtn" value = "회원추가">
			</td>
		</tr>
		<tr>
			<th>ID</th>
			<th>비밀번호</th>
			<th>이 름</th>
			<th>전 화</th>
			<th>주 소</th>
		</tr>
	</thead>
	<tbody>
<%
	for(MemberVo memvo : memList){
%>
		<tr>
			<td><a href = "<%=request.getContextPath()%>/memberView.do?mem_id=<%=memvo.getMem_id()%>"><%=memvo.getMem_id() %></a></td>
			<td><%=memvo.getMem_pass() %></td>
			<td><%=memvo.getMem_name() %></td>
			<td><%=memvo.getMem_tel() %></td>
			<td><%=memvo.getMem_addr() %></td>
		</tr>
<%
	}
%>
	</tbody>	
</table>
</body>
</html>