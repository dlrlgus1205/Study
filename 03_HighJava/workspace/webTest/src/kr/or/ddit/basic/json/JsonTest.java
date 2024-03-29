package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.sessionlogin.vo.MemberVo;

/**
 * Servlet implementation class JsonTest
 */
@WebServlet("/jsonTest.do")
public class JsonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ajax를 이용한 요청을 처리하고 응답을 JSON 객체로 반환하는 Servlet 예제
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		// 파라미터 구하기
		String choice = request.getParameter("choice");
		Gson gson = new Gson();
		String jsonData = null; // 처리된 데이터가 JSON문자열로 저장 될 변수
		
		switch (choice) {
			case "string" :
				String str = "안녕하세요";

				//처리된 데이터를 JSON문자열로 변환하기;
				jsonData = gson.toJson(str);
				break;
			case "array" :
				int[] arr = {10, 20, 30, 40, 50};
				
				//처리된 데이터를 JSON문자열로 변환하기;
				jsonData = gson.toJson(arr);
				break;
			case "object" :
				MemberVo memVo = new MemberVo("z001", "11111", "홍길동", "010-1234-5678", "대전");
				
				//처리된 데이터를 JSON문자열로 변환하기;
				jsonData = gson.toJson(memVo);
				break;
			case "list" :
				List<MemberVo> memList = new ArrayList<MemberVo>();
				memList.add(new MemberVo("a", "10", "김", "02", "서울"));
				memList.add(new MemberVo("b", "10", "나", "042", "대전"));
				memList.add(new MemberVo("c", "10", "박", "041", "충남"));
				memList.add(new MemberVo("d", "10", "이", "043", "충북"));
				
				//처리된 데이터를 JSON문자열로 변환하기;
				jsonData = gson.toJson(memList);
				break;
			case "map" :
				Map<String, String> mapData = new HashMap<String, String>();
				mapData.put("name", "이순신");
				mapData.put("tel", "010-8765-4321");
				mapData.put("addr", "대전 중구");
				
				//처리된 데이터를 JSON문자열로 변환하기;
				jsonData = gson.toJson(mapData);
				break;
		}
		
		System.out.println(choice + "==>" + jsonData);
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
