package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.FeedGrade;

@Repository
public class FeedGradeDaoImpl implements FeedGradeDao{

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "FeedGradeMapper.";
	
	@Override
	public int insertFeedGrade(FeedGrade feedgrade) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertFeedGrade", feedgrade);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}
	@Override
	public boolean updateFeedGrade(FeedGrade feedgrade) throws Exception {
		int cnt = sqlSession.update(namespace + "updateFeedGrade", feedgrade);
		if (cnt != 0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteFeedGrade(int feedgradeid) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteFeedGrade", feedgradeid);
		if (cnt != 0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Feed> searchHighGrade(int userid) throws Exception {
		return sqlSession.selectList(namespace+"searchHighGrade",userid);
}
}
