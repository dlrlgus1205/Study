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
  <title>회원 차단</title>
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

<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$('#btn1').on('click',function(){
		//event.preventDefault();
		var queryString = $("#form1").serialize();
		   $.ajax({
		      type : 'get',
		      url : '<%=request.getContextPath()%>/blackListAdd.do',
	          data : queryString,
		      dataType : 'json',
		      error: function(xhr, status, error){
		         alert("실패");
		      },
		      success : function(json){
		          var result = json;
		    	  
		    	 $('#resultdiv').empty();
		    	 $('#resultdiv').text(result);
		      }
		   })
	})
})
</script>

<body>
  <!-- [E]hooms-N55 -->
 
  <main class="th-layout-main ">
    <!-- [S]hooms-N53 -->
   <form id = "form1">
    <div class="hooms-N53" data-bid="MaLSl4FlXJ" id="" style="margin-top: 0px;">
      <div class="contents-inner">
        <div class="contents-container">
          <div class="textset textset-h2">
            <h2 class="textset-tit">회원 차단</h2>
            <p class="p2" id="p2"><br>회원 차단시에는 차단한 회원의 글이 보이지 않습니다.</p>
          </div>
          <div class="contents-form">
            <div class="contents-form-bottom">
              <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 아이디<span>*</span>
                  </h6>
                  <input type="text" class="inputset-input form-control" placeholder="차단할 회원의 아이디를 입력해 주세요." required="" name="mem_id">
                </label>
              </div>                                     
            </div>
          </div>
          <div class="inputset inputset-lg inputset-label"><h6 class="inputset-tit" id="resultdiv"></h6></div>
          <button type="button" id="btn1" class="btnset btnset-lg contents-submit">회원 차단</button>
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