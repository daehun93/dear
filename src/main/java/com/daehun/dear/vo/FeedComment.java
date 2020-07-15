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
public class FeedComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedcommentid;

	private int feedid;
	private int userid;
	private String content;

	public int getFeedcommentid() {
		return feedcommentid;
	}

	public void setFeedcommentid(int feedcommentid) {
		this.feedcommentid = feedcommentid;
	}

	public int getFeedid() {
		return feedid;
	}

	public void setFeedid(int feedid) {
		this.feedid = feedid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public FeedComment(int feedcommentid, int feedid, int userid, String content) {
		super();
		this.feedcommentid = feedcommentid;
		this.feedid = feedid;
		this.userid = userid;
		this.content = content;
	}

	public FeedComment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
