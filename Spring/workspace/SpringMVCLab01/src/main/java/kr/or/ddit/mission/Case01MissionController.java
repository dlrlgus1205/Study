package kr.or.ddit.mission;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission/case01")
public class Case01MissionController {
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void handler1() {
		log.info("json 요청");
	}
	@PostMapping
	public void handler2() {
		log.info("Post 요청");
	}
}
