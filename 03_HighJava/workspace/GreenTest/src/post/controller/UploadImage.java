package post.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uploadImage.do")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업로드할 디렉토리 경로를 설정합니다.
		String uploadPath = "D:\\D_Other\\uploadFiles";

        // 디렉토리가 존재하지 않으면 생성합니다.
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        // 이미지 파일의 이름을 생성합니다. 중복되지 않도록 UUID를 사용합니다.
        String fileName = UUID.randomUUID().toString() + ".jpg";

        // 이미지 파일을 저장할 경로를 생성합니다.
        String filePath = uploadPath + File.separator + fileName;
        
        try {
            // 이미지 파일을 업로드합니다.
            // 여기에서는 실제 파일을 업로드하지만, 실제 프로젝트에서는 DB에 이미지 파일의 경로를 저장하는 것이 일반적입니다.
            // 업로드된 파일의 경로를 DB에 저장하고, 클라이언트에게 해당 경로를 반환합니다.
            // 이 예제에서는 파일을 업로드한 후, 클라이언트에게 파일의 URL을 반환합니다.
            // 업로드된 파일의 경로를 클라이언트에게 반환합니다.
            String fileUrl = request.getContextPath() + "/" + fileName;
            response.getWriter().write(fileUrl);
        } catch (Exception e) {
            response.getWriter().write("Error uploading image");
        }
		
        
        
	}

}
