package kr.or.ddit.case08;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kr.or.ddit.case07.vo.BankInfoVO;

@Controller
@RequestMapping(value="/case08", produces = MediaType.APPLICATION_JSON_VALUE)
public class JsonMarshallingController {
	
	@RequestMapping("json3")
	@ResponseBody
	public String handler3() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper()
				 .registerModule(new JavaTimeModule()); // new module, NOT JSR310Module
		
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		String json = mapper.writeValueAsString(bank());
		return json;
	}
	
	@RequestMapping("json2")
	@ResponseBody
	public BankInfoVO handler2() {
		return bank();
	}
	
	@GetMapping("json1")
	public String handler1(Model model) {
		model.addAttribute("target", bank());
		return "jsonView";
	}
	
	private BankInfoVO bank() {
		BankInfoVO target = new BankInfoVO();
		target.setBankName("하나은행");
		target.setBankNo("11-111-111");
		target.setBankDate(LocalDate.now());
		return target;
	}
}



















