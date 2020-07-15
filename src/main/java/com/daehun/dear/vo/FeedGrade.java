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
public class FeedGrade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedgradeid;

	private int feedid;
	private int userid;
	private int gradepoint;

	public int getFeedgradeid() {
		return feedgradeid;
	}

	public void setFeedgradeid(int feedgradeid) {
		this.feedgradeid = feedgradeid;
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

	public int getGradepoint() {
		return gradepoint;
	}

	public void setGradepoint(int gradepoint) {
		this.gradepoint = gradepoint;
	}

	public FeedGrade(int feedgradeid, int feedid, int userid, int gradepoint) {
		super();
		this.feedgradeid = feedgradeid;
		this.feedid = feedid;
		this.userid = userid;
		this.gradepoint = gradepoint;
	}

	public FeedGrade() {
		super();
		// TODO Auto-generated constructor stub
	}

}
