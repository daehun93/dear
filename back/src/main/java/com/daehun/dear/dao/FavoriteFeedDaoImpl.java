package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.FavoriteFeed;
import com.daehun.dear.vo.Feed;

@Repository
public class FavoriteFeedDaoImpl implements FavoriteFeedDao {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "FavoriteFeedMapper.";

	@Override
	public int insertFavoriteFeed(FavoriteFeed favoritefeed) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertFavoriteFeed", favoritefeed);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}

	@Override
	public boolean deleteFavoriteFeed(int FavoriteFeedid) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteFavoriteFeed", FavoriteFeedid);
		if (cnt != 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Feed> searchFavoriteFeed(int userid) throws Exception {
		return sqlSession.selectList(namespace + "searchFavoriteFeed", userid);

	}

}
