package com.daehun.dear.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daehun.dear.service.CoffeeService;
import com.daehun.dear.vo.BasicResponse;
import com.daehun.dear.vo.Coffee;
import com.daehun.dear.vo.CommentGrade;
import com.daehun.dear.vo.FeedComment;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/coffee")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class CoffeeController {

	@Autowired
	private CoffeeService coffeeService;
	
	@ApiOperation(value = "커피등록추가")
	@RequestMapping(value = "/insertCoffee", method = RequestMethod.POST)
	public Object insertCoffee(@RequestBody Coffee coffee)throws Exception{
		BasicResponse result = new BasicResponse();
		String ret = "";
		if(coffeeService.insertCoffee(coffee)!=0) {
			result.status=true;
		}else {
			result.status=false;
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "커피갯수수정하기")
	@RequestMapping(value = "/updateCoffee", method = RequestMethod.PUT)
	public Object updateCoffee(@RequestBody Coffee coffee)throws Exception{
		String ret ="";
		System.out.println(coffee.toString());
		
		if(coffeeService.updateCoffee(coffee)!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "커피삭제하기")
	@RequestMapping(value = "/deleteCoffee", method = RequestMethod.DELETE)
	public Object deleteCoffee(@RequestParam int userid)throws Exception{
		String ret ="";
		
		if(coffeeService.deleteCoffee(userid)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "커피갯수확인하기")
	@RequestMapping(value = "/searchCoffee", method = RequestMethod.POST)
	public Object searchCoffee(@RequestParam int userid)throws Exception{
		String ret ="";
		Coffee coffee = coffeeService.searchCoffee(userid);
		
		if(coffee.getUserid()!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<Coffee>(coffee,HttpStatus.OK);
	}
}
