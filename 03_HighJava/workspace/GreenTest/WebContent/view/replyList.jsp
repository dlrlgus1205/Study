<%@page import="reply.vo.ReplyVO"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<%
//서블릿에서 데이터 꺼내기

List<ReplyVO> list =(List<ReplyVO>)request.getAttribute("list");

Gson gson = new GsonBuilder().setPrettyPrinting().create();

String result = gson.toJson(list);

out.print(result);
out.flush();



%>