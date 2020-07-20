package com.daehun.dear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.NoticeDao;
import com.daehun.dear.vo.NoticeBoard;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public int insertNotice(NoticeBoard noticeboard) throws Exception {
		return noticeDao.insertNotice(noticeboard);
	}

	@Override
	public boolean updateNotice(NoticeBoard noticeboard) throws Exception {
		return noticeDao.updateNotice(noticeboard);
	}

	@Override
	public boolean deleteNotice(int noticeboardid) throws Exception {
		return noticeDao.deleteNotice(noticeboardid);
	}

	@Override
	public List<NoticeBoard> searchNoticeBoard(int userid) throws Exception {
		return noticeDao.searchNoticeBoard(userid);
	}

	@Override
	public NoticeBoard searchOneNoticeBoard(int noticeboardid) throws Exception {
		return noticeDao.searchOneNoticeBoard(noticeboardid);
	}
}
