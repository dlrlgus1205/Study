package kr.or.ddit.member.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;


/**
 * 1. 요청 접수, 분석
 * 2. 검증
 * 3. 로직 사용(model 확보)
 * 4. scope 를 이용해 model 공유
 * 5. view 결정
 * 6. view 로 이동(flow control)
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/member/memberInsert.do")
public class MemberInsertController extends HttpServlet{
	private final MemberService service;
	
	@ModelAttribute("member")
	public MemberVO member() {
		return new MemberVO();
	}
	
	@GetMapping
	public String formHandler(){
		return "member/memberForm";
	}
	
	@PostMapping
	public String insertProcess(
		@Validated(InsertGroup.class) @ModelAttribute("member") MemberVO member
		, BindingResult errors
		, Model model
		, RedirectAttributes redirectAttributes
	){
		String viewName = null;
		if(!errors.hasErrors()) {
//		 * 3. 로직 사용(model 확보)
			ServiceResult result = service.createMember(member);
			switch (result) {
			case PKDUPLICATED:
				redirectAttributes.addFlashAttribute("member", member);
				redirectAttributes.addFlashAttribute("message", "아이디 중복, 바꾸셈.");
				viewName = "redirect:/member/memberInsert.do";
				break;
			case FAIL:
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 가입하세요.");
				viewName = "member/memberForm";
				break;

			default:
				viewName = "redirect:/";
				break;
			}
//		 * 4. scope 를 이용해 model 공유
			
		}else {
			redirectAttributes.addFlashAttribute("member", member);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"member", errors);
			viewName = "redirect:/member/memberInsert.do";
		}
		return viewName;
	}

	
}


























