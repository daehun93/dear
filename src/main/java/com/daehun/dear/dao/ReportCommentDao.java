package com.daehun.dear.dao;

import java.util.List;

import com.daehun.dear.vo.FeedComment;
import com.daehun.dear.vo.ReportComment;

public interface ReportCommentDao {

	public int insertReportComment(ReportComment reportcomment) throws Exception;
	// 댓글 신고

	public int updateReportComment(ReportComment reportcomment) throws Exception;
	// 댓글 신고 업데이트

	public boolean deleteReportComment(ReportComment reportcomment) throws Exception;
	// 댓글 신고 취소
	
	public List<FeedComment> searchReportComment(int userid)throws Exception;
	//내가 신고한 댓글 보기
}
