<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//servlet에서 저장한 데이타 꺼내기
ProdVO   vo = (ProdVO)request.getAttribute("vo");

%>

{
   "prod_id"    : "<%= vo.getProd_id() %>",
   "prod_name"  : "<%= vo.getProd_name() %>",
   "prod_lgu"   : "<%= vo.getProd_lgu() %>",
   "prod_buyer" : "<%= vo.getProd_buyer() %>",
   "prod_price" : "<%= vo.getProd_price() %>",
   "prod_cost"  : "<%= vo.getProd_cost() %>",
   "prod_sale"  : "<%= vo.getProd_sale() %>"
}