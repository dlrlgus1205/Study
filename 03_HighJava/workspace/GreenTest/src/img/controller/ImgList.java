package img.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import img.service.IImgService;
import img.service.ImgServiceImpl;
import img.vo.ImgVO;

/**
 * Servlet implementation class ImgList
 */
@WebServlet("/imgList.do")
public class ImgList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		IImgService service = ImgServiceImpl.getInstance();
		
		List<ImgVO> imgList = service.getAllImg();
		
		request.setAttribute("imgList", imgList);
		request.getRequestDispatcher("/view/imgList.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
