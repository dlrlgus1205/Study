<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.folder{
		text-decoration: underline;
		color: blue;
	}
</style>
</head>
<body>
<ul>
	<c:forEach var="list" items="${fileList}">
		<c:set var="entry" value="${list.file}"></c:set>
		<li id="${entry.path}" class="${entry['file'] ? 'file' : 'folder'}"> ${entry['name'] } </li>
	</c:forEach>
</ul>
<ul>
	<c:forEach var="map" items="${fileMap}">
		<c:set var="entry" value="${map['value'] }"></c:set>
		<li id="${map['key']}" class="${entry['file'] ? 'file' : 'folder'}"> ${entry['name'] } </li>
	</c:forEach>
</ul>
<script type="text/javascript">
// 선택지 모두 선택
let folder = document.querySelectorAll('.folder');
// 배열로 저장되기 때문에 forEach로 하나씩 이벤트 등록
folder.forEach((fold) => {
	fold.addEventListener("dblclick", e => {
		let target = e.target;
		location.href = "?base=" + target.id
	})
})

</script>
</body>
</html>