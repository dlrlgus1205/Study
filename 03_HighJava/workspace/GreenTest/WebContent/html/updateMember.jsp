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
  <title>SignUp | 침대</title>
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
		var pass1 = $('#pass1').val().trim();
		var pass2 = $('#pass2').val().trim();
		
		if(pass1!=pass2){
		alert("비밀번호란과 비밀번호 확인란이 서로 다릅니다.");
		return false;
		}
		
		
		
		var queryString = $("#form1").serialize();
		   $.ajax({
		      type : 'get',
		      url : '<%=request.getContextPath()%>/updateMember.do',
	          data : queryString,
		      dataType : 'json',
		      error: function(xhr, status, error){
		         alert("실패");
		      },
		      success : function(json){
		           alert(json);

		      }
		   })
	})
})

</script>

<body>
  <main class="th-layout-main ">
    <!-- [S]hooms-N53 -->
    <div class="hooms-N53" data-bid="MeLSl3mvER" id="">
      <div class="contents-inner">
        <form id="form1">
        <div class="contents-container">
          <div class="textset textset-h2">
            <h2 class="textset-tit">회원정보 수정</h2>          
          </div>
         
          <div class="contents-form">
            <div class="contents-form-bottom">
              
              <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 비밀번호<span>*</span>
                  </h6>
                  <input type="password" id="pass1" class="inputset-input form-control" name="pass" placeholder="수정할 비밀번호를 입력해 주세요." aria-label="내용" required="">
                </label>
              </div>
               <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 비밀번호 확인<span>*</span>
                  </h6>
                  <input type="password" id="pass2" class="inputset-input form-control" name="pass2" placeholder="비밀번호를 다시 입력해 주세요" aria-label="내용" required="">
                </label>
              </div>
               
               <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 닉네임
                  </h6>
                  <input type="text" class="inputset-input form-control" name="nick" placeholder="수정할 닉네임을 입력해 주세요." aria-label="내용" required="">
                </label>
              </div>
              <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 이메일
                  </h6>
                  <input type="email" class="inputset-input form-control" name="mail" placeholder="수정할 이메일주소를 입력해 주세요." aria-label="내용" required="">
                </label>
              </div>
              <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 휴대폰 번호
                  </h6>
                  <input type="tel" class="inputset-input form-control" name="phone" placeholder="- 없이 입력해주세요." aria-label="내용" required="">
                </label>
              </div>                      
            </div>
          </div>          
          <button type="button" id="btn1" class="btnset btnset-lg contents-submit">회원정보 수정</button>
        </form>
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