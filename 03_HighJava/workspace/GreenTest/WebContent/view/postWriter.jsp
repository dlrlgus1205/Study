<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
.panel-heading {
	display : flex;
	margin: 150px 0 50px 0;
	justify-content: center;
}
h1 {
	font-size: 3rem;
}
.panel-body {
	width: 70%;
	margin : 0 auto;
}
.writer {

}
.form-control {
	font-size : 2rem !important;
}
label {
	margin-left : 1rem;
}
.text {
	height: 30rem;
}
.label {
	margin : 50px 0 20px 1rem;
}
#img {
	width : 30%;
	margin : 0 0 80px 0;
}
.w-btn{
	position: relative;
    left: 1060px;
    bottom: 20px;
    padding : 1rem 3rem;
	background-color: #568A35 !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
	color : #fff !important;
    transition: .3s;
}
.w-btn:hover{
	background: #fff !important;
	color: #568a35 !important;
}
.list{
	position: relative;
    left: 1080px;
    bottom: 20px;
    padding : 1rem 3rem;
	background-color: #568A35 !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
	color : #fff !important;
    transition: .3s;
}

.list:hover{
	background: #fff !important;
	color: #568a35 !important;
}

</style>
<script>
$(document).ready(function(){
	// 목록보기
	$("#list").on('click', function(){
 		location.href="<%=request.getContextPath()%>/postList.do"
	})
})
</script>
</head>
<body>
<%

MemberVO memberVo =  (MemberVO)session.getAttribute("login");

String mem_id = "";

if(memberVo!=null) {
	mem_id = memberVo.getMem_id();
}
%>

<%MemberVO mvo = (MemberVO)session.getAttribute("login"); 
	if(mvo!=null){%>
		<%@ include file = "../html/header_login.jsp" %>
	<%}else{%>
		<%@ include file = "../html/header_logout.jsp" %>
	<% }%>
<div class="panel-heading">
<h1>게시글 작성하기</h1>
</div>
	<div class="panel-body">
		<form method="post" action="<%=request.getContextPath()%>/postInsert.do" enctype="multipart/form-data">
			<select name="categoryno">
			<option value="2" >잡담</option>
			<option value="3" >팁</option>
			<option value="4" >문의</option>
			</select>
			<div class="form-group">
			
				<label>작성자</label> 
                	<input class="form-control writer" name="writer" value="<%=mem_id%>" readonly="readonly" >
			</div>
			<div class="form-group">
				<label class = "label">제목</label> 
                <input class="form-control" name="title">
			</div>
			<div class="form-group">
				<label class = "label">내용</label>
					<textarea class="form-control text" rows="3" name="content"></textarea>
			</div>
			
			<div class="form-group">
				<label class = "label">이미지첨부</label> 
                <input class="form-control" type="file" name="img_name" id = "img" multiple>
			</div>	
		
			<input type="submit" class="btn btn-default w-btn" value="글 작성">
			<button type="button" class="btn btn-default list">목록보기</button>
		</form>
	</div>
<%@ include file = "../html/footer.jsp" %>
</body>
</html>