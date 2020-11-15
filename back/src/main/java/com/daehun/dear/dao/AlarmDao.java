package com.daehun.dear.dao;

import com.daehun.dear.vo.Alarm;

public interface AlarmDao {

	public int insertAlarm(Alarm alarm) throws Exception;
	// 알람등록

	public int updateAlarm(Alarm alarm) throws Exception;
	// 알람수정

	public boolean deleteAlarm(int userid) throws Exception;
	// 알람삭제

	public Alarm searchAlarm(int userid) throws Exception;
	// 알람검색
}
