<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		int max = 10;
		String maxParam = request.getParameter("max");
		if(maxParam != null && !maxParam.isEmpty()){
			try{
				max = Integer.parseInt(maxParam);
				if(max < 0){
					max = 10;
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
<style type="text/css">
.red{
	background-color: red;
}
.yellow{
	background-color: yellow;
}
.odd{
	background-color: red;
}
.even{
	background-color: yellow;
}
</style>
</head>
<body>
<%-- 	<ul>
		<% 
		for(int i = 1; i < 11; i++){
			if(i % 2 == 0){
		%>
		<li class = "red"><%=i %></li>
		<%
			}
			else{
		%>
		<li class = "yellow"><%=i %></li>
		<%
			}
		}
		%>
	</ul> --%>
	
	<%-- <ul>
		<%
		for(int i = 1; i < 11; i++){
			boolean odd = i % 2 == 1;
			String clzValue = odd ? "odd" : "even";
			%>
			<li class = "<%=clzValue %>"><%=i %></li>
			<%
		}
		%>
	</ul> --%>
	<a href = "?max=5">더미</a>
	<img src = ""/>
	<form>
	<input type = "number" name = "max" id = "max" value = "<%=max %>"/>
	<button type = "submit" id = "btn">li 출력</button>
	</form>
	<ul>
	<%!
	StringBuffer printNumber(int max){
		StringBuffer liTags = new StringBuffer();
		String liPtrn = "<li class = '%s' >%d</li>";
		
		if(max > 0){
			for(int i = 1; i <= max; i++){
				boolean odd = i % 2 == 1;
				String clzValue = odd ? "odd" : "even";
				liTags.append(String.format(liPtrn, clzValue, i));
			}
		}
		else if(max <= 0){
			for(int i = 1; i <= 10; i++){
				boolean odd = i % 2 == 1;
				String clzValue = odd ? "odd" : "even";
				liTags.append(String.format(liPtrn, clzValue, i));
			}
		}
		return liTags;
	}
	%>
	<%=printNumber(max) %>
	</ul>
</body>
</html>