package com.daehun.dear.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.NoticeBoard;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "NoticeMapper.";

	@Override
	public int insertNotice(NoticeBoard noticeboard) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertNotice", noticeboard);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}

	@Override
	public boolean updateNotice(NoticeBoard noticeboard) throws Exception {
		int cnt = sqlSession.update(namespace + "updateNotice", noticeboard);
		if (cnt != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteNotice(int noticeboardid) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteNotice", noticeboardid);
		if (cnt != 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<NoticeBoard> searchNoticeBoard(int userid) throws Exception {
		return sqlSession.selectList(namespace + "searchNoticeBoard", userid);
	}

	@Override
	public NoticeBoard searchOneNoticeBoard(int noticeboardid) throws Exception {
		return sqlSession.selectOne(namespace + "searchOneNoticeBoard", noticeboardid);

	}

}
