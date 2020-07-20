package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.FeedCommentDao;
import com.daehun.dear.vo.FeedComment;

@Service
public class FeedCommentServiceImpl implements FeedCommentService{

	@Autowired
	private FeedCommentDao feedCommentDao;
	
	@Override
	public boolean insertFeedComment(FeedComment feedcomment) throws Exception {
		return feedCommentDao.insertFeedComment(feedcomment);
	}

	@Override
	public boolean updateFeedComment(FeedComment feedcomment) throws Exception {
		return feedCommentDao.updateFeedComment(feedcomment);
	}

	@Override
	public boolean deleteFeedComment(int feedcommentid) throws Exception {
		return feedCommentDao.deleteFeedComment(feedcommentid);
	}

	@Override
	public List<FeedComment> searchAllFeedComment(int feedcommentid) throws Exception {
		return feedCommentDao.searchAllFeedComment(feedcommentid);
	}

}
