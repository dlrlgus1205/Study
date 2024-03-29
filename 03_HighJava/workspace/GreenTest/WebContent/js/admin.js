/**
 * 
 */
memPageList = function(){
	//검색 type과 검색어 가져오기
	vtype = value;
	vword = $('.inputset-input').val();
	$.ajax({
		url : `${mypath}/memPage.do`,
		type : 'post',
		data : {
			"page" : currentPage,
			"stype": vtype,
			"sword": vword
		},
		success : function(res){
	    	code="";
	        code =`<div class="tableset">
			        <table class="tableset-table table">
			          <colgroup>
			            <col>
			            <col>
			            <col>
			            <col>
			            <col>             
			          </colgroup>
			          <thead class="thead-light thead-border-top">
			            <tr>
			              <th scope="col">아이디</th>
			              <th scope="col">이름</th>
			              <th scope="col">닉네임</th>
			              <th scope="col">전화번호</th>
			              <th scope="col">메일</th>
			              <th scope="col">탈퇴</th>
			            </tr>
			          </thead>
			          <tbody>`;
	        $.each(res.datas, function(i,v){
	        code += 
			            `<tr>
		                  <td class="tableset-mobile">${v.mem_id}</td>
		                  <td class="tableset-mobile">${v.mem_name}</td>
		                  <td class="tableset-mobile">${v.mem_nickname}</td>
		                  <td class="tableset-mobile">${v.mem_tel}</td>
		                  <td class="tableset-mobile">${v.mem_mail}</td>
		                  <td class="tableset-mobile">
						  <input type="button" class="badgeset btnUnBlack" id="btn"
						  value="회원 탈퇴" onclick="deleteMember('${v.mem_id}')">
						  </td>
		                </tr>`;
	                  
	           })//$.each반복문
			code += ` </tbody>
		            </table>
		          </div>`

		$('#result').html(code);
		
		pager = pageList(res.sp,res.ep,res.tp)
			$('#target2').html(pager);
		
	    },
		error : function(xhr){
			alert("상태 : " +xhr.status);
		},
		dataType : 'json'
	})
}



pageList = function(sp,ep,tp){
	pager = "";
	//이전버튼
	if(sp>1){
		pager += `<div class="pagiset-ctrl">
              <a class="pagiset-link pagiset-prev" href="javascript:void(0)" id="prev">
                <span class="visually-hidden">이전</span>
              </a>
            </div>`;
	}
	pager += '<div class="pagiset-list">';
	//페이지번호
	for(i=sp; i<=ep; i++){
		if(i==currentPage){
			pager+= `<a class="pagiset-link active-fill pageno" href="javascript:void(0)">${i}</a>`;
		}else{
			pager+=`<a class="pagiset-link pageno" href="javascript:void(0)">${i}</a>`;
		}
	}
	pager += "</div>";
	//다음	
	if(tp>ep){
		pager += `<div class="pagiset-ctrl">
              <a class="pagiset-link pagiset-next" href="javascript:void(0)"id="next">
                <span class="visually-hidden">다음</span>
              </a>
            </div> `;
	}
	
	return pager;
}

/////////////////////////////////////////회원관리 함수/////////////////////////////////////////////////////////////


/////////////////////////////////////////게시판관리 함수/////////////////////////////////////////////////////////////

postPageList = function(){
	//검색 type과 검색어 가져오기
	vtype = value;
	vword = $('.inputset-input').val();
	$.ajax({
		url : `${mypath}/postPage.do`,
		type : 'post',
		data : {
			"page" : currentPage,
			"stype": vtype,
			"sword": vword
		},
		success : function(res){
	    	code=""; 
	        code =`<div class="tableset">
			        <table class="tableset-table table">
			          <colgroup>
			            <col>
			            <col>
			            <col>
			            <col>
			            <col>             
			          </colgroup>
			          <thead class="thead-light thead-border-top">
			            <tr>
			              <th scope="col">번호</th>
			              <th scope="col">카테고리</th>
			              <th scope="col">제목</th>
			              <th scope="col">작성자</th>
			              <th scope="col">조회수</th>
			              <th scope="col">게시글 삭제</th>
			            </tr>
			          </thead>
			          <tbody>`;
			
	        $.each(res.datas, function(i,v){
			a = "";
			if(v.category_no == 1) a = "식물위키";  
			if(v.category_no == 2) a = "잡담게시판";
			if(v.category_no == 3) a = "질문게시판";
			if(v.category_no == 4) a = "팁게시판";
			if(v.category_no == 5) a = "식물스타그램";
			if(v.category_no == 6) a = "문의게시판";
			
			
			
	        code +=    `<tr>
		                  <td class="tableset-mobile">${v.post_no}</td>
		                  <td class="tableset-mobile">${a}</td>`;


    if(a === "식물위키")     code +=  `<td class="tableset-mobile"><a href="${mypath}/wikiDetail.do?post_no=${v.post_no}">${v.post_title}</a></td>`;
	if(a === "잡담게시판")    code +=  `<td class="tableset-mobile"><a href="${mypath}/postdetail.do?no=${v.post_no}">${v.post_title}</a></td>`;
	if(a === "질문게시판")    code +=  `<td class="tableset-mobile"><a href="${mypath}/postdetail.do?no=${v.post_no}">${v.post_title}</a></td>`;
	if(a === "팁게시판")      code +=  `<td class="tableset-mobile"><a href="${mypath}/postdetail.do?no=${v.post_no}">${v.post_title}</a></td>`;
	if(a === "식물스타그램")   code +=  `<td class="tableset-mobile">${v.post_title}</td>`;
	if(a === "문의게시판")    code +=  `<td class="tableset-mobile"><a href="${mypath}/postdetail.do?no=${v.post_no}">${v.post_title}</a></td>`;

		     code +=     `<td class="tableset-mobile">${v.mem_id}</td>
		                  <td class="tableset-mobile">${v.post_count}</td>
		                  <td class="tableset-mobile">
						  <input type="button" class="badgeset btnUnBlack" id="btn"
						  value="게시글 삭제" onclick="deletePost('${v.post_no}')">
						  </td>
		                </tr>`;
	                  
	           })//$.each반복문
			
			code += ` </tbody>
		            </table>
		          </div>`;

		$('#result').html(code);
		
		pager = pageList(res.sp,res.ep,res.tp)
			$('#target2').html(pager);
		
	    },
		error : function(xhr){
			alert("상태 : " +xhr.status);
		},
		dataType : 'json'
	})
}


















