package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.FeedComment;
import com.daehun.dear.vo.ReportComment;

@Repository
public class ReportCommentDaoImpl implements ReportCommentDao {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "ReportCommentMapper.";

	@Override
	public int insertReportComment(ReportComment reportcomment) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertReportComment", reportcomment);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}

	@Override
	public int updateReportComment(ReportComment reportcomment) throws Exception {
		int cnt = sqlSession.update(namespace + "updateReportComment", reportcomment);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}

	@Override
	public boolean deleteReportComment(ReportComment reportcomment) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteReportComment", reportcomment);
		if (cnt != 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<FeedComment> searchReportComment(int userid) throws Exception {
		return sqlSession.selectList(namespace + "searchReportComment", userid);

	}

}
