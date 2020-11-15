package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.CommentGradeDao;
import com.daehun.dear.vo.CommentGrade;
import com.daehun.dear.vo.FeedComment;

@Service
public class CommentGradeServiceImpl implements CommentGradeService{

	@Autowired
	private CommentGradeDao commentGradeDao;

	@Override
	public int insertCommentGrade(CommentGrade commentgrade) throws Exception {
		return commentGradeDao.insertCommentGrade(commentgrade);
	}

	@Override
	public boolean updateCommentGrade(CommentGrade commentgrade) throws Exception {
		return commentGradeDao.updateCommentGrade(commentgrade);
	}

	@Override
	public boolean deleteCommentGrade(int commentgradeid) throws Exception {
		return commentGradeDao.deleteCommentGrade(commentgradeid);
	}

	@Override
	public List<FeedComment> searchHighGradeComment(int userid) throws Exception {
		return commentGradeDao.searchHighGradeComment(userid);
	}
}
