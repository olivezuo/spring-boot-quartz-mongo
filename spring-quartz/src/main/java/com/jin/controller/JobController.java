package com.jin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jin.cron.JobCron;

@RestController
public class JobController {

	@Autowired
	private JobCron jobCron;
	
	@RequestMapping("/jobcron/reschedule")
	public void reschedule() {
		jobCron.reschedule("0 0/3 * * * ?");
	}

}
