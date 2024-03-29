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
  <title>header</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/setting.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/plugin.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/template.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>

<body>
  <!-- [S]header -->
  <div class="header" data-bid="pzlsjWn6SL" id="" style = "border-bottom : 1px solid rgba(86, 138, 53, 0.4)">
    <div class="header-container container-lg">
      <div class="header-left">
        <h1 class="header-title">
          <a class="header-logo" href="<%=request.getContextPath()%>/html/main.jsp" title="chlorophyll family"></a>
        </h1>
      </div>
      <div class="header-center">
        <ul class="header-gnblist">
          <li class="header-gnbitem">
            <a class="header-gnblink" href="<%=request.getContextPath()%>/wikiList.do">
              <span>식물위키</span>
            </a>
          </li>
          <li class="header-gnbitem">
            <a class="header-gnblink" href="<%=request.getContextPath()%>/postList.do">
              <span>자유게시판</span>
            </a>
          </li>
          <li class="header-gnbitem">
            <a class="header-gnblink" href="<%=request.getContextPath()%>/starList.do?bono=<%=3%>">
              <span>식물스타그램</span>
            </a>
          </li>
          <li class="header-gnbitem">
            <a class="header-gnblink" href="<%=request.getContextPath()%>/noticeList.do">
              <span>공지사항</span>
            </a>
          </li>
        </ul>
      </div>
      <div class="header-right">
        <div class="header-utils">
        
          <a href="<%=request.getContextPath() %>/html/myPage.jsp" class="btn-profile header-utils-btn" title="profile"></a>
          <a href="<%=request.getContextPath() %>/memberLogout.do" class="btn-logout header-utils-btn" title="logout"></a>
<!--           <a href="javascript:void(0);" class="btn-login header-utils-btn" title="login"></a> -->
          
<!--           <a href="javascript:void(0);" class="btn-mail header-utils-btn" title="mail"></a> -->
<!--           <a href="javascript:void(0);" class="btn-bell header-utils-btn" title="bell"></a> -->
        </div>
      </div>
    </div>
    <div class="header-dim"></div>
  </div>
  <!-- [E]header -->
  <script src="<%=request.getContextPath()%>/resources/js/setting.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/plugin.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/template.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</body>