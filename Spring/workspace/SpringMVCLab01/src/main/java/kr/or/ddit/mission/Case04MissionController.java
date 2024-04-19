package kr.or.ddit.mission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.case04.service.DummyService;

@Controller
@RequestMapping("/mission/case04")
public class Case04MissionController {
	@Autowired
	private DummyService service;
	
	@RequestMapping
	public String mission(Model model) {
		model.addAttribute("dummy", service.retrieveInfo());
		return "mission/case04";
	}
}
