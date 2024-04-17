<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<pre>
검증 대상 : ${adrs }
검증 결과 : ${requestScope["org.springframework.validation.BindingResult.adrs"] }
</pre>
<form:form method="post" modelAttribute="adrs">
	<form:input path="adrsNo" />
	<form:errors path="adrsNo" />
	<form:input path="memId" />
	<form:errors path="memId" />
	<form:input path="adrsName" />
	<form:errors path="adrsName" />
	<form:input path="adrsTel" />
	<form:errors path="adrsTel" />
	<form:input path="adrsAdd" />
	<form:errors path="adrsAdd" />
	<button type="submit">전송</button>
</form:form>