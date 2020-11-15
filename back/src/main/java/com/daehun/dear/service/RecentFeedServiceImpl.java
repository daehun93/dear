package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.RecentFeedDao;
import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.RecentFeed;

@Service
public class RecentFeedServiceImpl implements RecentFeedService{

	@Autowired
	private RecentFeedDao recentfeedDao;

	@Override
	public int insertRecentFeed(RecentFeed recentfeed) throws Exception {
		return recentfeedDao.insertRecentFeed(recentfeed);
	}

	@Override
	public boolean deleteAllRecentFeed(int userid) throws Exception {
		return recentfeedDao.deleteAllRecentFeed(userid);
	}

	@Override
	public boolean deleteOneRecentFeed(int recentfeedid) throws Exception {
		return recentfeedDao.deleteOneRecentFeed(recentfeedid);
	}

	@Override
	public List<Feed> searchRecentFeed(int userid) throws Exception {
		return recentfeedDao.searchRecentFeed(userid);
	}
	
}
