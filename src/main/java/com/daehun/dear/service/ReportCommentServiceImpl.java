package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.ReportCommentDao;
import com.daehun.dear.vo.FeedComment;
import com.daehun.dear.vo.ReportComment;

@Service
public class ReportCommentServiceImpl implements ReportCommentService {

	@Autowired
	private ReportCommentDao reportcommentDao;

	@Override
	public int insertReportComment(ReportComment reportcomment) throws Exception {
		return reportcommentDao.insertReportComment(reportcomment);
	}

	@Override
	public int updateReportComment(ReportComment reportcomment) throws Exception {
		return reportcommentDao.updateReportComment(reportcomment);
	}

	@Override
	public boolean deleteReportComment(ReportComment reportcomment) throws Exception {
		return reportcommentDao.deleteReportComment(reportcomment);
	}

	@Override
	public List<FeedComment> searchReportComment(int userid) throws Exception {
		return reportcommentDao.searchReportComment(userid);
	}

}
