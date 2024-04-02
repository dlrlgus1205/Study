<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = 5;
	String numStr = request.getParameter("num");
	if(numStr != null && !numStr.isEmpty()){
		try{
			num = Integer.parseInt(numStr);
		}catch(NumberFormatException e){
			response.sendError(400, e.getMessage());
			return;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	long sigma(int num){
		if(num < 1 || num > 10)
			throw new IllegalArgumentException("1 ~ 10");
		if(num == 1)
			return 1;
		else
			return num + sigma(num - 1);
	}

	long factorial(int num){
		if(num < 1 || num > 10)
			throw new IllegalArgumentException("1 ~ 10");
		if(num == 1)
			return 1;
		else
			return num * factorial(num - 1);
	}
%>
	<form>
		<input type = "number" name = "num" min="1" max = "10" value = "<%=num %>"/>
		<button type = "submit">전송</button>
	</form>
	<%
	try{
	%>
	<h4>누적 합 : <%=sigma(num) %></h4>
	<h4>누적 곱 : <%=factorial(num) %></h4>
	<%
	}catch(IllegalArgumentException e){
		response.sendError(400, e.getMessage());
	}
	%>
</body>
</html>