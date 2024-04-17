package kr.or.ddit.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * C : /member/memberInsert.do(GET, POST)
 * R (GET)
 * 단건 : /member/memberDetail.do?who=a001
 * 다건 : /member/memberList.do
 * U : /member/memberUpdate.do(GET, POST)
 * D : /member/memberDelete.do(POST)
 *
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberListController{
	private final MemberService service;
	
	@RequestMapping("/member/memberList.do")
	public String list(Model model){
		log.info("컨트롤러 동작");
		List<MemberVO> memberList = service.retrieveMemberList();
//		System.out.printf("%s\n", memberList);
		log.info("조회된 모델 : {}", memberList);
		// scope
		model.addAttribute("memberList", memberList);
		// view
		return "member/memberList";
	} 
}

















