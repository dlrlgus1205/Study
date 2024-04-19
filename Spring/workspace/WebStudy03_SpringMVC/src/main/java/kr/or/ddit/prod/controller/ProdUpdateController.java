package kr.or.ddit.prod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.lprod.controller.OthersControllerAdvice;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.ProdVO;

@Controller
@RequestMapping("/prod/prodUpdate.do")
public class ProdUpdateController{
	
	public static final String MODELNAME = "prod";
	
	@Autowired
	private ProdService service;
	
	
	@GetMapping
	public String formHandler(Model model, @RequestParam String what) {
		ProdVO prod = service.retrieveProd(what);
		model.addAttribute(MODELNAME, prod);
		
		return "prod/prodEdit";
	}

	@PostMapping
	public String updateProcess(
			Model model
			, @Validated(UpdateGroup.class) @ModelAttribute(MODELNAME) ProdVO prod
			, BindingResult errors
	) {
//		 * 2. 검증
		boolean valid = !errors.hasErrors();
		String viewName = null;
		if (valid) {
//		 * 3. 로직 사용(model 확보)
			ServiceResult result = service.modifyProd(prod);
			switch (result) {
			case FAIL:
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 수정하세요.");
				viewName = "prod/prodEdit";
				break;

			default:
				viewName = "redirect:/prod/prodDetail.do?what="+prod.getProdId();
				break;
			}
//		 * 4. scope 를 이용해 model 공유

		} else {
			viewName = "prod/prodEdit";
		}
//		 * 5. view 결정
//		 * 6. view 로 이동(flow control)
		return viewName;
	}

	
}
















