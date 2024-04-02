/**
 * 
 */
// document.addEventListener("DOMContentLoaded", ()=>{
// 	mbti-form.addEventListener("change", (e)=>{
// 		e.target.form.requestSubmit();
// 	});
// });

// submit에서 기본 액션 취소
// Fetch Line Header Body

// 대상이 되는 form을 셀렉팅
console.log(window['mbti-form']);
// form 이벤트 핸들링(submit)
window['mbti-form'].addEventListener("submit", e=>{
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
	}).then(resp=>resp.text())
	.then(html=>{
		// let newDocument = new DOMParser().parseFromString(html, headers.accept);
		// let element = newDocument.querySelector("pre");
		// window['mbti-area'].append(element);
		window['mbti-area'].innerHTML = html;
	})
	.catch()
});