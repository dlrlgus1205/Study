package kr.or.ddit.case4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import kr.or.ddit.case4.bts.service.BtsService;
import kr.or.ddit.vo.BtsVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@Setter
@Slf4j
public class Case4Playground {
	@Autowired
	private BtsService service; 
	public static void main(String[] args) {
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:/kr/or/ddit/case4/conf/Case4-Context.xml");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("kr/or/ddit/case8/conf/Bts-Context.xml");
//		Case4Playground controller = context.getBean("case4Playground", Case4Playground.class);
		Case4Playground controller = context.getBean(Case4Playground.class);
		List<BtsVO> btsList = controller.service.readBtsList();
		
		log.info("btsList : {}", btsList);
	}
}