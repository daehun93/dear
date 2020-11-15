package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.FeedComment;


@Repository
public class FeedCommentDaoImpl implements FeedCommentDao {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "feedMapper.";

	@Override
	public boolean insertFeedComment(FeedComment feedcomment) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertFeedComment", feedcomment);
		if (cnt != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateFeedComment(FeedComment feedcomment) throws Exception {
		int cnt = sqlSession.update(namespace+"updateFeedComment",feedcomment);
		if(cnt!=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteFeedComment(int feedcommentid) throws Exception {
		int cnt = sqlSession.delete(namespace+"deleteFeedComment",feedcommentid);
		if(cnt!=0) {
			return true;
		}
		return false;
	}

	@Override
	public List<FeedComment> searchAllFeedComment(int feedcommentid) throws Exception {
		return sqlSession.selectList(namespace+"searchAllFeedComment",feedcommentid);
	}

}
