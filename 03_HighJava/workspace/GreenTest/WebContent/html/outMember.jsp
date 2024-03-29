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
  <title>회원 탈퇴</title>
  <link rel="stylesheet" href="../resources/css/setting.css">
  <link rel="stylesheet" href="../resources/css/plugin.css">
  <link rel="stylesheet" href="../resources/css/template.css">
  <link rel="stylesheet" href="../resources/css/common.css">
  <link rel="stylesheet" href="../resources/css/style.css">
</head>
<style>

#p2{
	text-align: center;
}
</style>

<body>
  <!-- [E]hooms-N55 -->
  <main class="th-layout-main ">
    <!-- [S]hooms-N53 -->
   <form action="<%=request.getContextPath() %>/memberOut.do" method="post" target="_top">
    <div class="hooms-N53" data-bid="MaLSl4FlXJ" id="" style="margin-top: 0px;">
      <div class="contents-inner">
        <div class="contents-container">
          <div class="textset textset-h2">
            <h2 class="textset-tit">회원 탈퇴</h2>
            <p class="p2" id="p2"><br>엽록소 패밀리를 이용해 주셔서 감사합니다. </p>
          </div>
          <div class="contents-form">
            <div class="contents-form-bottom">
              <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 비밀번호<span>*</span>
                  </h6>
                  <input type="password" class="inputset-input form-control" placeholder="비밀번호를 입력해 주세요." required="" name="mem_pass">
                </label>
              </div>                                        
            </div>
          </div>
          <button class="btnset btnset-lg contents-submit">회원 탈퇴</button>
        </div>
      </div>
    </div>
   </form>
    <!-- [E]hooms-N53 -->
  </main>
  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>