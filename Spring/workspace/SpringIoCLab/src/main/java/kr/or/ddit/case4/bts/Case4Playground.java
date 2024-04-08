package kr.or.ddit.case4.bts;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.case4.bts.service.BtsService;
import kr.or.ddit.vo.BtsVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Slf4j
public class Case4Playground {
	private BtsService service; 
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:/kr/or/ddit/case4/conf/Case4-Context.xml");
		Case4Playground controller = context.getBean("case4Playground", Case4Playground.class);
		List<BtsVO> btsList = controller.service.readBtsList();
		
		log.info("btsList : {}", btsList);
	}
}