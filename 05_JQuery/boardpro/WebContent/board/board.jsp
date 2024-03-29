<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="../css/board.css" rel="stylesheet">

<script src="../js/board.js"></script>
<script src="../js/jquery.serializejson.min.js"></script>

<script>
<%
//로그인 체크 - session의 값을 가져오기 - 비교하기
MemberVo vo = (MemberVo)session.getAttribute("loginok");
//json 형태로 형변환
String ss = null;

Gson gson = new Gson();
if(vo!=null) ss = gson.toJson(vo);
 	
%>
uvo = <%= ss%>

currentPage = 1;

reply = { }; //객체;
board = { };

mypath = '<%=request.getContextPath() %>'

$(document).ready(function(){
	//시작하자마자 listPageServer를 실행하여
	//게시판 리스트 출력 된다
   $.listPageServer();
	
	
	// 검색 이벤트
	$('#search').on('click',function(){
		$.listPageServer();
	})
	
	//NEXT(다음) 이벤트
	$(document).on('click','#next',function(){
		currentPage = parseInt($('.pageno').last().text()) +1;
		$.listPageServer();
	})
	
	//previous(이전) 이벤트
	$(document).on('click','#prev',function(){
		currentPage = parseInt($('.pageno').first().text()) -1;
		$.listPageServer();
	})
	
	//페이지번호 .pageno 이벤트
	$(document).on('click','.pageno',function(){
		currentPage =  parseInt($(this).text());
		$.listPageServer(); 
	})
	
	//글쓰기 이벤트
	$('#write').on('click',function(){
		if(uvo==null){
			alert("로그인하세요")
		}else{
			$('#wModal').modal('show');
			$('#wwriter').val(uvo.mem_name);
		}
		
	})
	
	//글쓰기 전송 이벤트
	$('#wsend').on('click',function(){
		//입력한 모든 값을 가져온다.
		fdata = $('#wform').serializeJSON();
		console.log(fdata);
		
		//서버로 전송
		$.boardWriteServer();
		
		//모달창 닫기
		$('.txt').val("");
		$('#wModal').modal('hide');
	})
	
	// 수정, 삭제, 등록, 제목, 댓글수정, 댓글삭제 이벤트
	$(document).on('click','.action', function(){
		vaction = $(this).attr('name');
		vidx = $(this).attr('idx');
		
		gtarget = this;
		
		if(vaction =="delete"){
			//alert(vidx + "번 글을 삭제합니다")
			$.boardDeleteServer();
		}else if(vaction == "modify"){
			//alert(vidx + "번 글을 수정합니다")
			$('#mnum').val(vidx);
			
			// 본문의 게시글 내용을 모달 창에 출력 - 수정을 위하여
			vparent = $(this).parents('.card');
			wr = $(vparent).find('.wr').text();
			em = $(vparent).find('.em').text();
			ti = $(vparent).find('a').text().trim();
			wp3 = $(vparent).find('.wp3').html();
			
			wp3 = wp3.replaceAll(/<br>/g, "");
			
			$('#mModal #mwriter').val(wr);
			$('#mModal #msubject').val(ti);
			$('#mModal #mmail').val(em);
			$('#mModal #mcontent').val(wp3);
			
			$('#mModal').modal('show');
		}else if(vaction == "reply"){
			//alert(vidx + "번 글에 댓글을 답니다")
			
			//입력한 값을 가져온다.
			vcont = $(this).prev().val();
			//vname = uvo.mem_name;
			//vbonum = vidx;
			reply.cont = vcont;
			reply.name = uvo.mem_name;
			reply.bonum = vidx;
			
			//서버로 전송
			$.replyInsertServer();
			$(this).prev().val("");
		
		}else if(vaction =="title"){
			$.replySelect();
			
			vexp = $(this).attr("aria-expanded");
			if(vexp == "true"){
				// 서버로 전송 - DB의 값을 변경 - 성공하면 화면의 조회수를 변경
				$.updateHitServer();
			}
		}else if(vaction =="r_modify"){
			
			// modifyform 이 열려있는지 비교
			if($('#modifyform').css('display') != "none"){
				replyReset();
			}
			
			vp3 = $(this).parents('.reply-body').find('.p3');
			// 원래 내용을 가져온다
			modifycont = vp3.html().trim(); // <br> 포함
			
			// <br>을 변경
			mcont = modifycont.replaceAll(/<br>/g, "\n");
			
			// 수정 폼에 출력
			$('#modifyform textarea').val(mcont);
			
			// 수정 폼을 p3으로 이동 - append
			vp3.empty().append($('#modifyform'));
			
			// 수정폼을 보이게
// 			$('#modifyform').css('display', 'block');
			$('#modifyform').show();
		}else if(vaction =="r_delete"){
			$.replyDelete();
		}
		
	})
	// 댓글 수정창에서 취소 버튼 클릭했을 때
	$('#btnreset').on('click', function(){
		replyReset();
	})
	
	replyReset = function(){
		p3 = $('#modifyform').parent();
		
		// modifyform을 body로 이동 - 안보이게 설정
		$('body').append($('#modifyform'));
		$('#modifyform').hide();
		
		// p3의 원래 내용 modifycont를 출력
		$(p3).html(modifycont);
	}
	
	// 댓글 수정창에서 확인 버튼 클릭했을 때
	$('#btnok').on('click', function(){
		// 입력한 내용을 가져온다 - \n 포함
		modicont = $('#modifyform textarea').val();
		
		modiout = modicont.replace(/\n/g, "<br>");
		
		//modiform을 body로 이동
		$('#modifyform').appendTo($('body'));
		$('#modifyform').hide();
		
		// p3에 출력 -- db 수정 성공 후에
//  		$(p3).html(modiout);
		reply.cont = modicont;
		reply.renum = vidx;
		$.replyUpdateServer();
	})
	
	// 글 수정 모달창에서 수정 입력하고 전송 버튼 클릭
	$('#msend').on('click', function(){
		// 모달 창에서 새로 입력한 내용들을 가져온다 - subject, mail, password, content
		board.num = vidx;
		board.subject = $('#mModal #msubject').val();
		board.password = $('#mModal #mpassword').val();
		board.mail = $('#mModal #mmail').val();
		board.content = $('#mModal #mcontent').val();
		
		// 서버로 전송 - 성공 시 본문의 내용을 모달 창 내용으로 변경
		$.boardUpdateServer();
		
		// 모달 창 닫기
		// 입력 내용 지우기
		$('#mModal .txt').val("");
		$('#mModal').modal('hide');
	})
})
</script>
</head>
<body>
<div id = "modifyform">
	<textarea rows="5" cols="40"></textarea>
	<input type = "button" value = "확인" id = "btnok">
	<input type = "button" value = "취소" id = "btnreset">
</div>

<h1>게시판</h1>
<input type="button" value ="글쓰기" id="write">
<br>
<br>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      <form class="d-flex">
         <select class="form-select" id="stype">
            <option value="">전체</option>
            <option value="writer">작성자</option>
            <option value="subject">제목</option>
            <option value="content">내용</option>
         </select>
        <input id="sword"class="form-control me-2" type="text" placeholder="Search">
        <button id="search" class="btn btn-primary" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>

<div id="result"></div>
<br><br>
<div id="pagelist"></div>

<br>
<!--글쓰기 The Modal -->
<div class="modal" id="wModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">글쓰기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form name="wform" id="wform">
       	<label>제	목</label>
       	<input type="text" class="txt" id="wsubject" name="subject"><br>
       	<label>이	름</label>
       	<input readonly="readonly" type="text" class="txt" id="wwriter" name="writer"><br>
       	<label>메	일</label>
       	<input type="text" class="txt" id="wmail" name="mail"><br>
       	<label>비밀  번호</label>
       	<input type="password" class="txt" id="wpassword" name="password"><br>
       	<label>본	문</label><br>
       	<textarea rows="5" cols="40"   id="wcontent" class="txt" name="content"></textarea><br>
 		<br>
        <br>
        <input type="button" value="전송" id="wsend">      
       </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
        
      </div>

    </div>
  </div>
</div>

<!--글 수정 The Modal -->
<div class="modal" id="mModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">글 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <form name="mform" id="mform">
       	<input type = "hidden" name = "num" id = "mnum">
       	<label>제	목</label>
       	<input type="text" class="txt" id="msubject" name="subject"><br>
       	<label>이	름</label>
       	<input readonly="readonly" type="text" class="txt" id="mwriter" name="writer"><br>
       	<label>메	일</label>
       	<input type="text" class="txt" id="mmail" name="mail"><br>
       	<label>비밀  번호</label>
       	<input type="password" class="txt" id="mpassword" name="password"><br>
       	<label>본	문</label><br>
       	<textarea rows="5" cols="40"   id="mcontent" class="txt" name="content"></textarea><br>
 		<br>
        <br>
        <input type="button" value="전송" id="msend">      
       </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
        
      </div>

    </div>
  </div>
</div>
</body>
</html>