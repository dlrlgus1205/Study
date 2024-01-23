<%@page import="kr.or.ddit.prod.vo.ProdVo"%>
<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 데이터 받기
	String id = request.getParameter("id");
	// service 객체 얻기
	IProdService service = ProdServiceImpl.getInstance();
	// service 메소드 호출 - 결과값 받기 - ProdVo
	ProdVo pvo = service.selectById(id);
	// 결과값을 request에 저장
	request.setAttribute("result", pvo);
	// view 페이지로 이동
	request.getRequestDispatcher("/20240122/prodView2.jsp").forward(request, response);


%>
</body>
</html>