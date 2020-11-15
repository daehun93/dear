package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.FeedCommentDao;
import com.daehun.dear.dao.FeedGradeDao;
import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.FeedGrade;

@Service
public class FeedGradeServiceImpl implements FeedGradeService{

	@Autowired
	private FeedGradeDao feedgradeDao;

	@Override
	public int insertFeedGrade(FeedGrade feedgrade) throws Exception {
		return feedgradeDao.insertFeedGrade(feedgrade);
	}

	@Override
	public boolean updateFeedGrade(FeedGrade feedgrade) throws Exception {
		return feedgradeDao.updateFeedGrade(feedgrade);
	}

	@Override
	public boolean deleteFeedGrade(int feedgradeid) throws Exception {
		return feedgradeDao.deleteFeedGrade(feedgradeid);
	}

	@Override
	public List<Feed> searchHighGrade(int userid) throws Exception {
		return feedgradeDao.searchHighGrade(userid);
	}
}
