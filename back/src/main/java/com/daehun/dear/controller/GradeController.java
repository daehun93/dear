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

import com.daehun.dear.service.FeedGradeService;
import com.daehun.dear.vo.BasicResponse;
import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.FeedGrade;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class GradeController {

	@Autowired
	private FeedGradeService feedgradeService;
	
	@ApiOperation(value = "평가추가")
	@RequestMapping(value = "/insertFeedGrade", method = RequestMethod.POST)
	public Object insertFeedGrade(@RequestBody FeedGrade feedgrade)throws Exception{
		BasicResponse result = new BasicResponse();
		String ret = "";
		if(feedgradeService.insertFeedGrade(feedgrade)!=0) {
			result.status=true;
		}else {
			result.status=false;
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "평가수정하기")
	@RequestMapping(value = "/updateFeedGrade", method = RequestMethod.PUT)
	public Object updateFeedGrade(@RequestBody FeedGrade feedgrade)throws Exception{
		String ret ="";
		//자유게시판 들어가는거
		//글쓴이,내용,직업,나이
		System.out.println(feedgrade.toString());
		
		if(feedgradeService.updateFeedGrade(feedgrade)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "평가삭제하기")
	@RequestMapping(value = "/deleteFeedGrade", method = RequestMethod.DELETE)
	public Object deleteFeedGrade(@RequestParam int feedgradeid)throws Exception{
		String ret ="";
		
		if(feedgradeService.deleteFeedGrade(feedgradeid)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "내가평가한글높은점수부터보기")
	@RequestMapping(value = "/searchHighGrade", method = RequestMethod.POST)
	public Object searchHighGrade(@RequestParam int userid)throws Exception{
		String ret ="";
		List<Feed> feedlist = feedgradeService.searchHighGrade(userid);
		
		if(feedlist.size()!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<List<Feed>>(feedlist,HttpStatus.OK);
	}
	
	
	
}
