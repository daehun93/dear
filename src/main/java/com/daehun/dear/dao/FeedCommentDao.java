package com.daehun.dear.dao;

import java.util.List;

import com.daehun.dear.vo.FeedComment;


public interface FeedCommentDao {

	// 댓글 삽입 FreeBoardComment
	public boolean insertFeedComment(FeedComment feedcomment) throws Exception;

	// 댓글 수정
	public boolean updateFeedComment(FeedComment feedcomment) throws Exception;

	// 댓글 삭제
	public boolean deleteFeedComment(int feedcommentid) throws Exception;

	// 댓글목록가져오기
	public List<FeedComment> searchAllFeedComment(int feedcommentid) throws Exception;

}
