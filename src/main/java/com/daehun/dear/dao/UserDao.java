package com.daehun.dear.dao;

import java.util.List;

import com.daehun.dear.vo.User;

public interface UserDao {
	// email 이미 데이터베이스에 존재하는지 여부를 반환한다.
	boolean checkEmailDuplication(String email) throws Exception;

	// 사용자 user를 생성한다.
	boolean createUser(User user) throws Exception;

	// 계정명이 id인 사용자를 찾아서 정보를 갱신한다.
	boolean updateUser(User user) throws Exception;

	// 계정명이 인 사용자를 찾아서 정보를 반환한다.
	User get(String email) throws Exception;

	// id, pw 쌍으로 사용자가 입력한 정보가 정확한지 여부를 반환한다.
	boolean checkLogin(String email, String password) throws Exception;

	// 계정명이 id인 계정을 삭제한다.
	boolean deleteUser(String email) throws Exception;

	// 계정, 인증코드 쌍이 일치하는지 여부를 반환한다.
	boolean authUser(User user) throws Exception;

	// nickname으로 사용자 정보 가져오기
	User searchByNickname(String nickname) throws Exception;

	// 고유번호uid로 사용자 정보 가져오기
	User searchByUserid(int userid) throws Exception;

	// 닉네임 검색시 관련 모든사람 가져오기
	List<User> searchAllNickname(String nickname) throws Exception;

	// 닉네임 중복체크
	public boolean checkNickname(String nickname) throws Exception;

}
