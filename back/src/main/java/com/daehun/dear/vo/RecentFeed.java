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
public class RecentFeed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recentfeedid;
	private int userid;
	private int feedid;

	public int getRecentfeedid() {
		return recentfeedid;
	}

	public void setRecentfeedid(int recentfeedid) {
		this.recentfeedid = recentfeedid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getFeedid() {
		return feedid;
	}

	public void setFeedid(int feedid) {
		this.feedid = feedid;
	}

	public RecentFeed(int recentfeedid, int userid, int feedid) {
		super();
		this.recentfeedid = recentfeedid;
		this.userid = userid;
		this.feedid = feedid;
	}

	public RecentFeed() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
