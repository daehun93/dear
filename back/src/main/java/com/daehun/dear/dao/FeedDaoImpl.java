package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.Feed;

@Repository
public class FeedDaoImpl implements FeedDao {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "feedMapper.";
	
	@Override
	public int insertFeed(Feed feed) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertFeed", feed);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}

	@Override
	public boolean updateFeed(Feed feed) throws Exception {
		int cnt = sqlSession.update(namespace + "updateFeed", feed);
		if (cnt != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteFeed(int feedid) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteFeed", feedid);
		if (cnt != 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Feed> searchMyFeed(int userid) throws Exception {
		return sqlSession.selectList(namespace+"searchMyFeed",userid);
	}

	@Override
	public Feed searchOneFeed(int feedid) throws Exception {
		return sqlSession.selectOne(namespace+"searchOneFeed",feedid);
	}

}
