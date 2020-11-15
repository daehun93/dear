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
public class ReportFeed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportfeedid;

	private int userid;
	private int feedid;
	private int complete;

	public int getReportfeedid() {
		return reportfeedid;
	}

	public void setReportfeedid(int reportfeedid) {
		this.reportfeedid = reportfeedid;
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

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public ReportFeed(int reportfeedid, int userid, int feedid, int complete) {
		super();
		this.reportfeedid = reportfeedid;
		this.userid = userid;
		this.feedid = feedid;
		this.complete = complete;
	}

	public ReportFeed() {
		super();
		// TODO Auto-generated constructor stub
	}

}
