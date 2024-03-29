<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "../js/jquery-3.7.1.min.js"></script>

<script>
$(()=>{
	$('input[type=button]').on('click',()=>{
		//입력한 동이름 가져오기
		dongvalue = $('#dong').val().trim();
		
		//입력여부
		if(dongvalue.length < 1){
			alert("동 입력하세요.");
			return false;
		}
		//서버로 전송
		$.ajax({
			url : '/jqpro/member/searchDongServlet.jsp',
			data : { "dong" : dongvalue},
			type : 'post',
			success : (res)=>{
				alert("성공")
			},
			error : (xhr) =>{
				alert("상태 : " + xhr.status)
			},
			dataType : 'json'
		})
	})
})
</script>
</head>
<body>
<h2>우편번호 찾기</h2>
동이름 입력
<input type = "text" id = "dong">
<input type = "button" value = "확인">
</body>
</html>