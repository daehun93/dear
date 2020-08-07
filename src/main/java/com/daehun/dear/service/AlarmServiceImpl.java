package com.daehun.dear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.AlarmDao;
import com.daehun.dear.vo.Alarm;

@Service
public class AlarmServiceImpl implements AlarmService{

	@Autowired
	private AlarmDao alarmDao;

	@Override
	public int insertAlarm(Alarm alarm) throws Exception {
		return alarmDao.insertAlarm(alarm);
	}

	@Override
	public int updateAlarm(Alarm alarm) throws Exception {
		return alarmDao.updateAlarm(alarm);
	}

	@Override
	public boolean deleteAlarm(int userid) throws Exception {
		return alarmDao.deleteAlarm(userid);
	}

	@Override
	public Alarm searchAlarm(int userid) throws Exception {
		return alarmDao.searchAlarm(userid);
	}
}
