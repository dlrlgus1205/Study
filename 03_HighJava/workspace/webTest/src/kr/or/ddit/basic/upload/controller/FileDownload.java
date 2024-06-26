package kr.or.ddit.basic.upload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.upload.service.FileInfoServiceImpl;
import kr.or.ddit.basic.upload.service.IFileInfoService;
import kr.or.ddit.basic.upload.vo.FileInfoVo;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/fileDownload.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 보내온 파일 번호를 구한다.
		String strFileNo = request.getParameter("fileno");
		int fileno = Integer.parseInt(strFileNo);
		
		// 파일 번호를 이용하여 DB에서 해당 파일에 대한 정보를 가져온다.
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		FileInfoVo fvo = service.getFileinfo(fileno);
		
		// 업로드된 파일들이 저장될 폴더 설정(서버 컴퓨터 기준)
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 저장될 폴더가 없으면 새로 생성한다.
		File f = new File(uploadPath);
		
		if(!f.exists()) {
			f.mkdir();
		}
		//--------------------------------------------------------------------
		response.setCharacterEncoding("utf-8");
		
		// 다운로드 받을 파일 정보를 갖는 File 객체 생성 ==> 실제 저장된 파일명을 이용하여 생성한다.
		File downFile = new File(f, fvo.getSave_file_name());
		
		if(downFile.exists()) { // 해당 파일이 있을 때 처리 ...
			// Download할 때의 ContentType 설정
			response.setContentType("application/octet-stream; cahrset=utf-8");
			
			// 응답(Response) 객체의 Header 값을 설정한다.
			String headerKey = "content=disposition";
			
			// 이 Header의 value 값으로는 클라이언트에 저장될 파일 명을 지정해주면 된다. ==> 원래의 파일명으로 지정한다.
			
			// 방법1 ==> 파일 명에 한글이 포함 안됐을 때 (예전 방식)
			// String headerValue = "attachment; filename = \" fvo.getOrigin_file_name() \"";
			
			// 방법2 ==> 파일 평에 한글이 포함됐을 때
			String headerValue = "attachment; filename*=utf-8''" + URLEncoder.encode(fvo.getOrigin_file_name(), "utf-8").replace("\\+", "%20");
			
			response.setHeader(headerKey, headerValue);
			
			// 파일 입출력 명령을 이용하여 서버에 저장된 파일을 읽어서 클라이언트에게 전송한다.
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;

			try {
				// 출력용 스트림 객체 생성 ==> Response 객체를 이용하여 생성한다.
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입출력 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(downFile));
				
				byte[] buffer = new byte[1024];
				int len;
				while((len = bin.read(buffer)) > 0){
					bout.write(buffer, 0, len);
				}
				bout.flush();
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bin != null) try {bin.close();} catch(IOException e) {}
				if(bout != null) try {bout.close();} catch(IOException e) {}
			}
		}
		else { // 파일이 존재하지 않을 때 ...
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + fvo.getOrigin_file_name() + "파일이 존재하지 않습니다.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
