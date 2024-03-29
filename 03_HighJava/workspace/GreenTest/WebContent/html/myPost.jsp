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
  <title>내 게시물</title>
  <link rel="stylesheet" href="../resources/css/setting.css">
  <link rel="stylesheet" href="../resources/css/plugin.css">
  <link rel="stylesheet" href="../resources/css/template.css">
  <link rel="stylesheet" href="../resources/css/common.css">
  <link rel="stylesheet" href="../resources/css/style.css">
</head>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/mypost.js"></script>
<script>
category = 2;
type='';
board = 2;
currentPage = 1;
mypath = '<%=request.getContextPath()%>'
$(function(){
	
	listPageServer2();
	
	
	$('.searchbtn').on('click',function(){
		$('#target').empty();
		listPageServer2();
	})
	
	$('#button1').on('click',function(){
		category=2;
		$('#target').empty();
		listPageServer2();
	})
	
	$('#button2').on('click',function(){
		category=4;
		$('#target').empty();
		listPageServer2();
	})
	
	$('#button3').on('click',function(){
		category=3;
		$('#target').empty();
		listPageServer2();
	})
	
	$('.btncheck').on('click',function(){
		type = $(this).first().text().trim();
	})
	
	//next 이벤트
	  $(document).on('click','#next',function(){
		  
		  currentPage = parseInt($('.pageno').last().text())+1;
		  $('#target').empty();
		  listPageServer2();
	  })
	  //prev 이벤트
	  $(document).on('click','#prev',function(){
		  currentPage = parseInt($('.pageno').first().text())-1;
		  $('#target').empty();
		  listPageServer2();
	  })
	  //페이지 번호
	  $(document).on('click','.pageno',function(){
		  currentPage = parseInt($(this).text());
		  $('#target').empty();
		  listPageServer2();
	  })
	
})
</script>

<body>
    <!-- [S]hooms-N36 -->
    <div class="hooms-N36" data-bid="YSLsl96TkR" id="">
      <div class="contents-inner">
        <div class="contents-container container-md">
          <div class="textset textset-h2">
            <h2 class="textset-tit">나의 작성글<br><br></h2>
             <div class="tabset tabset-brick">
            <ul class="tabset-list tabset-sm tabset-fill">
              <li class="tabset-item">
                <button  id="button1" type="button" class="tabset-link">
                  <span>잡담</span>
                </button>
              </li>
              <li class="tabset-item">
                <button id="button2" type="button" class="tabset-link">
                  <span>팁</span>
                </button>
              </li>
              <li class="tabset-item">
                <button id="button3" type="button" class="tabset-link">
                  <span>질문</span>
                </button>
              </li>         
            </ul>
          </div>
          </div>
          <div class="contents-search">
            <p class="contents-result"> 전체<span id="total"> </span>개 </p>
            <div class="contents-form">
              <div class="selectset selectset-lg">
                <button class="selectset-toggle btn" type="button">
                  <span>전체</span>
                </button>
                <ul class="selectset-list">
                  <li class="selectset-item">
                    <button class="selectset-link btn btncheck" type="button" data-value="전체">
                      <span>전체</span>
                    </button>
                  </li>
                  <li class="selectset-item">
                    <button class="selectset-link btn btncheck" type="button" data-value="전체">
                      <span>제목</span>
                    </button>
                  </li>
                  <li class="selectset-item">
                    <button class="selectset-link btn btncheck" type="button" data-value="전체">
                      <span>내용</span>
                    </button>
                  </li>
                  <li class="selectset-item">
                    <button class="selectset-link btn btncheck" type="button" data-value="전체">
                      <span>아이디</span>
                    </button>
                  </li>
                </ul>
              </div>
              <div class="inputset inputset-lg">
                <button class="inputset-icon icon-right icon-search btn searchbtn" type="button" aria-label="아이콘"></button>
                <input type="text" class="inputset-input form-control" placeholder="검색어를 입력해주세요." aria-label="내용">
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
              </colgroup>
              <thead class="thead-light thead-border-top">
                <tr>
                  <th scope="col">No.</th>
                  <th scope="col">구분</th>
                  <th scope="col">제목</th>
                  <th scope="col">등록일</th>  
                  <th scope="col">조회수</th>
                  <th scope="col">추천수</th>
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
    <!-- [E]hooms-N36 -->
  </main>

  <script src="../resources/js/setting.js"></script>
  <script src="../resources/js/plugin.js"></script>
  <script src="../resources/js/template.js"></script>
  <script src="../resources/js/common.js"></script>
  <script src="../resources/js/script.js"></script>
</body>