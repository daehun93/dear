package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "userMapper.";
	
	@Override
	public boolean checkEmailDuplication(String email) throws Exception {
		return (Integer) sqlSession.selectOne(namespace + "checkEmailDuplication", email) == 1 ? true : false;
	}

	@Override
	public boolean createUser(User user) throws Exception {
		return sqlSession.insert(namespace + "createUser", user) > 0 ? true : false;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		return sqlSession.update(namespace + "updateUser", user) > 0 ? true : false;
	}

	@Override
	public User get(String email) throws Exception {
		return sqlSession.selectOne(namespace + "get", email);
	}

	@Override
	public boolean checkLogin(String email, String password) throws Exception {
		String dbpw = sqlSession.selectOne(namespace + "checkLogin", email);
		return password.equals(dbpw) ? true : false;
	}

	@Override
	public boolean deleteUser(String email) throws Exception {
		return sqlSession.delete(namespace + "deleteUser", email) > 0 ? true : false;
	}

	@Override
	public boolean authUser(User user) throws Exception {
		return (Integer) sqlSession.selectOne(namespace + "authUser", user) == 1 ? true : false;
	}

	@Override
	public User searchByNickname(String nickname) throws Exception {
		return sqlSession.selectOne(namespace + "searchByNickname", nickname);
	}

	@Override
	public User searchByUserid(int userid) throws Exception {
		return sqlSession.selectOne(namespace + "searchByUserid", userid);
	}

	@Override
	public List<User> searchAllNickname(String nickname) throws Exception {
		return sqlSession.selectList(namespace + "searchAllNickname", nickname);
	}

	@Override
	public boolean checkNickname(String nickname) throws Exception {
		int cnt = sqlSession.selectOne(namespace + "checkNickname", nickname);
		if (cnt == 0) {
			return true;
		}
		return false;
	}

}
