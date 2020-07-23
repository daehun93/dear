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

import com.daehun.dear.service.ReportCommentService;
import com.daehun.dear.service.ReportFeedService;
import com.daehun.dear.vo.BasicResponse;
import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.FeedComment;
import com.daehun.dear.vo.ReportComment;
import com.daehun.dear.vo.ReportFeed;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class ReportController {

	@Autowired
	private ReportFeedService reportfeedService;
	@Autowired
	private ReportCommentService reportcommentService;
	
	
	@ApiOperation(value = "피드 신고하기")
	@RequestMapping(value = "/insertReportFeed", method = RequestMethod.POST)
	public Object insertReportFeed(@RequestBody ReportFeed reportfeed)throws Exception{
		BasicResponse result = new BasicResponse();
		String ret = "";
		if(reportfeedService.insertReportFeed(reportfeed)!=0) {
			result.status=true;
		}else {
			result.status=false;
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "피드 신고업데이트(관리자용)")
	@RequestMapping(value = "/updateReportFeed", method = RequestMethod.PUT)
	public Object updateReportFeed(@RequestBody ReportFeed reportfeed)throws Exception{
		String ret ="";
		//자유게시판 들어가는거
		//글쓴이,내용,직업,나이
		System.out.println(reportfeed.toString());
		
		if(reportfeedService.updateReportFeed(reportfeed)!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "피드 신고취소하기")
	@RequestMapping(value = "/deleteReportFeed", method = RequestMethod.DELETE)
	public Object deleteReportFeed(@RequestBody ReportFeed reportfeed)throws Exception{
		String ret ="";
		
		if(reportfeedService.deleteReportFeed(reportfeed)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "내가신고한피드 보기")
	@RequestMapping(value = "/searchReportFeed", method = RequestMethod.POST)
	public Object searchReportFeed(@RequestParam int userid)throws Exception{
		String ret ="";
		List<Feed> feedlist = reportfeedService.searchReportFeed(userid);
		
		if(feedlist.size()!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<List<Feed>>(feedlist,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "댓글 신고하기")
	@RequestMapping(value = "/insertReportComment", method = RequestMethod.POST)
	public Object insertReportComment(@RequestBody ReportComment reportcomment)throws Exception{
		BasicResponse result = new BasicResponse();
		String ret = "";
		if(reportcommentService.insertReportComment(reportcomment)!=0) {
			result.status=true;
		}else {
			result.status=false;
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 신고업데이트(관리자용)")
	@RequestMapping(value = "/updateReportComment", method = RequestMethod.PUT)
	public Object updateReportComment(@RequestBody ReportComment reportcomment)throws Exception{
		String ret ="";
		//자유게시판 들어가는거
		//글쓴이,내용,직업,나이
		System.out.println(reportcomment.toString());
		
		if(reportcommentService.updateReportComment(reportcomment)!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 신고취소하기")
	@RequestMapping(value = "/deleteReportComment", method = RequestMethod.DELETE)
	public Object deleteReportComment(@RequestBody ReportComment reportcomment)throws Exception{
		String ret ="";
		
		if(reportcommentService.deleteReportComment(reportcomment)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "내가신고한댓글 보기")
	@RequestMapping(value = "/searchReportComment", method = RequestMethod.POST)
	public Object searchReportComment(@RequestParam int userid)throws Exception{
		String ret ="";
		List<FeedComment> commentlist = reportcommentService.searchReportComment(userid);
		if(commentlist.size()!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<List<FeedComment>>(commentlist,HttpStatus.OK);
	}
	
}
