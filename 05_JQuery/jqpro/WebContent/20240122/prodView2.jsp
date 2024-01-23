<%@page import="kr.or.ddit.prod.vo.ProdVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//컨트롤러 꺼내기
ProdVo pvo = (ProdVo)request.getAttribute("result");

%>


	
		
	
	{
		"prod_id" : "<%= pvo.getProd_id() %>",
		"prod_name" : "<%=pvo.getProd_name() %>",
		"prod_lgu" : "<%=pvo.getProd_lgu() %>",
		"prod_buyer" : "<%=pvo.getProd_buyer() %>",
		"prod_cost" : "<%=pvo.getProd_cost() %>",
		"prod_price" : "<%=pvo.getProd_price() %>",
		"prod_sale" : "<%=pvo.getProd_sale() %>"
			
	}

