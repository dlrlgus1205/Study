<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name="calForm" method="post">
	<input type="number" name="leftOp" value="${leftOp }"/>
	+
	<input type="number" name="rightOp" value="${rightOp }"/>
	<button type="submit">=</button>
	<span id="result-area">${result }</span>
</form>
<script>
	const $resultArea = $("#result-area");
	$("[name='calForm']").on("submit", function(event){
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize();
		$.ajax({
			url:url
			, method:method
			, data:data
			, dataType:"json" // accept : application/json
			, success:function({result}){
				$resultArea.html( result );
			}
		});
	});
</script>
