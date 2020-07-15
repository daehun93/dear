package com.daehun.dear.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noticeboardid;

	private String title;
	private String content;

	public int getNoticeboardid() {
		return noticeboardid;
	}

	public void setNoticeboardid(int noticeboardid) {
		this.noticeboardid = noticeboardid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NoticeBoard(int noticeboardid, String title, String content) {
		super();
		this.noticeboardid = noticeboardid;
		this.title = title;
		this.content = content;
	}

	public NoticeBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

}
