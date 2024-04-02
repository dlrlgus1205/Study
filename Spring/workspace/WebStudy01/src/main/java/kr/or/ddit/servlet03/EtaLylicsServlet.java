package kr.or.ddit.servlet03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	사용자로부터 /eta 요청을 받고, 
 * 	컨텐츠 폴더에 있는 eta_utf-8.txt 파일에 있는 가사를 컨텐츠로 서비스
 *
 */
@WebServlet("/eta")
public class EtaLylicsServlet extends HttpServlet {
	private ServletContext Application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		
		File txtFile = new File("D:/00.medias/ETA_UTF8.txt");
		if(!txtFile.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "파일 없음");
		}
		String mime = Application.getMimeType(txtFile.getName());
		resp.setContentType(mime);
		if(mime == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "확장자 다름");
		}
		resp.setContentLengthLong(txtFile.length());
		
		try(
			InputStream is = new FileInputStream(txtFile);
			OutputStream os = resp.getOutputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			){
			int length = -1;
			while((length = bis.read()) != -1) { // EOF 문자 : -1
				bos.write(length);
			}
		}
	}
}
