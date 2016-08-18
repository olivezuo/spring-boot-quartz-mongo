package com.jin.cron;

public interface MyCron {

	public void reschedule( String cronExpression );
	
	public void pause();
	
	public void resume();

}
