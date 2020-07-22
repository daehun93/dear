package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.ReportFeed;

@Repository
public class ReportFeedDaoImpl implements ReportFeedDao{

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "ReportFeedMapper.";
	
	@Override
	public int insertReportFeed(ReportFeed reportfeed) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertReportFeed", reportfeed);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}
	@Override
	public int updateReportFeed(ReportFeed reportfeed) throws Exception {
		int cnt = sqlSession.update(namespace + "updateReportFeed", reportfeed);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}
	@Override
	public boolean deleteReportFeed(ReportFeed reportfeed) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteReportFeed", reportfeed);
		if (cnt != 0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Feed> searchReportFeed(int userid) throws Exception {
		return sqlSession.selectList(namespace+"searchReportFeed",userid);
	}
}
