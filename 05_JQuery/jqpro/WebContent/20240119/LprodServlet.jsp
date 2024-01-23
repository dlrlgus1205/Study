<%@page import="kr.or.ddit.lpord.service.LprodServiceImpl"%>
<%@page import="kr.or.ddit.lpord.service.ILprodService"%>
<%@page import="kr.or.ddit.lpord.vo.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청 시 전송 데이터 받기
	
	// service 객체 얻기
	ILprodService service = LprodServiceImpl.getInstance();

	// service 메소드 호출 - 결과값 받기 - List<LprodVo>
	List<LprodVo> list = service.selectLprod();
	
	// 결과값을 requset에 저장
	request.setAttribute("listval", list);
	
	// view페이지로 이동 - forward - LprodView.jsp
	request.getRequestDispatcher("/20240119/LprodView.jsp").forward(request, response);
%>