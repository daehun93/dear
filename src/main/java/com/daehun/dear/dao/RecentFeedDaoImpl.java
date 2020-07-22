package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.RecentFeed;

@Repository
public class RecentFeedDaoImpl implements RecentFeedDao{

	@Autowired
	private SqlSession sqlSession;
	private final String namespace ="RecentFeedMapper.";
	
	@Override
	public int insertRecentFeed(RecentFeed recentfeed) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertRecentFeed", recentfeed);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}
	@Override
	public boolean deleteAllRecentFeed(int userid) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteAllRecentFeed", userid);
		if (cnt != 0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteOneRecentFeed(int recentfeedid) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteOneRecentFeed", recentfeedid);
		if (cnt != 0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Feed> searchRecentFeed(int userid) throws Exception {
		return sqlSession.selectList(namespace + "searchRecentFeed", userid);

	}
	
	
}
