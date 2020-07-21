package com.daehun.dear.service;

import java.util.List;

import com.daehun.dear.vo.CommentGrade;
import com.daehun.dear.vo.FeedComment;

public interface CommentGradeService {
	public int insertCommentGrade(CommentGrade commentgrade)throws Exception;
	//댓글평가추가
	
	public boolean updateCommentGrade(CommentGrade commentgrade)throws Exception;
	//댓글평가수정
	
	public boolean deleteCommentGrade(int commentgradeid)throws Exception;
	//댓글평가삭제
	
	public List<FeedComment> searchHighGradeComment(int userid)throws Exception;
	//내가 높은 점수를 준 댓글
}
