<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4> Principal : ${pageContext.request.userPrincipal }</h4>
<c:set value="${pageContext.request.userPrincipal }" var="principal"></c:set>
<c:choose>
	<c:when test="${not empty principal}">
		<c:set value="${principal.realUser }" var="authMember" />
		<h4>${authMember.memName}님 반갑다람쥐</h4>
		<a href = "<c:url value = '/mypage' />">${authMember.memName}[${authMember.memRole}]</a>
		<form id = "logoutForm" method="post"></form>
		<a href = "<c:url value = '/login/logout.do' />" class="logoutBtn" data-target-form="#logoutForm">로그아웃</a>
		<script type="text/javascript">
			let btn = document.querySelector("a[data-target-form]");
			btn.addEventListener("click", e => {
				e.preventDefault();
				let aTag = e.target;
				let formSelector = aTag.dataset.targetForm;
				let formTag = document.querySelector(formSelector);
				if(formTag){
					formTag.action = aTag.href;
					formTag.requestSubmit();
				}
			})
		</script>
	</c:when>
	<c:otherwise>
		<a href = "<c:url value = '/login/loginForm.jsp' />">로그인</a>
		<a href = "<c:url value = '/member/memberInsert.do' />">가입</a>
	</c:otherwise>
</c:choose>
<!-- 로그인 여부(authMember) 판단 -->
<!-- 로그인 된 경우 > 해당 사용자의 이름 출력 -->
<!-- 로그인 안된 경우 > 로그인 페이지로 이동할 수 있는 a 태그 출력 -->