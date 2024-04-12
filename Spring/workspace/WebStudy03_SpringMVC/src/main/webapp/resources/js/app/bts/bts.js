/**
 * 
 */
let btsForm = document.forms[0]; 

btsForm.addEventListener("submit", e=>{
	e.preventDefault();
	
	let form = e.target;
	
	// Line
	let url = form.action;
	let method = form.method;
	
	// Header
	let headers = {
		"accept" : "text/html",
		"content-type" : form.enctype
	}
	
	let fd = new FormData(form);
	let queryString = new URLSearchParams(fd).toString();
	
	// Body
	let body = queryString;
	
	fetch(url, {
		method : method,
		headers : headers,
		body : body
	}).then(resp => resp.text())
	.then(html=>{
		area.innerHTML = html;			
	}).catch(e=>console.error(e))
})