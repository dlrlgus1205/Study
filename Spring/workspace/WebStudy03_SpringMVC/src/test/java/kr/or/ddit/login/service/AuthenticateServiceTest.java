package kr.or.ddit.login.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import kr.or.ddit.login.BadCredentialException;
import kr.or.ddit.login.UserNotFoundException;
import kr.or.ddit.vo.MemberVO;

class AuthenticateServiceTest {
	AuthenticateService service = new AuthenticateServiceImpl();
	
	@Test
	void testAuthenticateUserNotFound() {
		final MemberVO inputData = new MemberVO();
		inputData.setMemId("asdafsfaff");
		assertThrows(UserNotFoundException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable{
				service.authenticate(inputData);
			}
		});
	}

	@Test
	void testAuthenticateBadCredential() {
		final MemberVO inputData = new MemberVO();
		inputData.setMemId("b001");
		inputData.setMemPass("cbvbcnzvcb");
		assertThrows(BadCredentialException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable{
				service.authenticate(inputData);
			}
		});
	}
	
	@Test
	void testAuthenticate() {
		final MemberVO inputData = new MemberVO();
		inputData.setMemId("b001");
		inputData.setMemPass("1004");
		assertNotNull(service.authenticate(inputData));
	}
}
