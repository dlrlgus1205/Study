package kr.or.ddit.member.controller;

import java.security.Principal;

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
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/memberUpdate.do")
public class MemberUpdateController{
	private final MemberService service;
	
	@GetMapping
	public String formHandler(Model model, Principal principal){
		if(!model.containsAttribute("member")) {
			String memId = principal.getName();
			MemberVO member = service.retrieveMember(memId);
			model.addAttribute("member", member);
		}
		return "member/memberForm";
	}
	
	@PostMapping
	public String updateHandler(
		@Validated(UpdateGroup.class) @ModelAttribute("member") MemberVO member
		, BindingResult errors
		, Model model
		, RedirectAttributes redirectAttributes
	){
		String viewName = null;
		if(!errors.hasErrors()) {
//		 * 3. 로직 사용(model 확보)
			ServiceResult result = service.modifyMember(member);
			switch (result) {
			case INVALIDPASSWORD:
				redirectAttributes.addFlashAttribute("message", "비밀번호 오류");
				viewName = "redirect:/member/memberUpdate.do";
				break;
			case FAIL:
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 가입하세요.");
				viewName = "member/memberForm";
				break;

			default:
				viewName = "redirect:/mypage";
				break;
			}
//		 * 4. scope 를 이용해 model 공유
			
		}else {
			redirectAttributes.addFlashAttribute("member", member);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"member", errors);
			viewName = "redirect:/member/memberUpdate.do";
		}
		return viewName;
	}

}













