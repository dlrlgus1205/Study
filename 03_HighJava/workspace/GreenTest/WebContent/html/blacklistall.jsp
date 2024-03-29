<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="blacklist.vo.BlacklistVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
    //서블릿에서 저장한 데이터 꺼내기
    
    List<BlacklistVO> list = (List<BlacklistVO>)request.getAttribute("list");
    int startp = (Integer)request.getAttribute("start");
    int endp = (Integer)request.getAttribute("end");
    int totalp = (Integer)request.getAttribute("total");
    int totalPost = (Integer)request.getAttribute("totalPost");
    
    
    JsonObject obj = new JsonObject();
    obj.addProperty("sp", startp);
    obj.addProperty("ep", endp);
    obj.addProperty("tp", totalp);
    obj.addProperty("totalPost", totalPost);
    
    Gson gson = new Gson();
    JsonElement jele = gson.toJsonTree(list);
    obj.add("datas", jele);
    //String result = gson.toJson(list);

   // out.print(result);
    out.print(obj);
    out.flush();
    
    
    %>