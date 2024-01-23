<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
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
	// Controller 역할 - jsp, Servlet, Spring
	
	// 클라이언트 전송 시 데이터 받기
	
	// service 객체 얻기
	IMemberService service = MemberServiceImpl.getService();
	
	// service 메소드 호출 - 결과값 받기
	List<MemberVo> list = service.getAllMember();
	
	// 결과값을 request에 저장
	request.setAttribute("listval", list);
	
	// 결과값을 출력 - view 페이지로 이동
	// 결과값을 공유 - forward
	request.getRequestDispatcher("/20240119/MemberView.jsp").forward(request, response);
%>
</body>
</html>