package com.daehun.dear.service;

import java.util.List;

import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.ReportFeed;

public interface ReportFeedService {
	public int insertReportFeed(ReportFeed reportfeed) throws Exception;
	// 글 신고등록

	public int updateReportFeed(ReportFeed reportfeed) throws Exception;
	// 글 신고 업데이트

	public boolean deleteReportFeed(ReportFeed reportfeed) throws Exception;
	// 글 신고취소
	
	public List<Feed> searchReportFeed(int userid)throws Exception;
	//내가신고한 글 보기
}
