package kr.or.ddit.mission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission/case02")
public class Case02MissionController {
	@RequestMapping("header")
	public void handler1(
		@RequestHeader(name = "user-agent") String userAgent,
		@CookieValue(required = false, defaultValue = "1000") int myCookie
	) {
		
	}
}
