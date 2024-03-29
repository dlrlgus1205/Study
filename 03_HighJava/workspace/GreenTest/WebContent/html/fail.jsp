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
  <title>작업 실패</title>
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
    <!-- [S]hooms-N51 -->
    <div class="hooms-N51" data-bid="AELSl3RRdq" id="">
      <div class="contents-inner">
        <div class="contents-container container-md">
          <div class="contents-ico">
            <figure class="contents-figure">
              <img class="cardset-img" src="../resources/icons/failed.png" alt="웰컴 아이콘">
            </figure>
          </div>
          <div class="textset textset-h2">
            <h2 class="textset-tit">작업 실패<p></p>
            </h2>
          </div>
          <p class="contents-message">작업에 실패했습니다. 다시 시도해주세요</p>
          <div class="contents-btn"> 
            <a href="<%=request.getContextPath()%>/html/login.jsp" class="btnset btnset-lg">메인화면으로 가기</a>
          </div>
        </div>
      </div>
    </div>
    <!-- [E]hooms-N51 -->
  </main>
    <%@ include file = "footer.jsp" %>

  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>