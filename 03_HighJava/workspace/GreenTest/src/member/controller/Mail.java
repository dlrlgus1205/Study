package member.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import member.vo.MemberVO;

public class Mail {

	 
	
	public static void sendEmail(MemberVO vo) {
		// 네이버 SMTP 서버 정보 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// 네이버 계정 정보 설정
		String username = "bnmn123"; // 네이버 아이디
		String password = "dnflwlq03+"; // 네이버 비밀번호

		// 세션 생성
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// 메시지 작성
		MimeMessage message = new MimeMessage(session);
		try {
		message.setFrom(new InternetAddress(username + "@naver.com"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(vo.getMem_mail()));
		message.setSubject("엽록소 패밀리에서 회원님의 비밀번호를 알려 드립니다.");
		message.setText("회원님의 비밀번호는 " +vo.getMem_pass()+"입니다.");
		// 메시지 전송
		Transport.send(message);
		}catch (Exception e) {
            e.printStackTrace();
        }

	}
}


