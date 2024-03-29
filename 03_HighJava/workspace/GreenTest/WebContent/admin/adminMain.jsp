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
<title>관리자 페이지</title>
<link rel="stylesheet" href="../resources/css/setting.css">
<link rel="stylesheet" href="../resources/css/plugin.css">
<link rel="stylesheet" href="../resources/css/template.css">
<link rel="stylesheet" href="../resources/css/common.css">
<link rel="stylesheet" href="../resources/css/style.css">
<style>
.hooms-N46 .contents-top {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 4rem 0;
    border-top: 1px solid #ffffff;
}
.tabset.tabset-solid .tabset-list.tabset-sm .tabset-link {
    height: var(--ht-lg);
    color: white;
}
.tabset.tabset-solid .tabset-list {
    background-color: #000;
}
.tabset.tabset-solid {
    border-bottom: 1px solid #3f3838;
}
.hooms-N46 .contents-tit h3 strong {
    margin-right: 0.4rem;
    color: #ffffff;
    font-weight: 500;
}
</style>
</head>
<body>
  <main class="th-layout-main ">
    <!-- [S]hooms-N46 -->
    <div class="hooms-N46" data-bid="zpLSL8Th8v" id="">
      <div class="contents-inner" style="background-color: black;">
        <div class="contents-container container-md">
          <div class="textset textset-h2">
            <h2 class="textset-tit" style="background-color: black; color: white;">Admin Page</h2>
          </div>
          <div class="contents-top">
            <div class="contents-tit">
              <h3>
                <strong>관리자</strong>님 환영합니다!
              </h3>
            </div>
          </div>
        </div>
        <div class="tabbar-inner">
          <div class="tabbar-container container-md">
            <div class="tabset tabset-solid border-bottom">
              <ul class="tabset-list tabset-sm">
                <li class="tabset-item">
                  <a class="tabset-link active" href="/GreenTest/admin/PostList.jsp" target="iframe1">
                    <span>게시글 관리</span>
                  </a>
                </li>
                 <li class="tabset-item">
                  <a class="tabset-link active" href="<%=request.getContextPath()%>/memList.do" target="iframe1">
                    <span>회원 통합 관리</span>
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
    		<iframe src="/GreenTest/admin/PostList.jsp" width="99%" height="1500" name="iframe1"></iframe>
    	</div>
    </div>
   </div>
  </main>
  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>