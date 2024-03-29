<%@page import="member.vo.MemberVO"%>
<%@page import="post.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet"/>
<script type="text/javascript">

</script>
</head>
<%PostVO vo = (PostVO)request.getAttribute("PostVO");%>
<body>

<%MemberVO mvo = (MemberVO)session.getAttribute("login"); 
	if(mvo!=null){%>
		<%@ include file = "/html/header_login.jsp" %>
	<%}else{%>
		<%@ include file = "/html/header_logout.jsp" %>
	<% }%>
	<br><br><br><br><br><br>
<div class="row">
    <div class="col-lg-8 mb-4">
        <h3>수정 폼</h3>
        <form id="contactForm" name="sentMessage" novalidate
        method="POST" action="<%=request.getContextPath()%>/wikiUpdate.do?post_no=<%=vo.getPost_no()%>">
            <div class="control-group form-group">
                <div class="controls">
                    <label>제목</label>
                    <input class="form-control" id="title" name="title" type="email" 
                           required data-validation-required-message="이메일 주소를 입력 해주세요."
                           value="<%=vo.getPost_title()%>"/>
                </div>
            </div>
            <div class="control-group form-group">
                <div class="controls">
                    <label>내용 </label>
                    <textarea class="form-control" id="content" name="content" rows="10" cols="100" 
                              required data-validation-required-message="보내실 메시지 내용을 입력 해주세요." 
                              style="resize: none"><%=vo.getPost_content()%></textarea>
                </div>
            </div>
            <div id="success"></div>
            <!-- For success/fail messages-->
            <button class="btn btn-success" id="sendMessageButton" type="submit">수정하기</button>
        </form>
    </div>
</div>
<br><br><br>
<%@ include file = "/html/footer.jsp" %>


</body>
</html>