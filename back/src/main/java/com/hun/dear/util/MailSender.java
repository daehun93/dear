package com.hun.dear.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.daehun.dear.vo.User;


public class MailSender implements Runnable {
	private User user;
	private String context;

	public MailSender(User user, String context) {
		this.user = user;
		this.context = context;
	}

	@Override
	public void run() {
		// 보내는 사람(개발자) 설정
		// gmail 사용시, 구글 보안 수준 변경 필요
		// https://www.google.com/settings/security/lesssecureapps -> 허용
		String host = "smtp.gmail.com";
		final String mailId = "dktkdktkgla"; // 아이디, @naver.com제외
		final String mailPw = "cprhks08!"; // 비밀번호
		int port = 465; // 포트번호

		// 메일 내용
		String recipient = user.getEmail(); // 받는사람 = user 이메일
		String subject = "[김대훈테스트] 새로운 " + context + "가 전송되었습니다.";

		String code = null;
		if (context.equals("비밀번호") == true) {
			code = user.getPassword();
		} else if (context.equals("인증코드") == true) {
			code = user.getAuthCode();
		}
		String body = "<div>" + context + "는 " + code + " 입니다.</div>";

		// 정보를 담기 위한 객체 생성
		Properties props = System.getProperties();

		// SMTP 서버 정보 설정
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);

		// Session 생성
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(mailId, mailPw);
			}
		});

		Message mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress("dktkdktkgla@gmail.com")); // 발신자
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); // 수신자
			mimeMessage.setSubject(subject);
			mimeMessage.setContent(body, "text/html; charset=utf-8");
			Transport.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}