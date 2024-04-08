<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a class = "asyncA other" data-method = "post" href = "<%= request.getContextPath() %>/07/userAgent_sem.do">사용자 브라우저 식별(서버 사이드)</a>
<button id = "ua-btn">사용자 브라우저 식별(클라이언트 사이드)</button>
<!-- a 태그를 클릭하면, 비동기 요청을 발생시키고, 서버에서 사용자 브라우저를 식별하고, 식별 결과를 다음과 같은 메시지로 전송 "<h4>당신의 브라우저는 [엣지|웨일|크롬|사파리|기타] 입니다</h4>"
응답 메시지는 msgArea 의 하위 엘리먼트로 랜더링 -->
<div id = "msgArea">
</div>
<script type="text/javascript" src = "<%=request.getContextPath() %>/resources/js/app/07/userAgent_sem.js"></script>
</body>
</html>