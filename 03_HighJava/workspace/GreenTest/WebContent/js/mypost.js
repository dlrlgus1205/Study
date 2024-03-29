

 listPageServer = function(){
	vtype = type;
	vword = $('.inputset-input').val().trim();
	
	$.ajax({
		url : `${mypath}/myPost.do`,
		method : 'post',
		data : {
			"category" : category,
			"board_no" : board,
			"page" : currentPage,
			"stype" : vtype,
			"sword" : vword
		},
		success : function(res){
			code = "";
			$.each(res.datas,function(i,v){
				code+=`<tr>
                  <td class="tableset-mobile">${v.post_no}</td>
                  <td class="tableset-tit tableset-order02">
                    <a href="/GreenTest/postdetail2.do?no=${v.post_no}">
                      <span>${v.post_title}</span>
                    </a>
                  </td>
                  <td class="tableset-order05">${v.post_write_date}</td>
                  <td class="tableset-order01">
                    <div class="badgeset">대기</div>
                  </td>
                </tr>`
			})			

			$('#total').text(res.totalPost);
			$('#target').append(code);

			pager = pageList(res.sp,res.ep,res.tp)
			$('#target2').empty();
			$('#target2').html(pager);
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

 listPageServer2 = function(){
	vtype = type;
	vword = $('.inputset-input').val().trim();
	
	$.ajax({
		url : `${mypath}/myPost.do`,
		method : 'post',
		data : {
			"category" : category,
			"board_no" : board,
			"page" : currentPage,
			"stype" : vtype,
			"sword" : vword
		},
		success : function(res){
			code = "";
			$.each(res.datas,function(i,v){
				code+=`<tr>
                  <td class="tableset-mobile">${v.post_no}</td>
                  <td class="tableset-category tableset-order03">${v.category_name}</td>
                  <td class="tableset-tit tableset-order02">
                    <a href="/GreenTest/postdetail2.do?no=${v.post_no}">
                      <span>${v.post_title}</span>
                    </a>
                  </td>
                  <td class="tableset-order05">${v.post_write_date}</td>  
                   <td class="tableset-mobile">${v.post_count}</td>
                  <td class="tableset-mobile">${v.cnt}</td>
                </tr>`
			})			

			$('#total').text(res.totalPost);
			$('#target').append(code);

			pager = pageList(res.sp,res.ep,res.tp)
			$('#target2').empty();
			$('#target2').html(pager);
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
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