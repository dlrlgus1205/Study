<%@page import="member.vo.MemberVO"%>
<%@page import="img.vo.ImgVO"%>
<%@page import="post.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<%PostVO list = (PostVO)request.getAttribute("list");%>

<title><%=list.getPost_title()%></title>

<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>

<link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
 <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//삭제기능
	$('#btn2').on('click',function(){
		var postNo = <%=list.getPost_no()%>;
		$.ajax({
			url : `<%=request.getContextPath()%>/wikiDelete.do`,
			type : 'get',
			data : {"post_no" : postNo},
			success : function(res){
				alert("삭제가 완료되었습니다.");
				location.href="/GreenTest/wikiList.do";
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		})
	})
	
	//좋아요기능
	$('#btn3').on('click',function(){
		var postNo = <%=list.getPost_no()%>;
		var memId  = '<%=list.getMem_id()%>';
		$.ajax({
			url : `<%=request.getContextPath()%>/wikiLike.do`,
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
				
				location.href="/GreenTest/wikiList.do";
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		})
	})
	
	//수정기능
	var contextPath = '<%= request.getContextPath() %>';
    var postNo1 = '<%= list.getPost_no() %>';
    
	$('#btn1').on('click',function(){
		location.href = contextPath + "/wikiUpdate.do?post_no=" + postNo1;
	})
	
	
	$('#return').on('click',function(){
		location.href = contextPath + "/wikiList.do";
	})
	
})
</script>
<style>
.py-5 {
	width: 75%;
	margin: 0 auto;
}
hr{
	margin: 0.5rem;
}
p {
	margin : 0;
	padding-left : 1rem;
}

.hr1{
	border: 0;
    height: 2px;
    background: black;
}
.wdc{
	padding: 0 1rem;
	display: flex;
	justify-content : space-between;
	align-items: center;
}
.hr2{
	border: 0;
    height: 1px;
    background: #ccc;
}
/* .pp{ */
/* 	position: relative; */
/* } */
.center{
/* 	position: absolute; */
	width: 100%;
}
.col-lg-8{
	max-width: 100% !important;
}
#title {
	font-size : 1.8rem !important;
	padding-left: 1rem;
}
.lead {
	height: 300px;
}
#title{
	font-weight: bold;
	font-size: 1.1rem;
}
.ud-btn{
	display: flex;
	justify-content: flex-end;
	align-items: center;
	padding-right: 1rem;
}
.ud-btn button{
	margin-left: 0.5rem;
}

body {
 overflow: visible;
 position: static;
}
section{
  height : 90%;
}
</style>

</head>
    <body>
     <%MemberVO vo = (MemberVO)session.getAttribute("login"); 
	if(vo!=null){%>
		<%@ include file = "/html/header_login.jsp" %>
	<%}else{%>
		<%@ include file = "/html/header_logout.jsp" %>
	<% }%>
	
        
        <!-- Page Content-->
        <section class="py-5">
        	<div class="pp">
               <div class="center">
                    <!-- Post Content Column-->
                    <div class="col-lg-8">
                        <!-- Date/Time-->
                        <hr class="hr1">
                        <span id="title"><%=list.getPost_title()%></span>
                        <hr class="hr2">
                        <div class = "wdc">
	                        <span class = "writer">작성자 : <%=list.getMem_id()%></span>
	                        <span class = "date">등록일 : <%=list.getPost_write_date()%></span>
	                        <span class = "count">조회수 : <%=list.getPost_count()%></span>
                        </div>
                        <hr class="hr2">
                        
                        <!-- 내용-->
                        <div class = "ud-btn">
	                        <button type = "button" class="btn btn-success btn-sm" id="btn3">좋아요</button>
	                        <button type = "button" class="btn btn-success btn-sm" id="btn1">수정</button>
	                        <button type = "button" class="btn btn-success btn-sm" id="btn2">삭제</button>
                        </div>
                        <p>
                        <%=list.getPost_content().replaceAll("\n", "<br>")%>
                        </p>
                        
                        <hr />
                        <!-- Comments Form-->
                        <div class="card my-4">
                            <h5 class="card-header">댓글</h5>
                            <div class="card-body">
                                <form>
                                    <div class="form-group"><textarea class="form-control" rows="3"></textarea></div>
                                    <button class="btn btn-success" type="submit">작성</button>
                                </form>
                            </div>
                        </div>
                        <!-- Single Comment-->
                        <!-- Comment with nested comments-->
                        <div class="media mb-4">
                        </div>
                    </div>
        <div class="col-lg-8">
        <input class="btn btn-success btn-sm" type="button" id="return" value="목록">
        </div>
      </div>
      </div>
    </section>
        <%@ include file = "/html/footer.jsp" %>
    </body>
    
</html>

