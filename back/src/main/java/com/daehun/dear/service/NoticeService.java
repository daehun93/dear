package com.daehun.dear.service;

import java.util.List;

import com.daehun.dear.vo.NoticeBoard;

public interface NoticeService {
	public int insertNotice(NoticeBoard noticeboard) throws Exception;
	// 공지 삽입

	public boolean updateNotice(NoticeBoard noticeboard) throws Exception;
	// 공지 수정

	public boolean deleteNotice(int noticeboardid) throws Exception;
	// 공지 삭제

	public List<NoticeBoard> searchNoticeBoard(int userid) throws Exception;
	// 공지모두보기

	public NoticeBoard searchOneNoticeBoard(int noticeboardid) throws Exception;
	// 공지상세보기
}
