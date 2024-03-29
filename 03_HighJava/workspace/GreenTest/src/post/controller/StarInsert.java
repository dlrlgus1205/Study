package post.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import img.service.IImgService;
import img.service.ImgServiceImpl;
import img.vo.ImgVO;
import post.service.IPostService;
import post.service.PostServiceImpl;
import post.vo.PostVO;

/**
 * Servlet implementation class StarInsert
 */
@WebServlet("/starInsert.do")
@MultipartConfig
public class StarInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/html/starWriter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uploadPath = "D:\\D_other\\uploadFiles";
		
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		request.setCharacterEncoding("UTF-8");
		
		String writer = request.getParameter("writer");
//		String title = request.getParameter("title");
//		int category_no = request.getParameter("")
		String content = request.getParameter("content");
		
		System.out.println("섹시한 이기현 사랑해============="+content);
		
		PostVO postVo = new PostVO();
//		postVo.setMem_id(writer);
		postVo.setPost_title("test1");
		postVo.setPost_content(content);
		postVo.setCategory_no(5);
		postVo.setBoard_no(3);
		postVo.setMem_id("test");
		
		//--------------------------------------------------
		/*
		 * List<ImgVO> fileList = new ArrayList<ImgVO>();
		 * 
		 * for(Part part : request.getParts()) {
		 * 
		 * String fileName = extractFileName(part); //upload한 파일 이름 구하기
		 * 
		 * //찾은 파일 이름이 null이면 파일이 아닌 일반 파라미터 데이터 가 된다 if(fileName!=null) { //파일인지 검사
		 * 
		 * //1개의 ㅇ파일 정보가 저장될 FileInfoVo 객체 생성 ImgVO fvo= new ImgVO();
		 * 
		 * //
		 * 
		 * int post_no = 0; // post no를 구하는 매서드 작성
		 * 
		 * fvo.setPost_no(post_no);
		 * 
		 * //실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 UUID객체를 //이용하여 저장할 파일명을 만든다 String
		 * saveFileName =UUID.randomUUID().toString() + "_" + fileName;
		 * 
		 * // 새로 만든 파일명을 VO객체에 '저장된파일명'으로 저장 fvo.setImg_name(saveFileName);
		 * 
		 * fvo.setImg_path(uploadPath); // 파일 경로 저장 //Part객체.getSize() ==> Upload된 파일의
		 * 크기 반환 (단위: byte)
		 * 
		 * try { //Upload도니 파일을 지정한 업로드 폴더에 저장하기 //저장하는 메서드 ==> Part객체.write()메서드 이용
		 * part.write(uploadPath + File.separator+ saveFileName); } catch (IOException
		 * e) { // TODO: handle exception e.printStackTrace(); } //Upload된 파일 정보를 List에
		 * 추가하기 fileList.add(fvo); }//if문 끝...
		 * 
		 * }//for문 끝...
		 * 
		 * 
		 */
				  
		  IPostService service = PostServiceImpl.getInstance();
		  IImgService imgService = ImgServiceImpl.getInstance();
		  
		  int cnt = service.starInsert(postVo);
		  
		  if(cnt>0) { 
		 
		//------------------------------------------------------------------------
		int postNo = postVo.getPost_no();

		// 파일이 아닌 일반 데이터는 getParameter()메서드나 getParameterValues()메서드를 이용해서 구한다
//		int postNo = Integer.parseInt(request.getParameter("postno"));
//		System.out.println("일반 파라미터 데이터 ==> " +postNo);
		//--------------------------------------------------
		//수신 받은 파일 데이터 처리하기
		
		//upload한 파일이 여러 개 일 경우에 파일 목록이 저장될 List객체 생성
		List<ImgVO> fileList = new ArrayList<ImgVO>();
		
		/*
		 	- 서블릿 3.0이상에서 새롭게 추가된 Upload용 메서드
		 	1) Request객체.getParts() ==> 전체 Part객체에 담아서 반환한다.
		 	
		 	2) Request.getPart("이름")
		 				==> 지정된 '이름'을 가진 개별 Part객체를 반환한다.
		 				'이름' ==> <form>태그 안에 입력요소의 name속성값으로 구별한다.
		 */
		//전체 Part 객체 개수 만큼 반복 처리
			for(Part part : request.getParts()) {
				
				String imgName = extractFileName(part); //upload한 파일 이름 구하기
				
				//찾은 파일 이름이 null이면  파일이 아닌 일반 파라미터 데이터 가 된다
				if(imgName!=null && !"".equals(imgName)) { //파일인지 검사
					
					//1개의 ㅇ파일 정보가 저장될 FileInfoVo 객체 생성
					ImgVO fvo= new ImgVO();
					
					
					//실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 UUID객체를
					//이용하여 저장할 파일명을 만든다
					String saveFileName =UUID.randomUUID().toString() + "_" + imgName;
					
					// 새로 만든 파일명을 VO객체에 '저장된파일명'으로 저장
					fvo.setImg_name(saveFileName);
					fvo.setImg_path(uploadPath);
					fvo.setPost_no(postNo);
					
					//Part객체.getSize() ==> Upload된 파일의 크기 반환 (단위: byte)
					
					//byte단위의 파일 크기를 KB단위로 변환해서 VO에 저장
					
					try {
						//Upload도니 파일을 지정한 업로드 폴더에 저장하기
						//저장하는 메서드 ==> Part객체.write()메서드 이용
						part.write(uploadPath + File.separator+ saveFileName);
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					//Upload된 파일 정보를 List에 추가하기
					fileList.add(fvo);
				}//if문 끝...
				
			}//for문 끝...
			//List에 추가된 파일 정보들을 DB에 저장한다.
//			IImgService service = ImgServiceImpl.getInstance();
			
			for(ImgVO fvo : fileList) {
				imgService.insertImg(fvo);
			}
		
		  }
		
		response.sendRedirect(request.getContextPath()+"/starList.do?bono="+postVo.getBoard_no());
	}


	public String extractFileName(Part part) {
		String fileName =null;  //반환값이 저장될 변수 (파일명)이 저장될 변수
	
		
		String dispositionStr =part.getHeader("content-disposition");
		String[] itemArr = dispositionStr.split(";");
		
		for(String item : itemArr) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
				break;
			}
		}
		
		return fileName;
	}

}
