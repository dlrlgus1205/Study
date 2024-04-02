<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = 5;
	String numParam = request.getParameter("num");
	
	if(numParam != null && !numParam.isEmpty()){
		try{
			num = Integer.parseInt(numParam);
			if(num < 1 || num > 10){
				num = 10;
			}
		} catch(NumberFormatException e){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
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
	int sigma(int num){
		int sumnum = 0;
		
		for(int i = 1; i <= num; i++){
			sumnum += i;
		}
		return sumnum;
	}
	
	int factorial(int num){
		int mulnum = 1;
		
		for(int i = 1; i <= num; i++){
			mulnum *= i;
		}
		return mulnum;
	}
	%>
	<form>
		<input type = "number" name = "num" min="1" max = "10"/>
		<button type = "submit">전송</button>
	</form>
	<h4>누적 합 : <%=sigma(num) %></h4>
	<h4>누적 곱 : <%=factorial(num) %></h4>
</body>
</html>