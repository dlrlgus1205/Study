package kr.or.ddit.servlet01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	서블릿
 * 		: 웹 상의 요청(HTTP)을 받고(분석), 웹을 통해 응답(HTTP)을 전송(동적 자원 생성)할 수 있는 객체의 필요 요건 --> HttpServlet
 * 
 *	개발단계
 * 	1. HttpServlet 구현체 정의
 * 	2. 필요한 callback 메소드 재정의
 * 		$("#btn").on("click", function(){});		
 * 		callback : 관련된 이벤트가 발생했을 때 시스템 내부적으로 자동 호출되는 구조
 * 	ex) doGet(http get method 요청 발생)
 * 		doPost(http post method 요청 발생)
 * 		doDelete(http delete method 요청 발생)
 * 	서블릿의 생명 주기 이벤트
 * 		: 서블릿 생성 및 초기화 - init
 * 			일반적으로 컨테이너는 최초의 요청이 발생했을 때 싱글톤 인스턴스를 생성함
 * 		: 서블릿 소멸 - destroy
 * 	서블릿 요청 이벤트
 * 		: 
 * 	3. WAS(Servlet Container)에게 해당 서블릿 등록.
 * 		bean container
 * 		javabean container
 * 		servlet container
 * 		jsp container
 * 		UI contatiner : <div><button>버튼</button><span>Sapn</span></div>
 *	 Container ?? 컨테이너 내부의 객체애 대한 생명 주기 관리자
 *	1) web.xml 의 servlet -> servlet-name, servlet-class
 *		load-on-startup, init-param, multipart-config 등의 엘리먼트로 특성 제어.
 *	2) @webServlet : 어노테이션의 속성으로 컨테이너 특성 제어
 *		@webServlet : 마커 어노테이션
 *		@webServlet("/desc") : single-value 어노테이션 (value 속성값)
 *		@WebServlet(value = "/desc", loadOnStartup = 1) : multi-value 어노테이션 (속성 이름 명시)
 * 	4. 등록된 서블릿에 대한 매핑 설정. *** 절대경로로 표기함
 * 		case 1 : "/" - 정적 자원에 대한 매핑(DefaultServlet 의 매핑 정보로 사용됨).
 * 		case 2 : "/*", "/member/*" - 경로매핑
 * 		case 3 : "*.do" - 확장자매핑
 *		case 4 : "/member/*.do" XXX
 */
@WebServlet(value = "/desc", loadOnStartup = 1)
public class DescriptionServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("서블릿 인스턴스 생성 후 초기화 작업 완료");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 메소드 시작");
		super.service(req, resp);
		System.out.println("service 메소드 종료");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드 실행");
		resp.setContentType("text/plain; charset=utf-8");
		resp.getWriter().print("동적 응답 전송");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("서블릿 객체 소멸");
	}
}
