<%@page import="member.vo.MemberVO"%>
<%@page import="img.vo.ImgVO"%>
<%@page import="post.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<!-- 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

<title>Modern Business - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
<style>
#icon1{
	width: 25px;
	height: 25px;
	margin: 8px 8px 8px 20px;
}
#icon2{
	width: 25px;
	height: 25px;
	margin: 8px 8px 8px 10px;
} 
span{
	color : black;
	font : bold;
}
#image{
	 width: 100%;
     height: 100%;
     object-fit: contain;
}
#dubogi{
	font-size: 0.9rem;
	text-align: right;
}
a{
	font-size : 2rem;
	color : black;
}
.dubogi{
	display: flex;
	align-items: center;
}
#dubogi2 {
	padding-left: 80px;
}
.dubogi-a {
	font-size : 1.5rem;
}
.noto-sans-kr {
  font-family: "Noto Sans KR", sans-serif;
}
</style>
</head>
<%List<PostVO> list = (List<PostVO>)request.getAttribute("list");%>
<%ImgVO ImgVO = (ImgVO)request.getAttribute("ImgVO");%>
    <body>
    
    <%MemberVO mvo = (MemberVO)session.getAttribute("login"); 
	if(mvo!=null){%>
		<%@ include file = "/html/header_login.jsp" %>
	<%}else{%>
		<%@ include file = "/html/header_logout.jsp" %>
	<% }%>
        <!-- Page Content-->
        <section class="py-5">
            <div class="container">
                <div class="row">
<%
for(PostVO vo : list){
	
String title = vo.getPost_title();
String content = vo.getPost_content();
int maxLength1 = 12; // 최대 길이 설정 
int maxLength2 = 27; // 최대 길이 설정

if(title.length() > maxLength1) {
	title = title.substring(0, maxLength1) + "...";
}

if(content.length() > maxLength2) {
    content = content.substring(0, maxLength2) + "...";
}
%>
<div class="col-lg-3 col-md-4 col-sm-6 mb-4">
    <div class="card h-100 noto-sans-kr">
        <a href="<%=request.getContextPath()%>/wikiDetail.do?post_no=<%=vo.getPost_no()%>">
        <img class="card-img-top" id="image"
             src="<%=request.getContextPath()%>/img/sumView.do?post_no=<%=vo.getPost_no()%>"
             alt="이미지가 없습니다...." width="150" height="50"
             onerror="this.onerror=null; this.src='https://via.placeholder.com/700x400';"/>
        </a>
        <div class="card-body">
            <h5 class="card-title">
            <a href="<%=request.getContextPath()%>/wikiDetail.do?post_no=<%=vo.getPost_no()%>">
            <span><%=title%></span></a></h5>
            <p class="card-text"><%=content%></p>
        </div>
        <div class = "dubogi">
        <img id="icon1" alt="하트.png" src="<%=request.getContextPath()%>/images/하트.png"><%=vo.getTotal_likes()%>&nbsp;
        <img id="icon2" alt="말풍선.png" src="<%=request.getContextPath()%>/images/말풍선.png">0&nbsp;
        <div id="dubogi2"><span id="dubogi">
        <a href="<%=request.getContextPath()%>/wikiDetail.do?post_no=<%=vo.getPost_no()%>" class = "dubogi-a">more»</a></span></div></div>
    </div>
</div>
<%
}
%>

   </div>
                <!-- Pagination-->
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">«</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#!">1</a></li>
                    <li class="page-item"><a class="page-link" href="#!">2</a></li>
                    <li class="page-item"><a class="page-link" href="#!">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">»</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </div>
        </section>
        <!-- Bootstrap core JS-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <%@ include file = "../html/footer.jsp" %>
    </body>
</html>
