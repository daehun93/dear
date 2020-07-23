package com.daehun.dear.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.Coffee;

@Repository
public class CoffeeDaoImpl implements CoffeeDao {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "CoffeeMapper.";

	@Override
	public int insertCoffee(Coffee coffee) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertCoffee", coffee);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}

	@Override
	public int updateCoffee(Coffee coffee) throws Exception {
		int cnt = sqlSession.update(namespace + "updateCoffee", coffee);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}

	@Override
	public boolean deleteCoffee(int userid) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteCoffee", userid);
		if (cnt != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Coffee searchCoffee(int userid) throws Exception {
		return sqlSession.selectOne(namespace + "searchCoffee", userid);
	}

}
