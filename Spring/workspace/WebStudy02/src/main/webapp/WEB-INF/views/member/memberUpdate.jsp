<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includee/preScript.jsp"/>
</head>
<body>
<form method="post" enctype="application/x-www-form-urlencoded">
		<table class="table table-bordered">
			<tr>
				<th>암호</th>
				<td><input type="text" name="memId" value="${mem.memId}" class="form-control"  readonly/></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="memPass" class="form-control" /></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td><input type="text" name="memName" value="${mem.memName}" class="form-control" /></td>
			</tr>
			<tr>
				<th>앞자리 주민번호</th>
				<td><input type="text" name="memRegno1" value="${mem.memRegno1}" class="form-control" /></td>
			</tr>
			<tr>
				<th>뒷자리 주민번호</th>
				<td><input type="text" name="memRegno2" value="${mem.memRegno2}" class="form-control" /></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="memBir" value="${mem.memBir}"class="form-control" /></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="text" name="memZip" value="${mem.memZip}" class="form-control" /></td>
			</tr>
			<tr>
				<th>기본주소</th>
				<td><input type="text" name="memAdd1" value="${mem.memAdd1}" class="form-control" /></td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td><input type="text" name="memAdd2" value="${mem.memAdd2}" class="form-control" /></td>
			</tr>
			<tr>
				<th>집전화</th>
				<td><input type="text" name="memHometel" value="${mem.memHometel}" class="form-control" /></td>
			</tr>
			<tr>
				<th>회사전화</th>
				<td><input type="text" name="memComtel" value="${mem.memComtel}" class="form-control" /></td>
			</tr>
			<tr>
				<th>핸드폰번호</th>
				<td><input type="text" name="memHp" value="${mem.memHp}" class="form-control" /></td>
			</tr>
			<tr>
				<th>메일주소</th>
				<td><input type="text" name="memMail" value="${mem.memMail}" class="form-control" /></td>
			</tr>
			<tr>
				<th>직업</th>
				<td><input type="text" name="memJob" value="${mem.memJob}" class="form-control" /></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><input type="text" name="memLike" value="${mem.memLike}" class="form-control" /></td>
			</tr>
			<tr>
				<th>기념일 종류</th>
				<td><input type="text" name="memMemorial" value="${mem.memMemorial}" class="form-control" /></td>
			</tr>
			<tr>
				<th>기념일자</th>
				<td><input type="date" name="memMemorialday" value="${mem.memMemorialday}" class="form-control" /></td>
			</tr>
			<tr>
				<th>마일리지</th>
				<td><input type="number" name="memMileage" value="${mem.memMileage}" class="form-control" /></td>
			</tr>
			<tr>
				<th>상태코드</th>
				<td><input type="text" name="memDelete" value="${mem.memDelete}" class="form-control" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">저장</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
<jsp:include page="/WEB-INF/includee/postScript.jsp"/>
</body>
</html>