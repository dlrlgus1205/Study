package kr.or.ddit.mission;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mission/case06")
public class Case06MissionController {
	@GetMapping
	public String formHandler() {
		return "case06/missionForm";
	}
	@PostMapping
	public String process(
			@RequestParam(required = true) double leftOp
			, @RequestParam(required = true) double rightOp
			, Model model
			, RedirectAttributes redirectAttributes
	) {
		double result = leftOp + rightOp;
//		model.addAttribute("result", result);
		redirectAttributes.addFlashAttribute("leftOp", leftOp);
		redirectAttributes.addFlashAttribute("rightOp", rightOp);
		redirectAttributes.addFlashAttribute("result", result);
		return "redirect:/mission/case06";
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void process2(
			@RequestParam(required = true) double leftOp
			, @RequestParam(required = true) double rightOp
			, Model model
			) {
		double result = leftOp + rightOp;
//		model.addAttribute("result", result);
		model.addAttribute("leftOp", leftOp);
		model.addAttribute("rightOp", rightOp);
		model.addAttribute("result", result);
	}
}
























