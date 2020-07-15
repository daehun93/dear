package com.daehun.dear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daehun.dear.service.UserService;
import com.daehun.dear.vo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hun.dear.util.MailSender;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "*" }, maxAge = 6000)

public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "계정명이 id인 사용자를 생성하고 해당 사용자의 인증코드를 반환한다.")
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody String email) throws Exception {
		email = email.trim().replaceAll("\"", "");
		User user = null;
		ObjectMapper mapper = new ObjectMapper();
		// 기존DB에 id가 존재하는 경우
		if (userService.checkEmailDuplication(email)) {
			user = userService.get(email);

			// 인증란이 pass인 경우, 즉 회원가입이 완료된 id인 경우
			if (user.getAuthCode().equals("pass") == true) {
				return new ResponseEntity<String>(mapper.writeValueAsString(1), HttpStatus.OK);
			}
			user.setAuthCode(User.createRandomCode(12));
			userService.updateUser(user);
		} else {
			// id가 이메일 형태인지 확인하는 부분 작성 요망...
			user = new User(email);
			userService.createUser(user);
		}

		MailSender mailSender = new MailSender(user, "인증코드");
		Thread mailSenderThread = new Thread(mailSender, "메일센더 스레드");
		mailSenderThread.start();

		return new ResponseEntity<String>(mapper.writeValueAsString(0), HttpStatus.OK);
	}
	
	
}
