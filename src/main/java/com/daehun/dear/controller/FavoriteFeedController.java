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

import com.daehun.dear.service.FavoriteFeedService;
import com.daehun.dear.vo.BasicResponse;
import com.daehun.dear.vo.FavoriteFeed;
import com.daehun.dear.vo.Feed;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

//Crossorigin*는모든접속 허용,maxAge 웹브라우저 캐쉬서버요청 시간 3600이1시간
@RestController
@RequestMapping("/FavoriteFeed")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class FavoriteFeedController {

	@Autowired
	private FavoriteFeedService favoritefeedService;
	
	@ApiOperation(value = "즐겨찾기추가")
	@RequestMapping(value = "/insertFavoriteFeed", method = RequestMethod.POST)
	public Object insertFavoriteFeed(@RequestBody FavoriteFeed favoritefeed)throws Exception{
		BasicResponse result = new BasicResponse();
		String ret = "";
		if(favoritefeedService.insertFavoriteFeed(favoritefeed)!=0) {
			result.status=true;
		}else {
			result.status=false;
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "즐겨찾기삭제하기")
	@RequestMapping(value = "/deleteFavoriteFeed", method = RequestMethod.DELETE)
	public Object deleteFavoriteFeed(@RequestParam int favoritefeedid)throws Exception{
		String ret ="";
		if(favoritefeedService.deleteFavoriteFeed(favoritefeedid)) {
			ret = "true";
		}else {
			ret = "false";
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "즐겨찾기한글보기")
	@RequestMapping(value = "/searchFavoriteFeed", method = RequestMethod.POST)
	public Object searchFavoriteFeed(@RequestParam int userid)throws Exception{
		String ret ="";
		List<Feed> favoritefeedlist = favoritefeedService.searchFavoriteFeed(userid);
		
		if(favoritefeedlist.size()!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<List<Feed>>(favoritefeedlist,HttpStatus.OK);
	}
	
}
