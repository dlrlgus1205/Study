package kr.or.ddit.member.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

@Controller
public class MypageController{
	@Autowired
	private MemberService service;
	
	@RequestMapping("/mypage")
	public String mypage(Principal principal, Model model){
		String viewName = null;
		MemberVO member = service.retrieveMember(principal.getName());
		model.addAttribute("member", member);
		return  "member/mypage";
	}
}
















