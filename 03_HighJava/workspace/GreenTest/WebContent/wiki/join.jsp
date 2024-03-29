<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>


<script>
  $(document).ready(function() {
      $('#summernote').summernote({
    	    placeholder : '내용을 입력해주세요.',
    	    lang : 'ko-KR',              
			height: 300,                 
			minHeight: null,            
			maxHeight: null,            
			focus: true,
			callbacks: {
				onImageUpload : function(files, editor, welEditable){
					for (var i = files.length - 1; i >= 0; i--) {
                        var fileName = files[i].name;
					}
				}
			}
      });
      
       $('form[name="form"]').submit(function(e) {
          var title = $('input[name="title"]').val();
          var content = $('#summernote').summernote('code');
       	  // Summernote의 내용을 textarea에 넣어줍니다.
          $('#hiddenContent').val(content);
       	  
      });
      
      //이미지 업로드 함수
       function uploadImage(file, editor, caption) {
          var data = new FormData();
          data.append("file", file);
          $.ajax({
              data: data,
              type: "post",
              url: `<%=request.getContextPath()%>/uploadImage.do`, 
              enctype: 'multipart/form-data',
              contentType: false,
              processData: false,
              success: function(url) {
            	  $(el).summernote(
                      'editor.insertImage',
                      data.url,
                      function ($image) {
                          $image.attr('alt', caption) // 캡션 정보를 이미지의 alt 속성에 설정
                      }
                  )
           	  },
              error: function(data) {
                  console.log("Error uploading image");
              }
          });
      }
  });
</script>
</head>
<body>
<form name="form" method="post" action="<%=request.getContextPath()%>/jointest.do">
	<table>
		<tbody>
		<tr>
			<td><input type="text" name="title" placeholder="제목을 입력해주세요."></td>
		</tr>
		 <!-- Summernote의 내용을 담을 hidden textarea -->
        <tr>
            <td><textarea id="summernote" style="display:none;"></textarea></td>
        </tr>
        <!-- Summernote의 내용을 담을 hidden textarea -->
        <tr>
            <td><textarea id="hiddenContent" name="content" style="display:none;"></textarea></td>
        </tr>
		<tr><input type="submit"></tr>
		</tbody>
	</table>
</form>

</body>
</html>