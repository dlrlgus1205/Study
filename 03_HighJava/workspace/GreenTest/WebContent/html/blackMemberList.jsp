<%@page import="com.google.gson.Gson"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
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
  <title>Contact_ContactUs_Q | 테스트</title>
  <link rel="stylesheet" href="../resources/css/setting.css">
  <link rel="stylesheet" href="../resources/css/plugin.css">
  <link rel="stylesheet" href="../resources/css/template.css">
  <link rel="stylesheet" href="../resources/css/common.css">
  <link rel="stylesheet" href="../resources/css/style.css">
</head>

<style>
#button1{
	float: right;
}
</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script src="<%=request.getContextPath()%>/js/blacklist.js"></script>
<script>

currentPage = 1;
mypath = '<%=request.getContextPath()%>'
$(function(){
	
	listPageServer();
	
	$('#button1').on('click',function(){
		location.href="<%=request.getContextPath()%>/html/blackMember.jsp";
	})
	
	$(document).on('click','.btnUnBlack',function(){
		blacklist_id=$(this).parents('tr').find('td:eq(1)').text();
		$.ajax({
		      type : 'get',
		      url : '<%=request.getContextPath()%>/blackListCancel.do',
	          data : 'blacklist_id='+blacklist_id,
		      dataType : 'json',
		      error: function(xhr, status, error){
		         alert("실패");
		      },
		      success : function(json){
		    	  alert(json);
		    	  $('#target').empty();
		    	  listPageServer();
		    	  
		      }
		   })
	})
	
	//next 이벤트
	  $(document).on('click','#next',function(){
		  
		  currentPage = parseInt($('.pageno').last().text())+1;
		  $('#target').empty();
		  listPageServer();
	  })
	  //prev 이벤트
	  $(document).on('click','#prev',function(){
		  currentPage = parseInt($('.pageno').first().text())-1;
		  $('#target').empty();
		  listPageServer();
	  })
	  //페이지 번호
	  $(document).on('click','.pageno',function(){
		  currentPage = parseInt($(this).text());
		  $('#target').empty();
		  listPageServer();
	  })
	
})
</script>

<body>
    <!-- [S]hooms-N36 -->
    <div class="hooms-N36" data-bid="YSLsl96TkR" id="">
      <div class="contents-inner">
        <div class="contents-container container-md">
          <div class="textset textset-h2">
            <h2 class="textset-tit">회원 차단하기</h2>
          </div>
          <div class="contents-search">
            <p class="contents-result"> 전체<span id="total"> </span>개 </p>
            <div class="contents-form"> 
              <div class="inputset inputset-lg">
                <button id="button1" type="button" class="btnset btnset-ghost modal-close">회원 차단</button>
              </div>
            </div>
          </div>
          <div class="tableset">
            <table class="tableset-table table">
              <colgroup>
                <col>
                <col>
                <col>
                <col>
                <col>
                <col>
                <col>
              </colgroup>
              <thead class="thead-light thead-border-top">
                <tr>
                  <th scope="col">No.</th>
                  <th scope="col">아이디</th>
                  <th scope="col">차단일</th>
                  <th scope="col">차단 해제</th>
                </tr>
              </thead>
              <tbody id="target">          
              </tbody>
            </table>
          </div>
          <nav class="pagiset pagiset-line" id="target2">
          </nav>
        </div>
      </div>
    </div>
    <!-- [E]hooms-N36 -->
  </main>

  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>