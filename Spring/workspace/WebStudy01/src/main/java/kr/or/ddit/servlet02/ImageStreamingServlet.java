package kr.or.ddit.servlet02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image.do")
public class ImageStreamingServlet extends HttpServlet {
	private ServletContext application;
	private String imageFolder;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
		imageFolder = application.getInitParameter("imageFolder");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		File imageFolderPath = new File(imageFolder);
		
		if(name == null || name.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "이미지 파일명이 없음");
			return;
		}
		
		File imageFile = new File(imageFolderPath, name);
		if(!imageFile.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, String.format("%s 파일은 없음", name));
			return;
		}
		
		String mime = application.getMimeType(imageFile.getName());
		if(mime == null	) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "확장자가 다름");
			return;
		}
		
		Cookie imageCookie = new Cookie("imageCookie", URLEncoder.encode(name, "UTF-8"));
		imageCookie.setPath(req.getContextPath());
		imageCookie.setMaxAge(60 * 60 * 24 * 3);
		resp.addCookie(imageCookie);
		
		resp.setContentType(mime);
		resp.setContentLengthLong(imageFile.length());
		
		try(
			InputStream is = new FileInputStream(imageFile);
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
