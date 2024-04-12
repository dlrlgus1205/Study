/**
 * 
 */
window['ua-btn'].addEventListener("click", (e)=>{
	let agent = window.navigator.userAgent;
	
	const BrowserInfo = {
		EDG : "엣지",
		WHALE : "웨일",
		CHROME : "크롬",
		OTHERS : "기타",
		
		findBrowserName : function(agent) {
			agent = agent.toUpperCase();
			let browserName = this.OTHERS;
			for(let prop in this){
				if(agent.indexOf(prop) >= 0){
					browserName = this[prop];
					break;
				}
			}
			return browserName;
		}
	}
	
	BrowserInfo['SAFARI'] = "사파리";
	
	let brName = BrowserInfo.findBrowserName(agent);
	
	msgArea.innerHTML = brName;
});


// let aTags = document.querySelectorAll("a.asyncA");
document.addEventListener("click", (e)=>{
	if(!e.target.classList.contains("asyncA")) return false;
	e.preventDefault();
	
	let aTag = e.target;
	let url = aTag.href;
	let method = aTag.dataset.method ?? "get";
	let headers = {
		"accept" : "text/html"	
	}
	
	let options = {
		method : method,
		headers : headers
	}
	
	fetch(url, options)
		.then(resp=>{
			if(resp.ok){
				return resp.text();
			}
			else{
				throw new Error(`처리 실패, 상태 코드 : ${resp.status}`)
			}
		}).then(html=>{
			msgArea.innerHTML = html;
		})
		.catch()
});

/*document.addEventListener("click", (e)=>{
	if(!e.target.classList.contains("navi")) return false;

	let btn = e.target;
	let url = btn.href;
	
	let browserName = "";
	
	let uA = window.navigator.userAgent;
	if(uA.contains("EDG")) {
		browserName = "엣지";
	}
	else if(uA.contains("WHALE")) {
		browserName = "웨일";
	}
	else if(uA.contains("CHROME")) {
		browserName = "크롬";
	}
	else if(uA.contains("SAFARI")) {
		browserName = "사파리";
	}
	else {
		browserName = "기타";
	}
	
	fetch(url)
		.then(resp=>{
			if(resp.ok){
				return resp.text();
			}
			else{
				throw new Error(`처리 실패, 상태 코드 : ${resp.status}`)
			}
		}).then(browserName=>{
			msgArea.innerHTML = browserName;
		})
		.catch()
})*/