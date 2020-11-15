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
public class ReportComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportcommentid;

	private int userid;
	private int feedcommentid;
	private int complete;

	public int getReportcommentid() {
		return reportcommentid;
	}

	public void setReportcommentid(int reportcommentid) {
		this.reportcommentid = reportcommentid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getFeedcommentid() {
		return feedcommentid;
	}

	public void setFeedcommentid(int feedcommentid) {
		this.feedcommentid = feedcommentid;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public ReportComment(int reportcommentid, int userid, int feedcommentid, int complete) {
		super();
		this.reportcommentid = reportcommentid;
		this.userid = userid;
		this.feedcommentid = feedcommentid;
		this.complete = complete;
	}

	public ReportComment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
