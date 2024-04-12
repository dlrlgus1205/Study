package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.lprod.controller.OthersControllerAdvice;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodUpdate.do")
public class ProdUpdateControllerServlet extends HttpServlet{
	private ProdService service = new ProdServiceImpl();
	private OthersControllerAdvice advice = new OthersControllerAdvice();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		advice.addLprodList(req);
		advice.addbuyerList(req);
		
		String prodId = req.getParameter("what");
		if(StringUtils.isBlank(prodId)) {
			resp.sendError(400);
			return;
		}
		ProdVO prod = service.retrieveProd(prodId);
		req.setAttribute("prod", prod);
		
		String viewName = "prod/prodForm";

		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		advice.addLprodList(req);
		advice.addbuyerList(req);
		
//		1. 요청 접수, 분석
		req.setCharacterEncoding("utf-8");
		ProdVO prod = new ProdVO(); // command Object
		req.setAttribute("prod", prod);
		Map<String, String[]> parameterMap = req.getParameterMap();

		PopulateUtils.populate(prod, parameterMap);
		
		System.out.println(prod);
//		2. 검증
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		// 콜 바이 레퍼런스
		boolean valid = ValidateUtils.validate(prod, errors, UpdateGroup.class);
		String viewName = null;

		if (errors.isEmpty()) {
//		3. 로직 사용(model 확보)
			ServiceResult result = service.modifyProd(prod);
			switch (result) {
			case FAIL:
				req.setAttribute("message", "서버 오류");
				viewName = "prod/prodForm";
				break;
			default:
				viewName = "redirect:/prod/prodDetail.do?what=" + prod.getProdId();
				break;
			}
//		4. scope 를 이용해 model 공유
		} else {
			viewName = "prod/prodForm";
		}
//		5. view 결정
//		6. view 로 이동(flow control)
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
}
