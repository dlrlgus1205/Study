/**
 * 
 */
let aTags = document.querySelectorAll("a");
console.log(aTags);
aTags.forEach(v=>{
	v.addEventListener("click", e=>{
		e.preventDefault(); // 동기 중단
		let url = e.target.href;
		let p5 = v.dataset.p5
		let options = {
			method:"post",
			headers:{
				"Accept" : "text/html",
				"Content-type":"application/x-www-form-urlencoded"
			},
			body:"p5="+p5
		};
		fetch(url, options)
			.then(resp=>{
				if(resp.ok){
					return resp.text();
				}
				else{
					throw new Error(`요청 처리 실패, 상태코드 : ${resp.status}`);
				}
			}).then(obj=>{
				let parser = new DOMParser();
				let newDoc = parser.parseFromString(obj, 'text/html');
				let h4Element = newDoc.querySelector("h4");
				msgArea.append(h4Element);
			})
			.catch(err=>console.log(err));
	});
});