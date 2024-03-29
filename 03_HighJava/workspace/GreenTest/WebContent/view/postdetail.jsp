<%@page import="member.vo.MemberVO"%>
<%@page import="reply.vo.ReplyVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="img.vo.ImgVO"%>
<%@page import="post.vo.PostVO"%>
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
	PostVO vo = (PostVO)request.getAttribute("post");
	
	
	 String ss = null;
	 
	 Gson gson = new Gson();
	 if(vo !=null) ss =gson.toJson(vo);
	 
	 
	 /* { "post_no" : 110   } */
	%>
	 function replyDelete(){
		 $(p_cotent).parents(".p-body").remove();
		 
		
	 }
	//modifycontent
	 function replyReset() {
		p_content = $("#modifyform").parent();
		
		$("body").append($("#modifyform"));
		$("#modifyform").hide();
		
		let replyno = sessionStorage.getItem("replyno");
		console.log("replyno : " + replyno);
		
		$("#spn"+replyno).css("display","block");
		
// 		$(p_content).html(reply_content);
	}
	 
	 function replyUpdate(){
		 //p_content = $("#modifyform").parent();
		//	replyNo =pvo.reply_no;
		 $.ajax({
			 url :"<%= request.getContextPath()%>/replyUpdate.do",
			 method : "POST",
			 data : {"replyno" : vidx, "replycontent" : modifycontent},
			 success : function(res){
				 //alert("성공");
				 reply_content.html(modiout);
				 
				 today= new Date();
				 today= today.toLocaleString()
				 vdate.html(today);
				 
			 },
			 error : function(xhr){
				 alert("상태 :" +xhr.status);
			 },
			 dataType : "JSON"
		 })
		 
	 }
	 
	 
	 function  replyList(){
			postNo =pvo.post_no;
			target = this;
			$.ajax({
				url :"<%= request.getContextPath()%>/replyList.do",
				method : "GET",
				data : {"postno" : pvo.post_no},
				success : function(res){
					console.log(res);
					//출력 
					parent = $(target).parents('.my4');
					
					rcode = "";
					$.each(res, function(i, v){
						cont = v.cont;
						
						rcode += `<div class = "reply-body">
									<div class = "p-body">
										<p class = "p-head">
											작성자 : <span>\${v.mem_name}</span><br>
											날짜 : <span class="sda">\${v.reply_write_date}<span><br>
											내  용 : 
											<p class = "p-content">
											<span id="spn\${v.reply_no}">\${v.reply_content}</span>
											</p><br>`
											rcode += `<input idx="\${v.reply_no}" type="button" value="댓글 수정" data-replyno="\${v.reply_no}" name = "r-modify" class="action action-first r_modify">
														<input idx="\${v.reply_no}" type="button" value="댓글 삭제" data-replyno="\${v.reply_no}" name = "r-delete" class="action r_delete">`
									
														
													rcode += `</p>
											</div>
								  </div><br> `
					});
					
					
					$("#replyView").html(rcode);
					
					
				},
				error : function(xhr){
					alert("상태 :" + xhr.status);
				},
				dataType : "JSON"
			})
			
		} 
	 reply={ };
	$(document).ready(function(){
		pvo = <%= ss%>;
		
		
		console.log("post_no ==============" , pvo.post_no);
		
		replyList();
		
		//댓글 삭제
		$(document).on("click",".r_delete", function(){
	    	let replyno= $(this).data("replyno");
	    	sessionStorage.setItem("replyno", replyno);
	    	
	    	console.log("replyno : " + replyno);
	    	
	    	//댓글 삭제
	    	$(this).parent().parent().next().remove();//br 삭제
	    	$(this).parent().parent().remove();
	    	
	    	 $.ajax({
				 url : "<%= request.getContextPath()%>/replyDelete.do",
				 method : "GET",
				 data : {"replyno" : replyno},
				 success :function(res){
					 alert("성공")
// 					 $(p_cotent).parents(".p-body").remove();
				 },
				 error : function(xhr){
					 alert("상태 :" + xhr.status)
				 },
				 dataType : "JSON"
				 
				 
			 });
	    });
		
<%-- 		mem_id = <%=%> --%>
		
		$('#resend').on('click', function(){
			
			  rcont = $('#replycontent').val();
			  rno = $('#replyno').val();
			 
			  
			  console.log(rcont, rno);
			  
			  $.ajax({
				   url : "<%=  request.getContextPath()%>/replyInsert.do",
				   method : "post",
				   data : {"replyno" : rno,  
					   "replycontent" : rcont
					   
				   },
				   success : function(res){
					 // replyList();
					  //alert("성공") 
					   //성공했으면 replyList.do를 실행 할 수 이쓴 함 수 
					  replyList();
				   },
				   error : function(xhr){
					   alert("상태:"+  xhr.satus);
				   },
				   dataType :"JSON"
			  })
			
		})
		
		
		
		
		$("#btnUpdate").on("click",function(){
			
			var postNo = pvo.post_no;
			
			location.href="<%=request.getContextPath()%>/postUpdate.do?post_no=" + postNo;
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
				var postNo =  pvo.post_no;
				location.href="<%=request.getContextPath()%>/postDelete.do?post_no=" + postNo;
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
				var postNo =  pvo.post_no;
				location.href="<%=request.getContextPath()%>/postList.do?post_no=" + postNo;
				var replyNo = $(this).attr("idx");
				name_attr = $(this).attr('name');
				
			})
			$(document).on("click", ".r_modify", function(){
				
				let replyno = $(this).data("replyno");
				//수정 대상 번호
			    sessionStorage.setItem("replyno",replyno);
				console.log("replyno : " + replyno);
				$("#spn"+replyno).css("display","none");
				
			    if($("#modifyform").css("display") != "none"){
			      
			    }
			    
			    //댓글 번호 필요 
			   vidx =  $(this).attr('idx');
			    
			    var reply_content = $(this).closest(".p-body").find(".p-content"); // 댓글을 쓰는 부눈 수정된 부분
			   
			
			    var modifycontent = $(reply_content).text().trim();//원본글
			    
			    var modifycontent_replace = modifycontent.replace(/<br>/g, "\n"); // 수정된 부분
			    
			    $("#modifyform textarea").val(modifycontent_replace);
			    $(reply_content).append($("#modifyform")); // 수정된 부분
			    $("#modifyform").show();
			});
			$("#btnok").on("click", function(){
				
				vdate = $(this).parents('.p-body').find('.sda')
				//수정 입력 한 댓글
				modifycontent = $(this).prev().val()
				//modifycontent =$("#modifyform textarea").val();
				
				modiout = modifycontent.replace(/\n/g, "<br>");
				
				reply_content= $("#modifyform").parent();
				
				$("#modifyform").appendTo($("body"));
				$("#modifyform").hide();
				
				//화면 수정 
				//reply_content.html(modiout);
				
				//db 수정 - 수정 성공했을때 화면 수정 
				replyUpdate();
		
			})
			$("#btnreset").on("click", function(){
				replyReset();
				
			});
			
			
			
		
	})

</script>

<style>
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
	width: 75%;
	margin: 0 auto;
}

.col-lg-8 {
	max-width: 100% !important;
}

#title {
	padding-left: 1rem;
}

.lead {
	height: 300px;
}

#title {
	font-weight: bold;
	font-size: 1.8rem !important;
}

.ud-btn {
	display: flex;
	justify-content: flex-end;
	align-items: center;
	padding-right: 1rem;
}

.ud-btn button {
	margin-left: 0.5rem;
}

#resend{
    padding : 1rem 3rem;
	background-color: #568A35 !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
	color : #fff !important;
    transition: .3s;
}

#resend:hover{
	background: #fff !important;
	color: #568a35 !important;
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

#btnok{
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

#btnok:hover{
	background-color: #568A35 !important;
	color : #fff !important;
}

#btnreset{
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

#btnreset:hover{
	background-color: #568A35 !important;
	color : #fff !important;
}

.r_modify{
	margin-left : 5px;
    padding : 0.5rem;
	background: #fff !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
	font-size: 1.3rem;
	color: #568a35 !important;
    transition: .3s;
}

.r_modify:hover{
	background-color: #568A35 !important;
	color : #fff !important;
}

.r_delete{
	margin-left : 5px;
    padding : 0.5rem;
	background: #fff !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
	font-size: 1.3rem;
	color: #568a35 !important;
    transition: .3s;
}

.r_delete:hover{
	background-color: #568A35 !important;
	color : #fff !important;
}

.action-first {
	margin-left: 100px;
}

#modifyform {
	display: none;
}
#replycontent {
	font-size : 1.5rem;
}
body{
	overflow: visible;
	position: static;
}
section {
	height: 90%;
}
</style>
</head>

<body>
<%MemberVO mvo = (MemberVO)session.getAttribute("login"); 
	if(mvo!=null){%>
		<%@ include file = "/html/header_login.jsp" %>
	<%}else{%>
		<%@ include file = "/html/header_logout.jsp" %>
	<% }%>

	<div id="modifyform">
		<textarea rows="5" cols="40"></textarea>
		<input type="button" value="확인" id="btnok"> <input
			type="button" value="취소" id="btnreset">
	</div>

	<a href="<%=request.getContextPath()%>/view/post.jsp"></a>

	<section class="py-5">


		<div class="pp">
			<div class="center">
				<!-- Post Content Column-->
				<div class="col-lg-8">
					<!-- Date/Time-->
					<hr class="hr1">
					<span id="title"><%=vo.getPost_title()%></span>
					<hr class="hr2">
					<div class="wdc">
						<span class="writer">작성자 : <%=vo.getMem_id()%></span> <span
							class="date">등록일 : <%=vo.getPost_write_date()%></span> <span
							class="count">조회수 : <%=vo.getPost_count()%></span>
					</div>
					<hr class="hr2">

					<!-- 내용-->
					<div class="ud-btn">
						<input id="btnUpdate" type="button" value="수정"> <input
							id="btnDelete" type="button" value="삭제"> <input
							type="button" id="btnList" value="게시글 목록">
					</div>
					<p>


						<%
							List<ImgVO> imgList = vo.getImgList();
								for(ImgVO imgvo : imgList){
						%>
						<img
							src="<%=request.getContextPath()%>/images/imageView.do?imgno=<%=imgvo.getImg_no()%>"
							style="width: 400px;"><br>
						<%
						}
						%>
						<%=vo.getPost_title()%>
					</p>

					<hr />
					<!-- Comments Form-->
					<div class="card my-4">
						<h5 class="card-header">댓글</h5>
						<div class="card-content" id="replyView"></div>

						<div class="card-body">
							<form>
								<div class="form-group">
									<input type="hidden" id="replyno" name="replyno"
										value="<%=vo.getPost_no()%>">
									<textarea name="replycontent" id="replycontent"
										class="form-control" rows="3" placeholder="댓글을 달아주세요!"></textarea>
								</div>
								<button class="btn btn-primary" id="resend" type="button">댓글작성</button>
							</form>
						</div>
					</div>
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
<%@ include file = "/html/footer.jsp" %>
</body>
</html>