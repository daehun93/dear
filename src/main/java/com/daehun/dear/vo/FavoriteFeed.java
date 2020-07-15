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
public class FavoriteFeed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favoritefeedid;

	private int userid;
	private int feedid;

	public int getFavoritefeedid() {
		return favoritefeedid;
	}

	public void setFavoritefeedid(int favoritefeedid) {
		this.favoritefeedid = favoritefeedid;
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

	public FavoriteFeed(int favoritefeedid, int userid, int feedid) {
		super();
		this.favoritefeedid = favoritefeedid;
		this.userid = userid;
		this.feedid = feedid;
	}

	public FavoriteFeed() {
		super();
		// TODO Auto-generated constructor stub
	}

}
