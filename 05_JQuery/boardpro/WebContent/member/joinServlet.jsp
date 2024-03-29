<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 //controller servlet이다
 StringBuffer buf = new StringBuffer();
String line = null;

BufferedReader reader = request.getReader();
while((line = reader.readLine()) != null){
	buf.append(line);
};

String reqdata = buf.toString(); //{"prod_lgu" : "P101"}

//역직렬화 - 객체 형태로 변환
Gson gson = new Gson();
MemberVo vo = gson.fromJson(reqdata, MemberVo.class);

//service 객체 얻어오기
IMemberService service = MemberServiceImpl.getInstance();

//service메소드 호출 - 결과값 받기
int res = service.insertMember(vo);

//결과값을 request에 저장
request.setAttribute("res", res);

//view페이지로 이동
request.getRequestDispatcher("/member/joinView.jsp").forward(request, response);

%>
</body>
</html>