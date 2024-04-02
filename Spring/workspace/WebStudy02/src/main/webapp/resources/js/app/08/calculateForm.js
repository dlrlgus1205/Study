/**
 * 
 */
let forms = document.forms;
forms[0].addEventListener("submit", e=>{
	e.preventDefault(); // 동기를 중단시키는 함수
	let form = e.target;
	
	// request line
	let url = form.action;
	let method = form.method;
	
	// request header
	let headers = {
		"content-type" : form.enctype,
		"accept" : "text/html"
	}
	
	// request body
	let formData = new FormData(form);
	console.log(new URLSearchParams(formData).toString());
	let body = new URLSearchParams(formData).toString();
	
	let options = {
		method : method,
		headers : headers
	}
	
	if(method =="get"){
		url  = `${url}?${body}`;
	}
	else {
		options.body = body;
	}
	fetch(url, options)
		.then(resp=>{
			if(resp.ok){
				return resp.text();
			}
			else{
				throw new Error(`에러 발생, 상태코드 : ${resp.status}`);
			}
		}).then(html=>{
			// document.body.append(html);
			// document.body.innerHTML = document.body.innerHTML + html;
			let parser = new DOMParser();
			let newDoc = parser.parseFromString(html, 'text/html');
			let h4Element = newDoc.querySelector("h4");
			resultArea.append(h4Element);
		})
		.catch(err=>console.log(err));
});