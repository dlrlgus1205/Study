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
  <title>마이페이지</title>
  <link rel="stylesheet" href="../resources/css/setting.css">
  <link rel="stylesheet" href="../resources/css/plugin.css">
  <link rel="stylesheet" href="../resources/css/template.css">
  <link rel="stylesheet" href="../resources/css/common.css">
  <link rel="stylesheet" href="../resources/css/style.css">
</head>

<body>
 <%MemberVO vo = (MemberVO)session.getAttribute("login"); 
	if(vo!=null){%>
		<%@ include file = "header_login.jsp" %>
	<%}else{%>
		<%@ include file = "header_logout.jsp" %>
	<% }%>
	<br><br><br>
  <main class="th-layout-main ">
    <!-- [S]hooms-N46 -->
    <div class="hooms-N46" data-bid="zpLSL8Th8v" id="">
      <div class="contents-inner">
        <div class="contents-container container-md">
          <div class="textset textset-h2">
            <h2 class="textset-tit">My Page</h2>
          </div>
          <div class="contents-top">
            <div class="contents-tit">
              <h3>
                <strong><%=vo.getMem_name() %></strong>님 안녕하세요!
              </h3>
            </div>
          </div>
        </div>
        <div class="tabbar-inner">
          <div class="tabbar-container container-md">
            <div class="tabset tabset-solid border-bottom">
              <ul class="tabset-list tabset-sm">
                <li class="tabset-item">
                  <a class="tabset-link active" href="<%=request.getContextPath() %>/html/myPost.jsp" target="iframe1">
                    <span>나의 작성글</span>
                  </a>
                </li>
                 <li class="tabset-item">
                  <a class="tabset-link active" href="<%=request.getContextPath() %>/html/myQna.jsp" target="iframe1">
                    <span>나의 문의내역</span>
                  </a>
                </li>                
                <li class="tabset-item">
                  <a class="tabset-link" href="<%=request.getContextPath() %>/html/blackMemberList.jsp" target="iframe1">
                    <span>회원 차단</span>
                  </a>
                </li>
                <li class="tabset-item">
                  <a class="tabset-link active" href="<%=request.getContextPath() %>/html/updateMember.jsp" target="iframe1">
                    <span>회원정보 수정</span>
                  </a>
                </li>
                <li class="tabset-item">
                  <a class="tabset-link" href="<%=request.getContextPath() %>/html/outMember.jsp" target="iframe1">
                    <span>회원 탈퇴</span>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- [E]hooms-N46 -->
    <div class="hooms-N37" data-bid="SzlSLd3Vzn" id="">
   	 <div class="contents-inner">
  		<div class="contents-container container-md">
    		<iframe src="<%=request.getContextPath() %>/html/myPost.jsp" width="99%" height="1500" name="iframe1"></iframe>
    	</div>
    </div>
   </div>
  </main>
   <%@ include file = "footer.jsp" %>
  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>