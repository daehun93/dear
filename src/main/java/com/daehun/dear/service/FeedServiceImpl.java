package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.FeedDao;
import com.daehun.dear.vo.Feed;
@Service
public class FeedServiceImpl implements FeedService{

	@Autowired
	private FeedDao feedDao;
	
	@Override
	public int insertFeed(Feed feed) throws Exception {
		return feedDao.insertFeed(feed);
	}

	@Override
	public boolean updateFeed(Feed feed) throws Exception {
		return feedDao.updateFeed(feed);
	}

	@Override
	public boolean deleteFeed(int feedid) throws Exception {
		return feedDao.deleteFeed(feedid);
	}

	@Override
	public List<Feed> searchMyFeed(int userid) throws Exception {
		return feedDao.searchMyFeed(userid);
	}

	@Override
	public Feed searchOneFeed(int feedid) throws Exception {
		return feedDao.searchOneFeed(feedid);
	}

}
