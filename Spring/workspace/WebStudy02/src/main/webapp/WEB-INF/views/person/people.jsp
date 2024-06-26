<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set value="${pageContext.request.contextPath }" var="cPath" scope="application" />
<form name = "personForm" action="${cPath }/people.do" method="post">
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
			<c:forEach items="${people }" var="once">
			<tr>
				<td>${once['id'] }</td>
				<td><a href = "javascript:;" onclick = "clickHandler(event)" data-member-id="${once['id'] }">${once['name'] }</a></td>
			</tr>
			</c:forEach>
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