package com.daehun.dear.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.daehun.dear.service.FeedCommentService;
import com.daehun.dear.service.FeedService;
import com.daehun.dear.vo.BasicResponse;
import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.FeedComment;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/feed")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class FeedController {

	@Autowired
	private FeedService feedService;
	
	@Autowired
	private FeedCommentService feedcommentService;
//	private static final String ImgPath = "/home/ubuntu/images/"; 	// 배포용
//	private static final String ImgPath = "C:\\git\\ubd\\ubd-backend/image/"; // 개발용
	
	@ApiOperation(value = "글올리기")
	@RequestMapping(value = "/insertFeed", method = RequestMethod.POST)
	public Object insertFeed(@RequestBody Feed feed)throws Exception{
		BasicResponse result = new BasicResponse();
		String ret = "";
		if(feedService.insertFeed(feed)!=0) {
			result.status=true;
		}else {
			result.status=false;
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "글수정하기")
	@RequestMapping(value = "/updateFeed", method = RequestMethod.PUT)
	public Object updateFeed(@RequestBody Feed feed)throws Exception{
		String ret ="";
		//자유게시판 들어가는거
		//글쓴이,내용,직업,나이
		System.out.println(feed.toString());
		
		if(feedService.updateFeed(feed)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "글삭제하기")
	@RequestMapping(value = "/deleteFeed", method = RequestMethod.DELETE)
	public Object deleteFeed(@RequestParam int feedid)throws Exception{
		String ret ="";
		
		if(feedService.deleteFeed(feedid)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "내가쓴글보기")
	@RequestMapping(value = "/searchMyFeed", method = RequestMethod.POST)
	public Object searchMyFeed(@RequestParam int userid)throws Exception{
		String ret ="";
		List<Feed> feedlist = feedService.searchMyFeed(userid);
		
		if(feedlist.size()!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<List<Feed>>(feedlist,HttpStatus.OK);
	}
	
	@ApiOperation(value = "자유게시판한개상세보기")
	@RequestMapping(value = "/searchOneFeed/{feedid}", method = RequestMethod.POST)
	public Object searchOneFeed(@PathVariable int feedid)throws Exception{
		String ret ="";
		System.out.println(feedid+"자유게시판한개보기");
		Feed feed = feedService.searchOneFeed(feedid);
		System.out.println(feed.getTitle());
		if(feed!=null&&feed.getTitle()!=null) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<Feed>(feed,HttpStatus.OK);
	}
	
	@ApiOperation(value = "글에댓글쓰기")
	@RequestMapping(value = "/insertFeedComment", method = RequestMethod.POST)
	public Object insertFeedComment(@RequestBody FeedComment feedcomment) throws Exception{
		
		System.out.println("코멘트삽입");
		BasicResponse result = new BasicResponse();
		
		boolean flag = feedcommentService.insertFeedComment(feedcomment);
		if(!flag) {
			result.status=false;
			result.data="commentfail";
			
		}else {
			result.status=true;
			result.data="commentsucc";
		}
		return new ResponseEntity<BasicResponse>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "글귀댓글수정하기")
	@RequestMapping(value = "/updateFeedComment", method = RequestMethod.POST)
	public Object updateFeedComment(@RequestBody FeedComment feedcomment) throws Exception{
		
		System.out.println("코멘트수정");
		BasicResponse result = new BasicResponse();
		
		boolean flag = feedcommentService.updateFeedComment(feedcomment);
		if(!flag) {
			result.status=false;
			result.data="commentupdatefail";
			
		}else {
			result.status=true;
			result.data="commentupdatesucc";
		}
		return new ResponseEntity<BasicResponse>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "글귀댓글삭제하기")
	@RequestMapping(value = "/deleteFeedComment/{feedcommentid}", method = RequestMethod.DELETE)
	public Object deleteFeedComment(@PathVariable int feedcommentid) throws Exception{
		
		System.out.println("코멘트삭제");
		BasicResponse result = new BasicResponse();
		
		boolean flag = feedcommentService.deleteFeedComment(feedcommentid);
		if(!flag) {
			result.status=false;
			result.data="commentdeletefail";
			
		}else {
			result.status=true;
			result.data="commentdeletesucc";
		}
		return new ResponseEntity<BasicResponse>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시판댓글가져오기")
	@RequestMapping(value = "/searchAllFeedComment/{feedid}", method = RequestMethod.GET)
	public Object searchAllFeedComment(@PathVariable("feedid") int feedid) throws Exception{
		
		System.out.println("코멘트목록가져오기");
		BasicResponse result = new BasicResponse();
		List<FeedComment> temp = feedcommentService.searchAllFeedComment(feedid);
		JSONObject commentlist = new JSONObject();
		commentlist.put("commentlist", temp);
		boolean flag =false;
		if(temp.size()!=0) {
			flag=true;
		}
		
		if(!flag) {
			result.status=false;
			result.data="commentdeletefail";
			
		}else {
			result.status=true;
			result.data="commentdeletesucc";
		}
		result.object = commentlist.toMap();
		return new ResponseEntity<BasicResponse>(result, HttpStatus.OK);
	}
	
}
