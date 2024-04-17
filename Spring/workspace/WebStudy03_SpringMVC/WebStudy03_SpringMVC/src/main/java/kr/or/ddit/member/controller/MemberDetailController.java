package kr.or.ddit.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

/**
 * C : /member/memberInsert.do(GET, POST)
 * R (GET)
 * 단건 : /member/memberDetail.do?who=a001
 * 다건 : /member/memberList.do
 * U : /member/memberUpdate.do(GET, POST)
 * D : /member/memberDelete.do(POST)
 *
 */
@Controller
@RequiredArgsConstructor
public class MemberDetailController{
	
	private final MemberService service;
	
	@RequestMapping("/member/memberDetail.do")
	public String detail(@RequestParam String who, Model model){
		MemberVO member = service.retrieveMember(who);
		model.addAttribute("member", member);
		return "jsonView";
	} 
}

















