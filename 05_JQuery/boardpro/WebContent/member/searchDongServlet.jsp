<%@page import="kr.or.ddit.member.vo.ZipVo"%>
<%@page import="java.util.List"%>
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
	//요청시 전송 데이터 받기
	request.setCharacterEncoding("UTF-8");
	String dong = request.getParameter("dong");
	//service객체 얻기
	MemberServiceImpl service = MemberServiceImpl.getInstance();
	//service메소드 호출 - 결과값 받기
	List<ZipVo> list = service.selectByDong(dong);
	//결과값을 request에 저장
	request.setAttribute("result", list);
	//view페이지로 이동
	request.getRequestDispatcher("Promember/dongView.jsp").forward(request, response);

%>
</body>
</html>