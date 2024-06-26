package kr.or.ddit.basic.upload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.upload.service.FileInfoServiceImpl;
import kr.or.ddit.basic.upload.service.IFileInfoService;
import kr.or.ddit.basic.upload.vo.FileInfoVo;

// DB에 저장된 파일 전체 목록을 가져와 View페이지로 보내는 Servlet => Controller
@WebServlet("/fileList.do")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Service객체 생성
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		
		//DB에서 파일 목록을 가져와 List에 저장하기
		List<FileInfoVo> fileList = service.getAllFileinfo();
		
		//가져온 List데이터를 Request에 저장하기
		request.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/basic/uploadFile/fileList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
