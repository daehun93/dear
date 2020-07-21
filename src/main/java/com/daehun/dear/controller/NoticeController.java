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

import com.daehun.dear.service.NoticeService;
import com.daehun.dear.vo.BasicResponse;
import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.FeedGrade;
import com.daehun.dear.vo.NoticeBoard;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/notice")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ApiOperation(value = "공지글추가")
	@RequestMapping(value = "/insertNotice", method = RequestMethod.POST)
	public Object insertNotice(@RequestBody NoticeBoard noticeboard)throws Exception{
		BasicResponse result = new BasicResponse();
		String ret = "";
		if(noticeService.insertNotice(noticeboard)!=0) {
			result.status=true;
		}else {
			result.status=false;
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "공지수정하기")
	@RequestMapping(value = "/updateNotice", method = RequestMethod.PUT)
	public Object updateNotice(@RequestBody NoticeBoard noticeboard)throws Exception{
		String ret ="";
		//자유게시판 들어가는거
		//글쓴이,내용,직업,나이
		System.out.println(noticeboard.toString());
		
		if(noticeService.updateNotice(noticeboard)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "공지삭제하기")
	@RequestMapping(value = "/deleteNotice", method = RequestMethod.DELETE)
	public Object deleteNotice(@RequestParam int noticeboardid)throws Exception{
		String ret ="";
		
		if(noticeService.deleteNotice(noticeboardid)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "공지사항전체보기")
	@RequestMapping(value = "/searchNoticeBoard", method = RequestMethod.POST)
	public Object searchNoticeBoard(@RequestParam int userid)throws Exception{
		String ret ="";
		List<NoticeBoard> noticelist = noticeService.searchNoticeBoard(userid);
		
		if(noticelist.size()!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<List<NoticeBoard>>(noticelist,HttpStatus.OK);
	}
	
	@ApiOperation(value = "공지사항상세보기")
	@RequestMapping(value = "/searchOneNoticeBoard", method = RequestMethod.POST)
	public Object searchOneNoticeBoard(@RequestParam int noticeboardid)throws Exception{
		String ret ="";
		NoticeBoard notice = noticeService.searchOneNoticeBoard(noticeboardid);
		
		if(notice.getContent() != null) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity <NoticeBoard>(notice,HttpStatus.OK);
	}
	
}
