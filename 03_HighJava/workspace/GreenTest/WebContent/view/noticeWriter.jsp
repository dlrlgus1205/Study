<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="panel-heading">공지사항  작성하기</div>
	<div class="panel-body">
		<form method="post" action="<%=request.getContextPath()%>/noticeInsert.do" enctype="multipart/form-data">
			<select name="noticeno">
			
			</select>
			<div class="form-group">
			
				<label>작성자</label> 
                	<input class="form-control" name="noticewirter"  >
			</div>
			<div class="form-group">
				<label>제목</label> 
                <input class="form-control" name="noticetitle">
			</div>
			<div class="form-group">
				<label>내용</label>
					<textarea class="form-control" rows="3" name="noticecontent"></textarea>
			</div>
			
			<div class="form-group">
				<label>이미지첨부</label> 
                <input type="file" name="img_name" multiple>
			</div>	
		
			<input type="submit" class="btn btn-default" value="글 등록하기"  
								 style="margin-top: 50px;">
			<input type="button" class="btn btn-default" value="목록보기" 
								onClick="location.href='<%=request.getContextPath()%>/noticeList.do'" style="margin-top: 50px;">
		</form>
	</div>

</body>
</html>