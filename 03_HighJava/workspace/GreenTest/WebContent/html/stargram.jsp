<%@page import="img.vo.ImgVO"%>
<%@page import="post.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	List<PostVO> starList = (List<PostVO>)request.getAttribute("starList");
	ImgVO ImgVO = (ImgVO)request.getAttribute("ImgVO");
%>
<title>stargram</title>
<script type = "text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/stargram.css">
<script>
$(document).ready(function(){
	// 글 작성
	$("#w-btn").on('click', function(){
 		location.href="<%= request.getContextPath() %>/html/starWriter.jsp"
	})
	
	// 글 삭제
	$('.d-btn').on('click',function(){
		var postNo = $(this).attr('name');
		$.ajax({
			url : `<%=request.getContextPath()%>/starDelete.do`,
			type : 'get',
			data : {"post_no" : postNo},
			success : function(res){
				alert("삭제 완료");
				location.href="/GreenTest/starList.do?bono=<%=3%>";
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		})
	})
	
	// 좋아요
	$(".l-btn").on('click', function(){
		var postNo = $(this).attr('name');
		var memId = "c001";
<%-- 		var postNo = <%=list.getPost_no()%>; --%>
<%-- 		var memId  = '<%=list.getMem_id()%>'; --%>
		$.ajax({
			url : `<%=request.getContextPath()%>/starLike.do`,
			type : 'get',
			data : {
	            "post_no" : postNo,
	            "mem_id"  : memId
	        },
			success : function(res){
				
				if (res.result == 1) {
			        alert("좋아요 취소!");
			    } else if (res.result == 0) {
			        alert("좋아요 확인!");
			    }
				
				location.href="/GreenTest/starList.do?bono=<%=3%>";
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		})
	})
})
</script>
</head>
<body>
<%@ include file = "header_logout.jsp" %>
<button type = "button" id = "w-btn">글 쓰기</button>
<div class="wrap">
	<div class="swiper mySwiper">
		<div class="swiper-wrapper">
		<%
		for(PostVO starvo : starList){ 
		%>
			<div class = "gram-box swiper-slide">
				<div class = "l-box">
					<div class = "gram-content">
					<span class = "gram-nickname"><%=starvo.getMem_id() %></span>
					<button type = "button" name = "<%=starvo.getPost_no()%>" class = "d-btn">
						<span class="material-symbols-outlined">delete</span>
					</button>
						<img alt="img.?" src="<%=request.getContextPath()%>/images/spongebob.png">
						<span class = "gram-comment"><%=starvo.getPost_content() %></span>
						<div class = "l-btn-box">
							<button type = "button" name = "<%=starvo.getPost_no()%>" class = "l-btn">
							<span class="material-symbols-outlined">favorite</span>
							</button>
							<p><%=starvo.getTotal_likes() %></p>
						</div>
						<div class = "r-btn">
							<button type = "button" id = "r-btn">
							<span class="material-symbols-outlined">comment</span>
							</button>
							<p>6</p>
						</div>
					</div>
				</div>
				<div class = "r-box">
				    <div class = "gram-reply">
				    	<span id = "gram-reply">댓글</span>
				    	<span id = "gram-reply-count">6</span>
				    	<hr>
				        <span class = "reply-nickname">1등올챙이</span>
				        <span class = "reply-content">여기는 댓글이 들어올 자리지롱</span>
				        <hr>
				        <span class = "reply-nickname">2등올챙이</span>
				        <span class = "reply-content">여기는 댓글이 들어올 자리지롱</span>
				        <hr>
				        <span class = "reply-nickname">메이플</span>
				        <span class = "reply-content">여기는 댓글이 들어올 자리지롱</span>
				        <hr>
				        <span class = "reply-nickname">아이리스</span>
				        <span class = "reply-content">여기는 댓글이 들어올 자리지롱</span>
				        <hr>
				        <span class = "reply-nickname">3등올챙이</span>
				        <span class = "reply-content">여기는 댓글이 들어올 자리지롱</span>
				        <hr>
				        <span class = "reply-nickname">크크</span>
				        <span class = "reply-content">여기는 댓글이 들어올 자리지롱</span>
				        <hr>
				        <textarea name = "reply-box" cols = "20" rows = "3" id = "reply-box"></textarea>
				        <button type = "button" name = "reply-btn" class = "reply-btn">
				        <span class="material-symbols-outlined">edit</span>
				        </button>
				    </div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</div>
<%@ include file = "footer.jsp" %>
<script>
var swiper = new Swiper(".mySwiper", {
	direction: "vertical",
	slidesPerView: 1,
	spaceBetween: 0,
	speed: 800,
	mousewheel: true
});
    
$(".r-btn button").click(function(){
	$(".l-box").toggleClass('ac');
	$(".r-box").toggleClass('ac');
});
  </script>
</body>
</html>