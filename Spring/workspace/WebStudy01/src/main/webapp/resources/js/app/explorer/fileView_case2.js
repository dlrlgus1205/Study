/**
 * 
 */
// 선택지 모두 선택
/*let folder = document.querySelectorAll('li.folder>a');
// 배열로 저장되기 때문에 forEach로 하나씩 이벤트 등록
folder.forEach((fold) => {
	fold.addEventListener("click", e => {
		e.preventDefault();
	});
	
	fold.addEventListener("dblclick", e => {
		let target = e.target;
		window.location.href = target.href;
	});
});
*/
const cPath = document.body.dataset.contextPath;
const log = console.log;
document.querySelectorAll("li.folder>a").forEach(a=>{
	a.addEventListener("click", e => {
		e.preventDefault();
		
		let type = a.dataset.click;
		let url = `${a.href}&type=${type}`;
		let method = "get";
		let headers = {
			"accept" : "application/json"
		}
		
		fetch(url, {
			method : method,
			headers : headers
		}).then(resp=>resp.json())
		.then(outer=>{
			let jsonObj = outer.wrapperList;
//			log(jsonObj);
			let ulTag = `<ul class "col-6">`;
			for(let obj of jsonObj){
				ulTag += `<li data-name="${obj.name}" id="${obj.path}" class="${obj.file ? 'file' : 'folder'}"> ${obj.name} </li>`;
			}
			ulTag +=`</ul>`;
			
			window['right-area'].innerHTML = ulTag;
			
		}).catch(e=>console.error(e));
	});
	
	a.addEventListener("dblclick", e => {
		e.preventDefault();
		let type = a.dataset.dblclick;
		let url = `${a.href}&type=${type}`;
		window.location.href = url;
	});
});

window['right-area'].addEventListener("click", e=>{
	if(!e.target.classList.contains("file")){
		return false;
	}
	let url = `${cPath}/case2/fileInfo`;
	let method = "get";
	let headers = {
		"accept" : "application/json"		
	};
	
	let urlSearchParams = new URLSearchParams();
	let path = e.target.id;
	urlSearchParams.append("path", path);
	
	let queryString = urlSearchParams.toString();
		
	fetch(`${url}?${queryString}`, {
		method : method,
		headers : headers
	}).then(resp=>resp.json())
	.then(jsonObj=>{
		log(jsonObj.size);
		e.target.innerHTML = e.target.dataset.name + ", " + jsonObj.size;
	}).catch(err=>console.error(err));
})