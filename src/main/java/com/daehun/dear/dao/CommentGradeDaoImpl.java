package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.CommentGrade;
import com.daehun.dear.vo.FeedComment;

@Repository
public class CommentGradeDaoImpl implements CommentGradeDao{

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "CommentGradeMapper.";
	
	
	@Override
	public int insertCommentGrade(CommentGrade commentgrade) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertCommentGrade", commentgrade);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}
	@Override
	public boolean updateCommentGrade(CommentGrade commentgrade) throws Exception {
		int cnt = sqlSession.update(namespace + "updateCommentGrade", commentgrade);
		if (cnt != 0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteCommentGrade(int commentgradeid) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteCommentGrade", commentgradeid);
		if (cnt != 0) {
			return true;
		}
		return false;
	}
	@Override
	public List<FeedComment> searchHighGradeComment(int userid) throws Exception {
		return sqlSession.selectList(namespace+"searchHighGradeComment",userid);

	}
	
}
