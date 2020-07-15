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
public class Alarm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int alarmid;

	private int userid;
	private String job;
	private int age;
	private String time;

	public int getAlarmid() {
		return alarmid;
	}

	public void setAlarmid(int alarmid) {
		this.alarmid = alarmid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Alarm(int alarmid, int userid, String job, int age, String time) {
		super();
		this.alarmid = alarmid;
		this.userid = userid;
		this.job = job;
		this.age = age;
		this.time = time;
	}

	public Alarm() {
		super();
		// TODO Auto-generated constructor stub
	}

}
