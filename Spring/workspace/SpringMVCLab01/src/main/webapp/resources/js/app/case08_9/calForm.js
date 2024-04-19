/**
 * 
 */
document.calForm.addEventListener("submit", (e)=>{
	e.preventDefault();
	let form = e.target;
	let url = form.action;
	let method = form.method;
	let headers = {
		"Content-Type":"application/json",
		"Accept":"application/json"
	};
	let target = {
		leftOp : form.leftOp.value,
		rightOp : form.rightOp.value,
		operator : form.operator.value		
	};
	let body = JSON.stringify(target);
	fetch(url, {
		method:method,
		headers:headers,
		body:body
	}).then(resp=>resp.json())
	.then(cv=>console.log(cv));
});




























