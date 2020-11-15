package com.daehun.dear.dao;

import java.util.List;

import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.FeedGrade;

public interface FeedGradeDao {

	public int insertFeedGrade(FeedGrade feedgrade)throws Exception;
	//평가추가
	
	public boolean updateFeedGrade(FeedGrade feedgrade)throws Exception;
	//평가수정
	
	public boolean deleteFeedGrade(int feedgradeid)throws Exception;
	//평가삭제
	
	public List<Feed> searchHighGrade(int userid)throws Exception;
	//내가 높은 점수를 준 평가글
	
	
	
}
