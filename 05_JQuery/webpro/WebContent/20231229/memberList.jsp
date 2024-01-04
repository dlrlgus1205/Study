<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Style>
table{
	border : 1px solid skyblue;
}
td{
	border : 1px solid skyblue;
	text-align: center;
	width : 150px;
	margin : 10px;
	padding : 10px;
}
</Style>
</head>
<body>
<%!
private  Connection conn = null;
private ResultSet rs = null;
private PreparedStatement ps = null;

private String driver = "oracle.jdbc.driver.OracleDriver";
private String url = "jdbc:oracle:thin:@localhost:1521:xe";
private String user = "kbs93";
private String password = "java";
%>

<%
   
   //OracleDriver클래스를 로드시킨다 
   Class.forName(driver);

   //db 연결객체
   conn= DriverManager.getConnection(url,user, password);
   
   //sql쿼리문 작성
   String sql ="select mem_id,mem_name,mem_hp from member";
   
    //실행 객체 
   ps = conn.prepareStatement(sql);
    
   //실행 
   rs =  ps.executeQuery();

%>
<table>
<tr>
<td>아이디</td>
<td>이름</td>
<td>전화번호</td>
</tr>
<%
while(rs.next()){%>
	<tr>
	<td><%=rs.getString("mem_id")%></td>
	<td><%=rs.getString("mem_name")%></td>
	<td><%=rs.getString("mem_hp")%></td>
	</tr>
<% }

%>
</table>
</body>
</html>