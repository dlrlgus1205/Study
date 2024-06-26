<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="kr.or.ddit.servlet07.MbtiControllerServlet"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>자원의 분류</h4>
<pre>
	해당 자원에 접근하는 방법에 따른 분류
	1. web resource : URL로 접근할 수 있는 웹을 통해 서비스되는 리소스
		ex) http://localhost:80/WebStudy01/resources/images/cat4.png 
		<%
			String url = "/resources/images/cat4.png";
			String realPath = application.getRealPath(url);
			out.println(new File(realPath));
		%>
	2. file system resource : 파일 시스템 상의 절대 경로로 접근
		ex) D:\00.medias\images\cute5.jpg
		<%=new File("D:\\00.medias\\images\\cute5.jpg") %>
	3. classpath resource : classpath 이후의 경로(qualified name)로 접근
		ex) /kr/or/ddit/MemberData.prop	erties
		<%
			String logicalPath = "/kr/or/ddit/MemberData.properties";
			String PhysicalPath = MbtiControllerServlet.class.getResource(logicalPath).getFile();
			out.println(new File(PhysicalPath));
		%>
		<%
// 			소스폴더 경로 + 파일네임
			String srcFURL = "/resources/images";
			File srcFolder = new File(application.getRealPath(srcFURL));
			String srcName = "cat4.png";
			File srcFile = new File(srcFolder, srcName);
			String desFURL = "/12";
			File destFolder = new File(application.getRealPath(desFURL));
			File destFile = new File(destFolder, srcFile.getName());
			
			try(
				InputStream is = new FileInputStream(srcFile);
				BufferedInputStream bis = new BufferedInputStream(is);
				OutputStream os = new FileOutputStream(destFile);
				BufferedOutputStream bos = new BufferedOutputStream(os);
			){
				int cnt = -1;
				while((cnt = bis.read()) != -1){
					bos.write(cnt);
				}
				bos.flush();
			}
		%>
</pre>
<img alt="cat4.png" src="<%=request.getContextPath()%>/12/cat4.png"/>
</body>
</html>