<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includee/preScript.jsp"></jsp:include>
<style type="text/css">
	tr[data-mem-id]{
		cursor : pointer;
	}
	tr[data-mem-id]:hover{
		background-color : yellow;
	}
</style>
</head>
<body data-url="${pageContext.request.contextPath }">
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-scrollable">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>
<table class = "table table-bordered table-striped" border = "1">
	<thead class = "table-dark">
		<tr>
			<th>이름</th>
			<th>휴대폰</th>
			<th>주소1</th>
			<th>주소2</th>
			<th>이메일</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty memberList }">
			<c:forEach var="list" items="${memberList }">
				<tr data-mem-id="${list.memId }" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
					<td>${list.memName }</td>		
					<td>${list.memHp }</td>		
					<td>${list.memAdd1 }</td>		
					<td>${list.memAdd2 }</td>		
					<td>${list.memMail }</td>		
					<td>${list.memMileage }</td>		
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty memberList }">
			<tr>
				<td colspan = "6">회원 정보 없음</td>
			</tr>
		</c:if>
	</tbody>
</table>
<jsp:include page="/WEB-INF/includee/postScript.jsp"></jsp:include>
<script type="text/javascript" src = "<c:url value = '/resources/js/app/member/memberList.js' />">
</script>
</body>
</html>