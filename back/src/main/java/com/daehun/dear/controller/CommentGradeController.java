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

import com.daehun.dear.service.CommentGradeService;
import com.daehun.dear.vo.BasicResponse;
import com.daehun.dear.vo.CommentGrade;
import com.daehun.dear.vo.Feed;
import com.daehun.dear.vo.FeedComment;
import com.daehun.dear.vo.FeedGrade;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/commentgrade")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class CommentGradeController {

	@Autowired
	private CommentGradeService commentgradeService;
	
	@ApiOperation(value = "댓글평가추가")
	@RequestMapping(value = "/insertCommentGrade", method = RequestMethod.POST)
	public Object insertCommentGrade(@RequestBody CommentGrade commentgrade)throws Exception{
		BasicResponse result = new BasicResponse();
		String ret = "";
		if(commentgradeService.insertCommentGrade(commentgrade)!=0) {
			result.status=true;
		}else {
			result.status=false;
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글평가수정하기")
	@RequestMapping(value = "/updateFeedGrade", method = RequestMethod.PUT)
	public Object updateCommentGrade(@RequestBody CommentGrade commentgrade)throws Exception{
		String ret ="";
		System.out.println(commentgrade.toString());
		
		if(commentgradeService.updateCommentGrade(commentgrade)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글평가삭제하기")
	@RequestMapping(value = "/deleteCommentGrade", method = RequestMethod.DELETE)
	public Object deleteCommentGrade(@RequestParam int commentgradeid)throws Exception{
		String ret ="";
		
		if(commentgradeService.deleteCommentGrade(commentgradeid)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "내가평가한댓글높은점수부터보기")
	@RequestMapping(value = "/searchHighGradeComment", method = RequestMethod.POST)
	public Object searchHighGradeComment(@RequestParam int userid)throws Exception{
		String ret ="";
		List<FeedComment> commentlist = commentgradeService.searchHighGradeComment(userid);
		
		if(commentlist.size()!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<List<FeedComment>>(commentlist,HttpStatus.OK);
	}
	
}
