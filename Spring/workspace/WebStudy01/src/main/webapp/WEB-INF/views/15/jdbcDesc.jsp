<%@page import="kr.or.ddit.db.ConnectionFactory"%>
<%@page import="kr.or.ddit.utils.NamingUtils"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>JDBC(Java DataBase Connectivity) 프로그래밍 방법론</h4>
<pre>
	1. jdbc 드라이버를 빌드패스에 로딩
		/WEB-INF/lib/ojdbc6.jar
	2. classloader 를 이용해 드라이버를 메모리에 로딩
	3. 연결(Connection) 수립
	4. 쿼리 객체 생성
		- Statement
		- PreparedStatement
		- CallableStatement
	5. 쿼리 실행
		- ResultSet executeQuery : SELECT
		- int executeUpdate : INSERT, UPDATE, DELETE 
	6. 결과 집합 핸들링
	7 Connection, Statement, ResultSet release
</pre>
<table border = "1">
	<thead id = "head-area">
		<tr>
<%-- 			<c:forEach items="${headers}" var="colName"> --%>
<%-- 				<th>${colName}</th> --%>
<%-- 			</c:forEach> --%>
		</tr>
	</thead>
	<tbody id = "body-area">
<%-- 		<c:forEach items="${list}" var="map"> --%>
<!-- 			<tr> -->
<%-- 				<c:forEach items="${propsName}" var="propsName"> --%>
<%-- 					<td>${map[propsName]}</td> --%>
<%-- 				</c:forEach> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
	</tbody>
</table>
<script type="text/javascript" src = "<c:url value = '/resources/js/app/15/jdbcDesc.js' />">
</script>
</body>
</html>