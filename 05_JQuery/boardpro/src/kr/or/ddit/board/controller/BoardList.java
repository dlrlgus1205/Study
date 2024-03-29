package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PListVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.config.StreamData;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 전송 데이터 받기
		String reqdata = StreamData.dataChange(request);
		
		//역 직렬화
		Gson gson = new Gson();
		
		PListVO vo = gson.fromJson(reqdata, PListVO.class);
		
		//page : 1 stype = "" sword = ""
		
		//page정보 구하기 - 전체 글 갯수, 총 페이지수, 1~3글번호, 1~2페이지번호
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		
		PageVO pvo = service.pageInfo(vo.getPage(), vo.getStype(), vo.getSword());
		// start, end, startPage, endPage, totalPage 가 들어있다 vo안에는
		
		// 해당 페이지의 글 목록 가져오기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start",pvo.getStart());
		map.put("end", pvo.getEnd());
		map.put("stype", vo.getStype());
		map.put("sword", vo.getSword());
		
		List<BoardVO> list = service.selectByPage(map);
		
		//결과값을 request에 저장
		request.setAttribute("result",list);
		request.setAttribute("startPage", pvo.getStartPage());
		request.setAttribute("endPage", pvo.getEndPage());
		request.setAttribute("totalPage", pvo.getTotalPage());
		
		//view페이지로 이동
		request.getRequestDispatcher("/boardview/list.jsp").forward(request, response);
	}

}
