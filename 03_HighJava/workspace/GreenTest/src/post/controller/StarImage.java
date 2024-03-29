package post.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import img.service.IImgService;
import img.service.ImgServiceImpl;
import img.vo.ImgVO;

/**
 * Servlet implementation class StarImage
 */
@WebServlet("/starImage.do")
public class StarImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String strImgno =request.getParameter("imgno");
		int imgno = Integer.parseInt(strImgno);
		
		IImgService service = ImgServiceImpl.getInstance();
		ImgVO ivo = service.getImg(imgno);
		
		String uploadPath = "D:\\D_other\\uploadFiles";
		
		//저장된 폴더가 없으면 새로 생성한다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		String imgPath = uploadPath + File.separator + ivo.getImg_name();
		System.out.println(imgPath);
		File file = new File(imgPath);
		
		if(file.exists()) {
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			try {
				bout = new BufferedOutputStream(response.getOutputStream());
				//파일 입력용
				bin = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				while((len = bin.read(temp))>0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
				
			} catch (Exception e) {
				System.out.println("파일 입출력 오류 :" + e.getMessage());
			}finally {
				if(bin!=null) try {bin.close();}catch(IOException e) {}
				if(bout!=null) try {bout.close();}catch(IOException e) {}
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
