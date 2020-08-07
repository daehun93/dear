package com.daehun.dear.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daehun.dear.vo.Alarm;

@Repository
public class AlarmDaoImpl implements AlarmDao {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "AlarmMapper.";

	@Override
	public int insertAlarm(Alarm alarm) throws Exception {
		int cnt = sqlSession.insert(namespace + "insertAlarm", alarm);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}

	@Override
	public int updateAlarm(Alarm alarm) throws Exception {
		int cnt = sqlSession.update(namespace + "updateAlarm", alarm);
		if (cnt != 0) {
			return cnt;
		}
		return 0;
	}

	@Override
	public boolean deleteAlarm(int userid) throws Exception {
		int cnt = sqlSession.delete(namespace + "deleteAlarm", userid);
		if (cnt != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Alarm searchAlarm(int userid) throws Exception {
		return sqlSession.selectOne(namespace + "searchAlarm", userid);
		
	}
}
