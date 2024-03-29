<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/setting.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/plugin.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/template.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
  
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/admin.js"></script>
<%List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");%>
<%int count = (int)request.getAttribute("memCount");%>
<script type="text/javascript">
currentPage = 1;
mypath = `<%=request.getContextPath()%>`
value = '';
function deleteMember(memId) {
    alert(memId + "회원을 탈퇴합니다.");
    
    //id를 전송해서 탈퇴진행
    $.ajax({
		url : `<%=request.getContextPath()%>/memDelete.do`,
		type : 'get',
		data : { "mem_id" : memId},
		success : function(res){
			if(res.result == 1){
				alert("탈퇴가 완료되었습니다.");
			}
			location.href="/GreenTest/memList.do";
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

$(function(){
	
	//next 이벤트
	  $(document).on('click','#next',function(){
		  currentPage = parseInt($('.pageno').last().text())+1;
		  $('#result').empty();
		  memPageList();
	  })
	  //prev 이벤트
	  $(document).on('click','#prev',function(){
		  currentPage = parseInt($('.pageno').first().text())-1;
		  $('#result').empty();
		  memPageList();
	  })
	  //페이지 번호
	  $(document).on('click','.pageno',function(){
		  currentPage = parseInt($(this).text());
		  $('#result').empty();
		  memPageList();
	  })
	
	//처음 들어갔을때 리스트 출력
	memPageList();
	
	//검색 이벤트 후 리스트 
	$('#search').on('click',function(){
		memPageList();
	})
	
	$('.ang').on('click',function(){
		value=$(this).first().text().trim();
	})
	
})
</script>
</head>
<body>

    <main>
    <div class="hooms-N36" data-bid="YSLsl96TkR" id="">
      <div class="contents-inner">
        <div class="contents-container container-md">
          <div class="textset textset-h2">
            <h2 class="textset-tit">회원 통합 관리</h2>
          </div>
          <div class="contents-search">
            <p class="contents-result"> 전체<span><%=count%></span>명 </p>
            <div class="contents-form">
              <div class="selectset selectset-lg">
                <ul class="selectset-list">
                  <li class="selectset-item">
                  </li>
                </ul>
              </div>
		      
		      
             <div class="contents-form">
             <div class="selectset selectset-lg">
               <button class="selectset-toggle btn ang" type="button" value="">
                 <span>전체</span>
               </button>
               
               <ul class="selectset-list">
			    <li class="selectset-item">
			      <button class="selectset-link btn ang" type="button" value="mem_name">
			        <span>이름</span>
			      </button>
			    </li>
			    <li class="selectset-item">
			      <button class="selectset-link btn ang" type="button" value="mem_id">
			        <span>아이디</span>
			      </button>
			    </li>
			    <li class="selectset-item">
			      <button class="selectset-link btn ang" type="button" value="mem_nickname">
			        <span>닉네임</span>
			      </button>
			    </li>
			  </ul>
               
             </div>
             <div class="inputset inputset-lg">
               <button class="inputset-icon icon-right icon-search btn" type="button" aria-label="아이콘" id="search"></button>
               <input type="text" class="inputset-input form-control" placeholder="검색어를 입력해주세요." aria-label="내용">
              </div>
           	 </div>
            </div>
          </div>
          
          <!-- 회원 리스트 출력 -->
          <div id="result"></div>
          
          <!-- 페이징 버튼 -->
          <div id="pageList"></div>
          
          <nav class="pagiset pagiset-line" id="target2"></nav>
          
        </div>
      </div>
    </div>
    <!-- [E]hooms-N36 -->
  </main>
  <!-- [E]hooms-N57 -->
  <script src="<%=request.getContextPath()%>/resources/js/setting.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/plugin.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/template.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</body>
</html>
















