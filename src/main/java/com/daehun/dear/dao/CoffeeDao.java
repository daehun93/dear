package com.daehun.dear.dao;

import com.daehun.dear.vo.Coffee;

public interface CoffeeDao {

	public int insertCoffee(Coffee coffee) throws Exception;
	//커피추가
	public int updateCoffee(Coffee coffee) throws Exception;
	//커피업데이트(갯수줄이기)
	public boolean deleteCoffee(int userid)throws Exception;
	//커피삭제
	public Coffee searchCoffee(int userid)throws Exception;
	//남은커피검색
	
}
