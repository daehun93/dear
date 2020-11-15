package com.daehun.dear.dao;

import java.util.List;

import com.daehun.dear.vo.FavoriteFeed;
import com.daehun.dear.vo.Feed;

public interface FavoriteFeedDao {

	public int insertFavoriteFeed(FavoriteFeed favoritefeed) throws Exception;
	// 내가 마음에 드는 글 즐겨찾기 추가

	public boolean deleteFavoriteFeed(int FavoriteFeedid) throws Exception;
	// 즐겨찾기 삭제

	public List<Feed> searchFavoriteFeed(int userid) throws Exception;
	// 즐겨찾기한 게시글 보기(내가준 평점순)

}
