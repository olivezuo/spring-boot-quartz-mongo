package com.jin.cron;

public interface MyCron {

	public void register();
	
	public void reschedule( String cronExpression );
	
	public void pause();
	
	public void resume();

}
