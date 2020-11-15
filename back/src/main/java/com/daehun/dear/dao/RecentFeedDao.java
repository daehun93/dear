package com.daehun.dear.dao;

import java.util.List;

import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.RecentFeed;

public interface RecentFeedDao {

	public int insertRecentFeed(RecentFeed recentfeed) throws Exception;
	// 최근 게시물 등록

	public boolean deleteAllRecentFeed(int userid) throws Exception;
	// 최근본 게시물 전체 삭제

	public boolean deleteOneRecentFeed(int recentfeedid) throws Exception;
	// 최근 게시물 클릭후 한개 상세보기

	public List<Feed> searchRecentFeed(int userid) throws Exception;
	// 최근 게시글 목록

}
