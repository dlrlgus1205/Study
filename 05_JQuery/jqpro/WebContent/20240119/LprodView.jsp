<%@page import="kr.or.ddit.lpord.vo.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<LprodVo> list = (List<LprodVo>) request.getAttribute("listval"); 
%>
[
<%
	for(int i = 0; i < list.size(); i++){
		LprodVo vo = list.get(i);
		if(i > 0) out.print(", ");
%>		
		{
			"lprod_id" : "<%= vo.getLprod_id() %>",
			"lprod_gu" : "<%= vo.getLprod_gu() %>",
			"lprod_nm" : "<%= vo.getLprod_nm() %>"
		}
<%
	}
%>
]