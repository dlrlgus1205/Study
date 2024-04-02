/**
 * 
 */
document.addEventListener("DOMContentLoaded", () => {
	let trList = document.querySelectorAll("tr[data-mem-id]");
	let id = "";
	let url = document.body.dataset.url;

	for (let tr of trList) {
		tr.addEventListener("click", function() {
			console.log(this.dataset.memId);
			id = this.dataset.memId;

			$.ajax({
				type: "get",
				url: url + "/member/memberDetail.do",
				headers: {
					"Content-Type": "application/json"
				},
				dataType: "json",
				data: {
					"who": id
				},
				success: function(res) {
					// 성공시 수행할 작업
					let member = res.member;
					
					// <td>${m}</td> >> key 값
					// <td>${member[m]}</td> value 값
					let modal = `<table>`;
						for(let m in member){
							modal += `<tr>
										<td>${m}</td>
										<td>${member[m]}</td>
									</tr>`;
						}
					modal += `</table>`;
					
					// 값 출력
					document.querySelector(".modal-body").innerHTML = modal;
				},
				error: function(xhr) {
					console.error(xhr);
				}
			});
		});
	}
});