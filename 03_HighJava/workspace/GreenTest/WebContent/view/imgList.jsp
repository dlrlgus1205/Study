<%@page import="img.vo.ImgVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<%
		List<ImgVO> imgList =
			(List<ImgVO>)request.getAttribute("imgList");
	
	
	
	
	
	%>
</head>
<body>
<h2>전체 파일 목록</h2><br><hr><br>

<a href ="<%=request.getContextPath() %>/imgInsert.do">이미지업로드</a>
<table border="1">
<thead>
	<tr>
		<th>이미지번호</th><th>게시글번호</th><th>이미지이름</th>
		<th>이미지경로</th><th>업로드시간</th>
	</tr>
	

</thead>

<tbody>
<%
if(imgList==null || imgList.size()==0){
	%>
	<tr>
	<td  colspan="7" style="text-align:center;">Upload한 파일 목록이 하나도 없습니다. </td>
	</tr>
	<% 
}else{
	for(ImgVO imgVo : imgList){
		%>
		<tr>
			<td><%=imgVo.getImg_no() %></td>
			<td><%=imgVo.getPost_no() %></td>
			<td><%=imgVo.getImg_name() %></td>
			<td><%=imgVo.getImg_path() %></td>
			<td><%=imgVo.getImg_upload_date()%></td>
			
			
	
			</tr>
			<% 
	}
}
%>






</tbody>

</table>




</body>


</html>