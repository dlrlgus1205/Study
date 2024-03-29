package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;



public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
	
	HttpServletRequest httpRequest = (HttpServletRequest) request;
	HttpServletResponse httpResponse = (HttpServletResponse) response;
	HttpSession session = httpRequest.getSession(false); // 기존 세션 반환, 없으면 null
	
	boolean isLoggedIn = (session != null && session.getAttribute("login") != null);
	if (isLoggedIn) {
		// 로그인 되어 있으면 요청 계속 진행
		chain.doFilter(request, response);
	} else {
		// 로그인 되어 있지 않으면 로그인 폼으로 리다이렉트
		httpResponse.sendRedirect(httpRequest.getContextPath() +"/html/login.jsp");
	}
}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
