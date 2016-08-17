package com.jin.service;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;

public interface SchedulerService {

	void register(JobDetail jobDetail, CronTrigger cronTrigger);

	void reschedule(CronTrigger cronTrigger);


}
