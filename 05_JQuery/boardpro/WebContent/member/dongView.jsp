<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.ZipVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//controller에서 저장한 데이터 꺼내기
	List<ZipVo> list = (List<ZipVo>)request.getAttribute("result");
	//list객체를 json형태의 문자열로 직렬화 보내기
	
	Gson gson = new Gson();
	String res = gson.toJson(list);	// [ {  },{  },{  },{  } ]
			
	
	out.print(res);
	out.flush();





%>


