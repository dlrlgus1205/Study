<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <form method="post" enctype="multipart/form-data"
  action="<%=request.getContextPath()%>/imgInsert.do">
  
  게시판번호: <input type="text" name="postno"><br><br>
 한 개의 파일 선택 : <input type="file" name="upFile1"><br><br>
 여러개의  파일 선택 : <input type="file" name="upFile2" multiple><br><br>
 <input type="submit" value="전송">
 
  
  
  
  </form>



</body>
</html>