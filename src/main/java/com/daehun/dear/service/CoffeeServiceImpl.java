package com.daehun.dear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daehun.dear.dao.CoffeeDao;
import com.daehun.dear.vo.Coffee;

@Service
public class CoffeeServiceImpl implements CoffeeService {

	@Autowired
	private CoffeeDao coffeeDao;

	@Override
	public int insertCoffee(Coffee coffee) throws Exception {
		return coffeeDao.insertCoffee(coffee);
	}

	@Override
	public int updateCoffee(Coffee coffee) throws Exception {
		return coffeeDao.updateCoffee(coffee);
	}

	@Override
	public boolean deleteCoffee(int userid) throws Exception {
		return coffeeDao.deleteCoffee(userid);
	}

	@Override
	public Coffee searchCoffee(int userid) throws Exception {
		return coffeeDao.searchCoffee(userid);
	}

}
