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
public class Feed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedid;

	private int userid;
	private String title;
	private String content;
	private String job;
	private int age;

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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Feed(int feedid, int userid, String title, String content, String job, int age) {
		super();
		this.feedid = feedid;
		this.userid = userid;
		this.title = title;
		this.content = content;
		this.job = job;
		this.age = age;
	}

	public Feed() {
		super();
		// TODO Auto-generated constructor stub
	}

}
