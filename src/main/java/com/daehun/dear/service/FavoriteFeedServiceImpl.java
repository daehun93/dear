package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.FavoriteFeedDao;
import com.daehun.dear.vo.FavoriteFeed;
import com.daehun.dear.vo.Feed;

@Service
public class FavoriteFeedServiceImpl implements FavoriteFeedService{

	@Autowired
	private FavoriteFeedDao favoritefeedDao;

	@Override
	public int insertFavoriteFeed(FavoriteFeed favoritefeed) throws Exception {
		return favoritefeedDao.insertFavoriteFeed(favoritefeed);
	}

	@Override
	public boolean deleteFavoriteFeed(int favoritefeedid) throws Exception {
		return favoritefeedDao.deleteFavoriteFeed(favoritefeedid);
	}

	@Override
	public List<Feed> searchFavoriteFeed(int userid) throws Exception {
		return favoritefeedDao.searchFavoriteFeed(userid);
	}
}
