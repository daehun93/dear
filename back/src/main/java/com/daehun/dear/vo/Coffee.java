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
public class Coffee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coffeeid;

	private int userid;
	private int count;

	public int getCoffeeid() {
		return coffeeid;
	}

	public void setCoffeeid(int coffeeid) {
		this.coffeeid = coffeeid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Coffee(int coffeeid, int userid, int count) {
		super();
		this.coffeeid = coffeeid;
		this.userid = userid;
		this.count = count;
	}

	public Coffee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
