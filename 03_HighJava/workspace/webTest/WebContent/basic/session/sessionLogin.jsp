<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// JSP 문서에서 세션은 'session'이라는 이름으로 이미 저장돼있다.
	
	// Session에 저장된 값 가져오기
	String LoginID = (String) session.getAttribute("LoginID"); 
%>

<%
	// 로그인이 안됐을 때
	if(LoginID == null){
%>
<h1>로그인 창</h1>
<form action = "<%=request.getContextPath()%>/sessionLogin.do" method = "post">
<table border = "1" style = "margin : 0 auto">
<tr>
<td>ID : </td>
<td><input type = "text" name = "userid" placeholder = "ID 입력하세요."></td>
</tr>
<tr>
<td>PASS : </td>
<td><input type = "text" name = "userpass" placeholder = "PassWord 입력하세요."></td>
</tr>
<tr>
<td colspan = "2" style = "text-align : center;"><input type = "submit" value = "Login"></td>
</tr>
</table>
</form>
<%
	}
	// 로그인이 됐을 때
	else{
%>
		<h2> <%=LoginID %> 님 반갑습니다 ...</h2><br><br>
		<a href = "<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>
<%
	}
%>			
</body>
</html>