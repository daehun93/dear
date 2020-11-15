package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.ReportFeedDao;
import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.ReportFeed;

@Service
public class ReportFeedServiceImpl implements ReportFeedService{

	@Autowired
	private ReportFeedDao reportfeedDao;

	@Override
	public int insertReportFeed(ReportFeed reportfeed) throws Exception {
		return reportfeedDao.insertReportFeed(reportfeed);
	}

	@Override
	public int updateReportFeed(ReportFeed reportfeed) throws Exception {
		return reportfeedDao.updateReportFeed(reportfeed);
	}

	@Override
	public boolean deleteReportFeed(ReportFeed reportfeed) throws Exception {
		return reportfeedDao.deleteReportFeed(reportfeed);
	}

	@Override
	public List<Feed> searchReportFeed(int userid) throws Exception {
		return reportfeedDao.searchReportFeed(userid);
	}
	
	
}
