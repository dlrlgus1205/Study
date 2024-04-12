package kr.or.ddit.case01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case01/mapping2")
public class HttpMethodMappingController {
	@RequestMapping(method = {RequestMethod.HEAD, RequestMethod.PATCH})
	public void handlerOthers() {
		log.info("other method handler 동작");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void handler1Get() {
		log.info("get handler 동작");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void handler2Post() {
		log.info("post handler 동작");
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void handler2Put() {
		log.info("put handler 동작");
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void handler2Delete() {
		log.info("delete handler 동작");
	}
}
