package kr.or.ddit.servlet06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.BrowserInfo;

@WebServlet("/07/userAgent_sem.do")
public class UserAgentServlet_sem extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String uA = req.getHeader("User-Agent").toUpperCase();
		String browserName = null;
		
		// if문 사용
//		if(uA.contains("EDG")) {
//			browserName = "엣지";
//		}
//		else if(uA.contains("WHALE")) {
//			browserName = "웨일";
//		}
//		else if(uA.contains("CHROME")) {
//			browserName = "크롬";
//		}
//		else if(uA.contains("SAFARI")) {
//			browserName = "사파리";
//		}
//		else {
//			browserName = "기타";
//		}
		
		// Map 사용
//		Map<String, String> browserInfo = new LinkedHashMap<>();
//		browserInfo.put("EDG", "엣지");
//		browserInfo.put("WHALE", "웨일");
//		browserInfo.put("CHROME", "크롬");
//		browserInfo.put("SAFARI", "사파리");
//		browserInfo.put("OTHER", "기타");
//		
//		browserName = "기타";
//		
//		for(Entry<String, String> entry : browserInfo.entrySet()) {
//			if(uA.contains(entry.getKey())) {
//				browserName = entry.getValue();
//				break;
//			}
//		}
		
		// enum 사용
//		BrowserInfo[] infos = BrowserInfo.values();
//		
//		browserName = "기타";
//		
//		for (BrowserInfo single : infos) {
//			if(uA.contains(single.name())) {
//				browserName = single.getBrowserName();
//				break;
//			}
//		}
		
//		BrowserInfo finded = BrowserInfo.findBrowser(uA);
//		browserName = finded.getBrowserName();
		
		browserName = BrowserInfo.findBrowserName(uA);
		
		String message = String.format("당신의 브라우저는 [%s] 입니다", browserName);
		
		try(
			PrintWriter out = resp.getWriter();
		){
			out.print(message);
		}
	}
}
