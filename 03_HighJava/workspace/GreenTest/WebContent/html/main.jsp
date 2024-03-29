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
  <title>엽록소 패밀리</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/setting.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/plugin.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/template.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>

<body>
<%MemberVO vo = (MemberVO)session.getAttribute("login"); 
	if(vo!=null){%>
		<%@ include file = "header_login.jsp" %>
	<%}else{%>
		<%@ include file = "header_logout.jsp" %>
	<% }%>


  <!-- [S]main -->
  <div class="main" data-bid="hfLsjYRr30">
    <div class="contents-container">
      <img class="contents-visual img-pc" src="../medias/4a14abbb5ed74fd2b614f82042348487.png" alt="main">
      <img class="contents-visual img-mobile" src="../resources/images/img_subvisual_mobile_01.png" alt="비주얼 모바일 이미지">
    </div>
  </div>
  <!-- [E]main -->
<%@ include file = "footer.jsp" %>
  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>