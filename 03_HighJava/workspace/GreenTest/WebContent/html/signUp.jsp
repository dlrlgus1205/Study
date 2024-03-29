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
  <title>회원가입</title>
  <link rel="stylesheet" href="../resources/css/setting.css">
  <link rel="stylesheet" href="../resources/css/plugin.css">
  <link rel="stylesheet" href="../resources/css/template.css">
  <link rel="stylesheet" href="../resources/css/common.css">
  <link rel="stylesheet" href="../resources/css/style.css">
</head>
<style>
#span1{
	color : red;
}
</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	
	$("#idCheck").on("click", function(){
		var memId = $("#mem_id").val();
		if(memId==""){
			alert("ID를 입력하세요");
			return;
		}
		
		$.ajax({
	    	 url : '<%=request.getContextPath()%>/checkId.do',
	    	 data : { "mem_id" : memId },
	    	 dataType : 'json',
	    	 success : function(result){
	    		 if(result=="OK"){
	    			$('#span1').text("사용가능");
	    			$('input[name="id"]').attr('readonly',true);
	    			$('input[name="id"]').css('background-color' ,'lightgray');
	    			 
	    		 }else{
	    			 $('#span1').text("사용불가");
	    		 }
	    	 },
	    	 error : function(xhr){
	    		 alert("status :" + xhr.status);
	    	 }
	     })
	});
	
	$("#memberForm").on("submit", function(){
		var idchk = $("#span1").text().trim();
		if(idchk!="사용가능"){
			alert("ID 중복되거나 중복체크를 하지 않았습니다.");
			return false;  // 전송 중단.
		}
		
		if($("#mem_pass").val()=="" || $("#mem_pass").val()!= $("#mem_pass2").val()){
			alert("비밀번호와 비밀번호 확인이 다릅니다. 다시 확인하세요.");
			return false;   // 서버로 전송을 하지 않는다.
		}
		
		var cbox = $('.cbox').is(':checked');
		
		if(!cbox){
			alert("회원가입을 위해 약관에 동의해 주세요");
			return false;
		}
		
		let pwdval = $('#mem_pass').val().trim();
        let pwdcheck = /^[a-zA-Z0-9]+$/
        if (!pwdcheck.test(pwdval) || pwdval.length<8){
        	alert('비밀번호는 영대소문자,숫자로 구성된 8글자 이상으로 조합하시오.')
        	$('#mem_pass').focus()
    		return false;
        }
		
		let idval = $('#mem_id').val().trim();
        let idcheck = /^[a-z0-9]+$/
        if (!idcheck.test(idval) || idval.length<6){
        	alert('아이디는 영소문자,숫자로 구성된 6글자 이상으로 조합하시오.')
        	$('#mem_id').focus()
    		return false;
        }
        
        let mailval = $('#email').val().trim();
        let mailcheck = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
        if (!mailcheck.test(mailval)){
        	alert('이메일을 확인해주세요');
        	$('#email').focus();
    		return false;
        }
        
		
		return true;
	});
});

</script>
<body>
   <%MemberVO vo = (MemberVO)session.getAttribute("login"); 
	if(vo!=null){%>
		<%@ include file = "header_login.jsp" %>
	<%}else{%>
		<%@ include file = "header_logout.jsp" %>
	<% }%>
	<br><br><br>
  <main class="th-layout-main ">
    <!-- [S]hooms-N53 -->
   <form id="memberForm"  action= "<%=request.getContextPath()%>/memberSignup.do" method="post">
    <div class="hooms-N53" data-bid="MeLSl3mvER" id="">
      <div class="contents-inner">
        <div class="contents-container">
          <div class="textset textset-h2">
            <h2 class="textset-tit">Sign Up</h2>          
          </div>
          <div class="contents-form">
            <div class="contents-form-bottom">
              <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 아이디<span>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span id="span1"></span>
                  </h6>
                  <input type="text" class="inputset-input form-control" placeholder="사용하실 아이디를 입력해 주세요." required="true" name="id" id="mem_id">
                </label>
                <button type="button" class="btnset btnset-line btnset-lg" id="idCheck">중복확인</button><br>
                
              </div>
              <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 비밀번호<span>*</span>
                  </h6>
                  <input type="password" class="inputset-input form-control" placeholder="사용하실 비밀번호를 입력해 주세요." required="true" name="pass" id="mem_pass">
                </label>
              </div>
               <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 비밀번호 확인<span>*</span>
                  </h6>
                  <input type="password" class="inputset-input form-control" placeholder="비밀번호를 다시 입력해 주세요" required="true" id="mem_pass2">
                </label>
              </div>
               <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 이름<span>*</span>
                  </h6>
                  <input type="text" class="inputset-input form-control" placeholder="사용하실 이름을 입력해 주세요." required="true" name="name">
                </label>
              </div>
               <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 닉네임<span>*</span>
                  </h6>
                  <input type="text" class="inputset-input form-control" placeholder="사용하실 닉네임을 입력해 주세요." required="true" name="nick">
                </label>
              </div>
              <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 이메일<span>*</span>
                  </h6>
                  <input type="email" class="inputset-input form-control" placeholder="사용하실 이메일주소를 입력해 주세요." required="true" name="email" id="email">
                </label>
              </div>
              <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 휴대폰 번호
                  </h6>
                  <input type="tel" class="inputset-input form-control" placeholder="- 없이 입력해주세요." name="phone">
                </label>
              </div>
               <div class="inputset inputset-lg inputset-label">
                <label>
                  <h6 class="inputset-tit"> 생년월일
                  </h6>
                  <input type="date" class="inputset-input form-control" name="birth"> 
                </label>
              </div>
            </div>
          </div>
          <div class="contents-agree">
            <div class="inputset inputset-lg inputset-label">
              <label>
                <h6 class="inputset-tit">개인정보수집 및 이용동의</h6>
                <div class="inputset-board"> - 수집하는 개인정보 항목 : 이메일 주소 <br>
                  <br> 작성해주시는 개인 정보는 문의 접수 및 고객 불만 해결을 위해 5년간 보관됩니다. 이용자는 본 동의를 거부할 수 있으나, 미동의시 문의 접수가 불가능합니다.
                </div>
              </label>
            </div>
            <div class="checkset">
              <input id="checkset-a-2-1" class="checkset-input input-fill cbox" type="checkbox">
              <label class="checkset-label cbox" for="checkset-a-2-1"></label>
              <span class="checkset-text">위 내용을 읽었으며, 내용에 동의합니다. (필수)</span>
            </div>
          </div>
          <button  type="submit" class="btnset btnset-lg contents-submit">가입완료</button>
        </div>
      </div>
    </div>
   </form>
    <!-- [E]hooms-N53 -->
  </main>
    <%@ include file = "footer.jsp" %>
  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>