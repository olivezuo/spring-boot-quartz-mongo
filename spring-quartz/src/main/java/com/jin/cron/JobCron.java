package com.jin.cron;

import java.text.ParseException;

import javax.annotation.PostConstruct;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import com.jin.service.JobService;
import com.jin.service.SchedulerService;

@Configuration
public class JobCron {
	
	private static final Logger logger = LoggerFactory.getLogger(JobCron.class);
	
	@Autowired
	SchedulerService schedulerService;

	@PostConstruct
    void init() {		
        schedulerService.register(simpleJobDetailFactory().getObject(), simpleCronTriggerFactoryBean().getObject());
        
    }
	
    public void reschedule( String cronExpression ) {    	
    	try {
    		CronTriggerImpl cronTriggerImpl = (CronTriggerImpl)(simpleCronTriggerFactoryBean().getObject());
			cronTriggerImpl.setCronExpression(cronExpression);
	        schedulerService.reschedule(cronTriggerImpl);
	        
	        logger.info("Reschedule trigger " +  cronTriggerImpl.getKey() + " with new schedule " + cronTriggerImpl.getCronExpression());

		} catch (ParseException e) {
			logger.error("Quartz Scheduler can not reschedule with the expression " + cronExpression + ". the error is " + e.getMessage(), e);
			
		}   	
    }
	
	@Bean
	public JobDetailFactoryBean simpleJobDetailFactory() {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		
		jobDetailFactory.setJobClass(SimpleJob.class);
		jobDetailFactory.setName("SimpleCronJob");
		jobDetailFactory.setGroup("JinJob");
		return jobDetailFactory;
		
	}
	
	@Bean
	public CronTriggerFactoryBean simpleCronTriggerFactoryBean() {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		
		cronTriggerFactoryBean.setJobDetail(simpleJobDetailFactory().getObject());
		cronTriggerFactoryBean.setCronExpression("0 0/1 * * * ?");
		cronTriggerFactoryBean.setName("SimpleCronTrigger");
		cronTriggerFactoryBean.setGroup("JinJob");
		return cronTriggerFactoryBean;
	}
	
	public static class SimpleJob implements Job {
		
		@Autowired
		public JobService jobService;
		
		@Override
		public void execute(JobExecutionContext context) throws JobExecutionException {
			try{
				logger.info("Running the Job " );
				jobService.runJob();
			}catch(Exception e){
				logger.error("Error when running the Job, the error is " + e.getMessage(), e);
			}		
		}
	}

}
