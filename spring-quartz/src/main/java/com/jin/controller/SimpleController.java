package com.jin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jin.cron.SimpleCron;

@RestController
public class SimpleController {

	@Autowired
	private SimpleCron simpleCron;
	
	@RequestMapping("/simplecron/reschedule")
	public void reschedule() {
		simpleCron.reschedule("0 0/5 * * * ?");
		
	}
	
	@RequestMapping("/simplecron/pause")
	public void pause() {
		simpleCron.pause();
		
	}

	@RequestMapping("/simplecron/resume")
	public void resume() {
		simpleCron.resume();
		
	}

}
