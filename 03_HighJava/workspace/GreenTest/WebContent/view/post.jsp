<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="post.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>자유게시판</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  <!-- <script src="../js/jquery-3.7.1.min.js"></script> -->
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
  <style>
  .navbar-toggler{
  width : 200px;
  }
  #btn1{
	position: absolute;
    left: 1490px;
    padding : 1rem 3rem;
	background-color: #568A35 !important;
	border-radius : 10px;
    border: 1px solid #568A35 !important;
	opacity : 0.8;
	font-weight : 700 !important;
	color : #fff !important;
    transition: .3s;
}

#btn1:hover{
	background: #fff !important;
	color: #568a35 !important;
}

.paging {
	margin-top : 70px;
}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  $.ajax({
	      // location.href = "<%=request.getContextPath()%>/postList.do"
	      url: "<%=request.getContextPath()%>/postList.do", // 올바른 AJAX 요청을 위해 url 속성을 사용하세요.
	      method: "GET", // 요청 메소드를 지정합니다. 이 예제에서는 GET을 사용하였습니다.
	      success: function(response) {
	          console.log("AJAX 요청 성공:", response); // AJAX 요청이 성공할 때 실행되는 콜백 함수입니다.
	      },
	      error: function(xhr, status, error) {
	          console.error("AJAX 요청 실패:", error); // AJAX 요청이 실패할 때 실행되는 콜백 함수입니다.
	      }
	  });
	  $('#btn1').on('click', function(){
			
			location.href="<%= request.getContextPath() %>/view/postWriter.jsp"
			})
	
	});
  </script>
</head>
<body>
<%MemberVO mvo = (MemberVO)session.getAttribute("login"); 
	if(mvo!=null){%>
		<%@ include file = "/html/header_login.jsp" %>
	<%}else{%>
		<%@ include file = "/html/header_logout.jsp" %>
	<% }%>
	<br><br><br><br><br><br><br>
<%
	List<PostVO> postList = (List<PostVO>)request.getAttribute("postList");
	System.out.print("postList =======>" + postList);
%>



<div class="container-fluid mt-3">
 
 
 
</div>
	<div class="container">
	
	<nav class="navbar navbar-expand-sm bg-light">
  <div class="container-fluid">
  
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
         <li class="nav-item">
    <a class="nav-link active" data-bs-toggle="tab" href="#home">잡담</a>
  </li>
           <li class="nav-item">
    <a class="nav-link active" data-bs-toggle="tab" href="#home">팁</a>
  </li>
          <li class="nav-item">
    <a class="nav-link active" data-bs-toggle="tab" href="#home">질문</a>
  </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="Search">
        <button type="button" class="btn btn-success">Search</button>
      </form>
    </div>
  </div>
</nav>
	
	
	
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회</th>
				</tr>
			</thead>

			<tbody>

<%

	for(PostVO postvo : postList){
%>
		<tr>
			<td ><%=postvo.getPost_no() %></td>
			<td ><a href="<%=request.getContextPath()%>/postdetail.do?no=<%=postvo.getPost_no() %>"><%=postvo.getPost_title() %></a></td>
			<td><%=postvo.getMem_id() %></td>
			<td><%=postvo.getPost_write_date() %></td>
			<td><%=postvo.getPost_count() %></td>
		</tr>
<%
	}
%>  
			</tbody>
		</table>

		<hr/>
		<button type="button" class="btn btn-success" style="float:right;" id="btn1">글쓰기</button>


		<ul class="pagination justify-content-center paging">
  
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">4</a></li>
    <li class="page-item"><a class="page-link" href="#">5</a></li>
    <li class="page-item"><a class="page-link" href="#">6</a></li>
    <li class="page-item"><a class="page-link" href="#">7</a></li>
    <li class="page-item"><a class="page-link" href="#">8</a></li>
    <li class="page-item"><a class="page-link" href="#">9</a></li>
    <li class="page-item"><a class="page-link" href="#">10</a></li>
    <li class="page-item"><a class="page-link" href="#">11</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>





	
	<script src="./js/jquery-3.1.1.js"></script>
	<script src="js/bootstrap.js"></script>



<br><br><br>
<%@ include file = "/html/footer.jsp" %>
</body>
</html>