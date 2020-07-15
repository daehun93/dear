package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.UserDao;
import com.daehun.dear.vo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDAO;

	@Override
	public boolean checkEmailDuplication(String email) throws Exception {
		return userDAO.checkEmailDuplication(email);
	}

	@Override
	public boolean createUser(User user) throws Exception {
		return userDAO.createUser(user);
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		return userDAO.updateUser(user);
	}

	@Override
	public User get(String email) throws Exception {
		return userDAO.get(email);
	}

	@Override
	public boolean checkLogin(String email, String password) throws Exception {
		return userDAO.checkLogin(email, password);
	}

	@Override
	public boolean deleteUser(String email) throws Exception {
		return userDAO.deleteUser(email);
	}

	@Override
	public boolean authUser(User user) throws Exception {
		return userDAO.authUser(user);
	}

	@Override
	public User searchByNickname(String nickname) throws Exception {
		return userDAO.searchByNickname(nickname);
	}

	@Override
	public User searchByUserid(int userid) throws Exception {
		return userDAO.searchByUserid(userid);
	}

	@Override
	public List<User> searchAllNickname(String nickname) throws Exception {
		return userDAO.searchAllNickname(nickname);
	}

	@Override
	public boolean checkNickname(String nickname) throws Exception {
		return userDAO.checkNickname(nickname);
	}
}
