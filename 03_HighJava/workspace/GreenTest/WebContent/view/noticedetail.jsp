<%@page import="member.vo.MemberVO"%>
<%@page import="notice.vo.NoticeVO"%>
<%@page import="reply.vo.ReplyVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="img.vo.ImgVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"
	crossorigin="anonymous"></script>
<link href="<%=request.getContextPath()%>/css/styles.css"
	rel="stylesheet" />



<script type="text/javascript">
	
	
	
	<%
	NoticeVO vo = (NoticeVO)request.getAttribute("notice");
	System.out.println(vo);
	
	 String ss = null;
	 
	 Gson gson = new Gson();
	 if(vo !=null) ss =gson.toJson(vo);
	 
	 
	 /* { "post_no" : 110   } */
	%>
	
		
	$(document).ready(function(){
			
		nvo = <%=ss%>
		
		$("#btnUpdate").on("click",function(){
			
			var noticeNo = nvo.notice_no;
			
			location.href="<%=request.getContextPath()%>/noticeUpdate.do?notice_no=" + noticeNo;
			<%-- $.ajax({
				url : `<%=request.getContextPath()%>/postUpdate.do`,
				type : "GET",
				data : {"post_no" : postNo, "post_title" : postTitle, "post_content" : postContent},
				
				success : function(res){
					alert("수정이 완료 됐습니다");
					location.href="/GreenTest/postList.do";
				},
				error : function(xhr){
					alert("상태 :" + xhr.status);
				},
				dataType : "JSON"
				
			}) --%>
		})
			$("#btnDelete").on("click", function(){
				var noticeNo =  nvo.notice_no;
				location.href="<%=request.getContextPath()%>/noticeDelete.do?notice_no=" + noticeNo;
				<%-- $.ajax({
					url:`<%=request.getContextPath()%>/postDelete.do`,
					type : "GET",
					data : {"post_no" : postNo},
					success : function(res){
						alert("삭제가 완료 됐습니다");
						location.href="/GreenTest/postList.do";
					},
					error : function(xhr){
						alert("상태:" + xhr.status);
						
					},
					dataType : "JSON"
				})--%>
			}) 
			$("#btnList").on("click", function(){
				var noticeNo =  nvo.notice_no;
				location.href="<%=request.getContextPath()%>/noticeList.do?notice_no=" + noticeNo;
				var replyNo = $(this).attr("idx");
				name_attr = $(this).attr('name');
				
			})
		
			


	})
</script>

<style>
body{
overflow: visible;
position: static;
height: auto;
}
hr {
	margin: 0.5rem;
}

p {
	margin: 0;
	padding-left: 1rem;
}

.hr1 {
	border: 0;
	height: 2px;
	background: black;
}

.wdc {
	padding: 0 1rem;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.hr2 {
	border: 0;
	height: 1px;
	background: #ccc;
}


.center {
	width: 70%;
	margin: 0 auto;
}

.col-lg-8 {
	max-width: 100% !important;
}

#title {
	padding-left: 1rem;
	font-weight: bold;
	font-size: 1.5rem;
}

.ud-btn {
	display: flex;
	justify-content: flex-end;
	align-items: center;
	padding-right: 1rem;
	margin : 20px 0 40px 0;
}

.ud-btn button {
	margin-left: 0.5rem;
}

.action-first {
	margin-left: 100px;
}

#modifyform {
	display: none;
}

#btnUpdate{
    padding : 0.5rem 1rem;
	background: #fff !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
	font-size: 1.3rem;
	color: #568a35 !important;
    transition: .3s;
}

#btnUpdate:hover{
	background-color: #568A35 !important;
	color : #fff !important;
}

#btnDelete{
	margin-left : 5px;
    padding : 0.5rem 1rem;
	background: #fff !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
	font-size: 1.3rem;
	color: #568a35 !important;
    transition: .3s;
}

#btnDelete:hover{
	background-color: #568A35 !important;
	color : #fff !important;
}

#btnList{
	margin-left : 5px;
    padding : 0.5rem 1rem;
	background: #fff !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
 	font-size: 1.3rem;
	color: #568a35 !important;
    transition: .3s;
}

#btnList:hover{
	background-color: #568A35 !important;
	color : #fff !important;
}
</style>
</head>

<body>
<%MemberVO mvo = (MemberVO)session.getAttribute("login"); 
	if(mvo!=null){%>
		<%@ include file = "../html/header_login.jsp" %>
	<%}else{%>
		<%@ include file = "../html/header_logout.jsp" %>
	<% }%>
	<div id="modifyform">
		<textarea rows="5" cols="40"></textarea>
		<input type="button" value="확인" id="btnok"> <input
			type="button" value="취소" id="btnreset">
	</div>

	<a href="<%=request.getContextPath()%>/view/notice.jsp"></a>

	<section class="py-5">


		<div class="pp">
			<div class="center">
				<!-- Post Content Column-->
				<div class="col-lg-8">
					<!-- Date/Time-->
					<hr class="hr1">
					<span id="title">제목:<%=vo.getNotice_title()%></span>
					<hr class="hr2">
					<div class="wdc">
						<span class="writer">작성자 : <%=vo.getAdmin_id()%></span> 
						<span class="date">등록일 : <%=vo.getNotice_date()%></span> 
						
					</div>
					<hr class="hr2">

					<!-- 내용-->
					<div class="ud-btn">
						<input id="btnUpdate" type="button" value="수정"> 
						<input id="btnDelete" type="button" value="삭제"> 
						<input type="button" id="btnList" value="게시글 목록">
					</div>
					<p>


					<%-- 	<%
							List<ImgVO> imgList = vo.getImgList();
								for(ImgVO imgvo : imgList){
						%>
						<img
							src="<%=request.getContextPath()%>/images/imageView.do?imgno=<%=imgvo.getImg_no()%>"
							style="width: 400px;"><br>
						<%
						}
						%> --%>
						<%=vo.getNotice_content()%>
					</p>

					<hr />
					<!-- Comments Form-->
					
					<!-- Single Comment-->
					<!-- Comment with nested comments-->
					<div class="media mb-4"></div>
				</div>
			</div>
		</div>
	</section>
	<!-- Bootstrap core JS-->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
<%@ include file = "../html/footer.jsp" %>
</body>
</html>