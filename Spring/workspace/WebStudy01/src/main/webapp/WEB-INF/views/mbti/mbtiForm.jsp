<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MBTI</title>
    <%
		String mbtiCookie = (String) request.getAttribute("mbtiCookie");
		if(StringUtils.isNotBlank(mbtiCookie)){
			%>
			<script type="text/javascript">
				document.addEventListener("DOMContentLoaded", ()=>{
					window['mbti-form'].type.value = "<%=mbtiCookie%>";
					window['mbti-form'].requestSubmit();
				})
			</script>
			<%
		}
	%>
</head>
<body>
    <form id = "mbti-form" method = "post" enctype = "application/x-www-form-urlencoded">
        <select name="type" onchange = "this.form.requestSubmit()">
        	<%
        		Map<String, String> mbtiMap = (Map) application.getAttribute("mbtiMap");
        		for(Entry<String, String> entry : mbtiMap.entrySet()){
        	%>
            <option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
        	<%		
        		}
        	%>
        </select>
    </form>
    <div id = "mbti-area">
    </div>
<script src = "<%=request.getContextPath()%>/resources/js/app/mbti/mbtiForm.js">

</script>
</body>
</html>