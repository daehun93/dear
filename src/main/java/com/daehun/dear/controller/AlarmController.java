package com.daehun.dear.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daehun.dear.service.AlarmService;
import com.daehun.dear.vo.Alarm;
import com.daehun.dear.vo.BasicResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/alarm")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class AlarmController {

	@Autowired
	private AlarmService alarmService;

	@ApiOperation(value = "알람등록")
	@RequestMapping(value = "/insertAlarm", method = RequestMethod.POST)
	public Object insertAlarm(@RequestBody Alarm alarm)throws Exception{
		BasicResponse result = new BasicResponse();
		String ret = "";
		if(alarmService.insertAlarm(alarm)!=0) {
			result.status=true;
		}else {
			result.status=false;
		}
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "알람수정")
	@RequestMapping(value = "/updateAlarm", method = RequestMethod.PUT)
	public Object updateAlarm(@RequestBody Alarm alarm)throws Exception{
		String ret ="";
		System.out.println(alarm.toString());
		
		if(alarmService.updateAlarm(alarm)!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "알람삭제")
	@RequestMapping(value = "/deleteAlarm", method = RequestMethod.DELETE)
	public Object deleteAlarm(@RequestParam int userid)throws Exception{
		String ret ="";
		
		if(alarmService.deleteAlarm(userid)) {
			ret = "true";
		}else {
			ret = "false";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ret", ret);
		
		return new ResponseEntity<String>(mapper.writeValueAsString(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "알람확인")
	@RequestMapping(value = "/searchAlarm", method = RequestMethod.POST)
	public Object searchAlarm(@RequestParam int userid)throws Exception{
		String ret ="";
		Alarm alarm = alarmService.searchAlarm(userid);
		
		if(alarm.getUserid()!=0) {
			ret = "true";
		}else {
			ret = "false";
		}
		return new ResponseEntity<Alarm>(alarm,HttpStatus.OK);
	}


}
