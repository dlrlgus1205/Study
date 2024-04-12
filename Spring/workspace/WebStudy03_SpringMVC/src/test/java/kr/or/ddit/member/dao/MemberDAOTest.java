package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberDAOTest extends AbstractRootContextTest{
	@Autowired
	MemberDAO dao;
	
	@Test
	void testInsertMember() {
		MemberVO member = new MemberVO();
		assertThrows(PersistenceException.class, ()->dao.insertMember(member));
		member.setMemId("rewq");
		member.setMemPass("java");
		member.setMemName("테스터");
		member.setMemZip("00000");
		member.setMemAdd1("대전 오류");
		member.setMemAdd2("대덕인재개발원");
		member.setMemMail("aa@naver.com");
		int rowcnt = dao.insertMember(member);
		assertEquals(1, rowcnt);
	}
	
	@Test
	void testSelectMemberList() {
		List<MemberVO> memberList = dao.selectMemberList();
		assertNotNull(memberList);
		assertNotEquals(0, memberList.size());
		log.info("list : {} ", memberList);
	}
	
	@Test
	void testSelectMember() {
		String memId = "a001";
		MemberVO member = dao.selectMember(memId);
		assertNotNull(member);
		
		log.info("cartList : {}", member.getCartList().size());
//		System.out.println(member);
//		memId = "asdasdfsadf' OR '1'='1";
//		assertNull(dao.selectMember(memId));
	}
	
	@Test
	void testUpdateMember() {
		String memId = "qwer";
		MemberVO member = dao.selectMember(memId);
		// 예외가 생길 것을 상정하고 만드는 코드
//		assertThrows(PersistenceException.class, ()->dao.updateMember(member));
		member.setMemPass("java");
		member.setMemName("개발자");
		member.setMemZip("zz");
		member.setMemAdd1("서울");
		member.setMemAdd2("대학교");
		member.setMemMail("bb@naver.com");
		int rowcnt = dao.updateMember(member);
		assertEquals(1, rowcnt);
	}
	
	@Test
	void testdeleteMember() {
		String memId = "rewq";
//		assertThrows(PersistenceException.class, ()->dao.deleteMember(memId));
		
		int rowcnt = dao.deleteMember(memId);
		assertEquals(1, rowcnt);
	}

}
