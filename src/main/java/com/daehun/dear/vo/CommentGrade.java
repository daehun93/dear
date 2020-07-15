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
public class CommentGrade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentgradeid;

	private int feedcommentid;
	private int userid;
	private int grade;

	public int getCommentgradeid() {
		return commentgradeid;
	}

	public void setCommentgradeid(int commentgradeid) {
		this.commentgradeid = commentgradeid;
	}

	public int getFeedcommentid() {
		return feedcommentid;
	}

	public void setFeedcommentid(int feedcommentid) {
		this.feedcommentid = feedcommentid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public CommentGrade(int commentgradeid, int feedcommentid, int userid, int grade) {
		super();
		this.commentgradeid = commentgradeid;
		this.feedcommentid = feedcommentid;
		this.userid = userid;
		this.grade = grade;
	}

	public CommentGrade() {
		super();
		// TODO Auto-generated constructor stub
	}

}
