<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
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
//여기는 서블릿 controller이다 -

//요청시 전송 데이타 받기 데이타
//String memId = request.getParameter("id"); - 직렬화 되지않은 상태
		
		StringBuffer buf = new StringBuffer();
		String line = null;
		
		BufferedReader reader = request.getReader();
		while((line = reader.readLine())!= null){
			buf.append(line);
		}
		
		String redata = buf.toString(); //{"mem_id" : :"korea"};
		// 역질렬화 - 객체 형태로 변환
		Gson gson = new Gson();
		MemberVo vo = gson.fromJson(redata, MemberVo.class);
		//vo.setMem_id("korea")
		String memId = vo.getMem_id();
		System.out.println("------------------" + memId);
		
		//service객체 얻기
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		//service메소드 호출 - 결과값 받기
		String res = service.searchMemId(memId);
		//결과값을 request에 저장
		request.setAttribute("result", res);
		//view페이지로 이동
		request.getRequestDispatcher("/Promember/idView.jsp").forward(request, response);
		
%>



</body>
</html>