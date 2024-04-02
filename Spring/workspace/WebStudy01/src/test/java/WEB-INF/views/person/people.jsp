<%@page import="kr.or.ddit.vo.PersonVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name = "personForm" action="<%=request.getContextPath() %>/people.do" method="post">
	<input type = "text" name = "who"/>
</form>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<PersonVO> people = (List) request.getAttribute("people");
				for(PersonVO once : people){
					%>
					<tr>
						<td><%=once.getId() %></td>
						<td><a href = "javascript:;" onclick = "clickHandler(event)" data-member-id="<%=once.getId()%>"><%=once.getName() %></a></td>
					</tr>
					<%
				}
			%>
		</tbody>
	</table>
<script type="text/javascript">
	function clickHandler(event){
		event.preventDefault();
		let aTag = event.target;
		console.log(aTag.dataset.memberId);
		document.personForm.who.value = aTag.dataset.memberId;
		document.personForm.requestSubmit();
	}
</script>
</body>
</html>