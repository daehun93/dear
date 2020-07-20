package com.daehun.dear.dao;

import java.util.List;

import com.daehun.dear.vo.Feed;

public interface FeedDao {

	public int insertFeed(Feed feed)throws Exception;
	//글 삽입
	
	public boolean updateFeed(Feed feed)throws Exception;
	//글수정
	
	public boolean deleteFeed(int feedid)throws Exception;
	//글삭제
	
	public List<Feed> searchMyFeed(int userid)throws Exception;
	//내가쓴글보기
	
	public Feed searchOneFeed(int feedid)throws Exception;
	//상세보기
	
	
}
