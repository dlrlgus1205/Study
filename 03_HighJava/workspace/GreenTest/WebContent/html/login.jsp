<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta http-equiv="imagetoolbar" content="no">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="format-detection" content="telephone=no">
  <meta name="title" content="웹사이트">
  <meta name="description" content="웹사이트입니다.">
  <meta name="keywords" content="키워드,키워드,키워드">
  <meta property="og:title" content="웹사이트">
  <meta property="og:description" content="웹사이트입니다">
  <meta property="og:image" content="https://웹사이트/images/opengraph.png">
  <meta property="og:url" content="https://웹사이트">
  <title>로그인</title>
  <link rel="stylesheet" href="../resources/css/setting.css">
  <link rel="stylesheet" href="../resources/css/plugin.css">
  <link rel="stylesheet" href="../resources/css/template.css">
  <link rel="stylesheet" href="../resources/css/common.css">
  <link rel="stylesheet" href="../resources/css/style.css">
</head>

<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script>


$(function(){
	
	$('#btn1').on('click',function(){
		
		var queryString = $("#form1").serialize();
		
		   $.ajax({
		      type : 'post',
		      url : '<%=request.getContextPath()%>/memberLogin.do',
//		      data : JSON.stringify(queryString),
	          data : queryString,
		      dataType : 'json',
		      error: function(xhr, status, error){
		         alert("실패");
		      },
		      success : function(json){
		          
		    	  if(json==null){
		        	 alert("일치하는 회원 정보가 없습니다.");
		        	 
		         }else if(json.mem_id=="admin"){
		        	 alert(json.mem_id+"님 환영합니다");
		        	 location.href="<%=request.getContextPath()%>/admin/adminMain.jsp"
		         }else{
		        	 alert(json.mem_name+"님 환영합니다");
		        	 location.href="<%=request.getContextPath()%>/html/main.jsp"; 
		         }
		    	 
		      }
		   })
	})
	

})


</script>
<body>
 
<%
 	String valueId = "";
 String checked = "";
 Cookie[] cookieArr= request.getCookies();
 if (cookieArr != null) {
 	for (Cookie cookie : cookieArr) {
 		String name = cookie.getName();
 		if ("id".equals(name)) {
 	valueId = cookie.getValue();
 	checked = "checked";
 		}
 	}
 }
 %>
 <%MemberVO vo = (MemberVO)session.getAttribute("login"); 
	if(vo!=null){%>
		<%@ include file = "header_login.jsp" %>
	<%}else{%>
		<%@ include file = "header_logout.jsp" %>
	<% }%>
  <br><br><br><br>
  <main class="th-layout-main ">
    <!-- [S]hooms-N52 -->
    <div class="hooms-N52" data-bid="HYlsl3qDxe" id="">
      <div class="contents-inner">
        <div class="contents-container">
          <div class="textset textset-h2">
            <h2 class="textset-tit">Login</h2>
            <p class="textset-desc">엽록소 패밀리를 방문해주셔서 감사합니다.</p>
          </div>
         <form id="form1">
          <div class="contents-form">
            <div class="inputset inputset-lg inputset-label">
              <label>
                <h6 class="inputset-tit">ID</h6>
                <input type="text" class="inputset-input form-control" placeholder="아이디를 입력해주세요." aria-label="내용" name="id" value="<%=valueId%>">
              </label>
            </div>
            <div class="inputset inputset-lg inputset-label">
              <label>
                <h6 class="inputset-tit">Password</h6>
                <input type="password" class="inputset-input form-control" placeholder="비밀번호를 입력해주세요." aria-label="내용" name="pass">
              </label>
            </div>
           </form>
            <div class="contents-checkset">     
              <div class="checkset">
                <input id="checkset-a-1-2" class="checkset-input input-fill" type="checkbox" name ="check" value="check" <%=checked %>>
                <label class="checkset-label" for="checkset-a-1-2"></label>
                <span class="checkset-text">아이디 저장</span>
              </div>
            </div>
            <button type="button" id ="btn1" class="btnset btnset-lg" >로그인</button>
          </div>
          <ul class="contents-list">
            <li class="contents-item">
              <a href="<%=request.getContextPath() %>/html/findId.jsp" class="contents-link">아이디 찾기</a>
            </li>
            <li class="contents-item">
              <a href="<%=request.getContextPath() %>/html/findPass.jsp" class="contents-link">비밀번호 찾기</a>
            </li>
            <li class="contents-item">
              <a href="<%=request.getContextPath() %>/html/signUp.jsp" class="contents-link">회원가입</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <!-- [E]hooms-N52 -->
  </main>
  <%@ include file = "footer.jsp" %>
  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>