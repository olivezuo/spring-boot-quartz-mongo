package com.jin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jin.cron.AnotherCron;

@RestController
public class AnotherController {
	@Autowired
	private AnotherCron anotherCron;
	
	@RequestMapping("/anothercron/reschedule")
	public void reschedule() {
		anotherCron.reschedule("0 0/10 * * * ?");
		
	}
	
	@RequestMapping("/anothercron/pause")
	public void pause() {
		anotherCron.pause();
		
	}

	@RequestMapping("/anothercron/resume")
	public void resume() {
		anotherCron.resume();
		
	}

}
