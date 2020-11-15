package com.daehun.dear.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daehun.dear.service.UserService;
import com.daehun.dear.vo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hun.dear.util.AES128;
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
	
	@ApiOperation(value = "user 정보를 받아서 갱신한다.")
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<String> updateUser(@RequestBody User user) throws Exception {
		String ret = "";
		System.out.println("가입신청");
		System.out.println(user.getAuthCode());
		System.out.println(user.getEmail());
		System.out.println(user.getNickname());
		System.out.println(user.getPassword());
		if (userService.authUser(user)) {
			// 닉네임중복확인필요
			System.out.println("여기오나1");
			if (userService.checkNickname(user.getNickname())) {
				System.out.println("여기오나2");
				user.setNickname(user.getNickname());
				user.setPassword(AES128.encrypt(user.getPassword()));
				user.setAuthCode("pass");
				userService.updateUser(user);
				ret = "true";
			} else {
				ret += "닉네임중복입니다.";
				System.out.println(ret);
			}
		} else {
			ret += "false";
		}

		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);

		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "{id : 이메일, authCode : 인증코드}를 받아서 일치하는지 확인한다.")
	@RequestMapping(value = "/authUser", method = RequestMethod.POST)
	public ResponseEntity<String> authUser(@RequestBody User user) throws Exception {
		System.out.println(user.getAuthCode() + "인증코드");
		System.out.println(user.getEmail() + "인증이메일");
		Boolean ret = userService.authUser(user);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(ret);
		System.out.println(ret + "결과");
		return new ResponseEntity<String>(jsonString, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "{id : 이메일, pw : 비밀번호}를 받아서 로그인 성공 여부를 반환한다.")
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public ResponseEntity<String> checkLogin(@RequestBody User in) throws Exception {
		int retCode = -1; // 0 : 로그인 성공, 1 : ID 존재 x, 2: pw일치 x, 3: 회원가입 마무리 x
		User user = new User();
		System.out.println(in.getEmail());
		// ID가 존재하지 않는 경우
		if (userService.checkEmailDuplication(in.getEmail()) == false) {
			retCode = 1;
		} else {
			String auth = userService.get(in.getEmail()).getAuthCode();

			// 회원가입이 마무리 되지 않은 id인 경우
			if (auth.equals("pass") == false)
				retCode = 3;
			else {
				boolean ret = userService.checkLogin(in.getEmail(), AES128.encrypt(in.getPassword()));
				retCode = ret == true ? 0 : 2;

				if (retCode == 0) {
					user = userService.get(in.getEmail());
				}
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("retCode", retCode + "");
		map.put("nickname", user.getNickname());
		map.put("email", user.getEmail());
		map.put("userid", user.getUserid() + "");
		System.out.println(user.toString());
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "id를 찾아 비밀번호를 변경하고 이메일로 전송한다.")
	@RequestMapping(value = "/findPW", method = RequestMethod.POST)
	public ResponseEntity<String> findPW(@RequestBody User user) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		int retCode = -1;

		// id가 존재하지 않는 경우
		if (userService.checkEmailDuplication(user.getEmail()) == false) {
			retCode = 1;
		} else {
			retCode = 0;
			user = userService.get(user.getEmail());
			user.setPassword(User.createRandomCode(15));
			userService.updateUser(user);

			MailSender mailSender = new MailSender(user, "비밀번호");
			Thread mailSenderThread = new Thread(mailSender, "메일센더 스레드");
			mailSenderThread.start();
		}

		return new ResponseEntity<String>(mapper.writeValueAsString(retCode), HttpStatus.OK);
	}

	@ApiOperation(value = "사용자 삭제")
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable String id) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		boolean retCode = userService.deleteUser(id);

		return new ResponseEntity<String>(mapper.writeValueAsString(retCode), HttpStatus.OK);
	}
}
