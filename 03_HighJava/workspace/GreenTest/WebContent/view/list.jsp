<%@page import="post.vo.PostVO"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
	
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
   <%
//서블릿에서 저장한 데이터 꺼내기 
List<PostVO> list = (List<PostVO>) request.getAttribute("list");
int startp = (Integer)request.getAttribute("startPage");
int endp = (Integer)request.getAttribute("endPage");
int totalp = (Integer)request.getAttribute("totalPage");

JsonObject obj = new JsonObject();

obj.addProperty("sp", startp);
obj.addProperty("ep", endp);
obj.addProperty("tp", totalp);

Gson gson = new Gson();
//String result = gson.toJson(list);
JsonElement jele = gson.toJsonTree(list);
obj.add("datas", jele);


out.print(obj);
out.flush();
%>