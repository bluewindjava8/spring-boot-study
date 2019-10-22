package com.bluewind.scheduler.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class Scheduler {
	
	/*
	 * By default,  Cron express scheduled jobs don't run in parallel.  
	 * Cron express type scheduling may lose some execution if the cron job execution is longer than scheduling interval.
	 * In the example below,  the job is supposed to execute every minute starting at 11:00 AM and ending at 11:59 AM, every day.
	 * Because one job spends about 80 seconds, long than one minutes, the second job will not start until the next 0 second after the first job finished.
	 * Below are the logs:
	 * 
	 *  Java cron job expression:: 2019-10-22 11:15:00.006
		---------------end
		Java cron job expression:: 2019-10-22 11:17:00.004
		---------------end
		Java cron job expression:: 2019-10-22 11:19:00.003
		---------------end
		Java cron job expression:: 2019-10-22 11:21:00.002
		---------------end
		Java cron job expression:: 2019-10-22 11:23:00.002
		
	 * 	If we want to support parallel behavior in scheduled tasks, we need to add the @EnableAsync and @Async annotation.
	 */
//	@Scheduled(cron = "0 * 11 * * ?")
//	public void cronJobSch() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		Date now = new Date();
//		String strDate = sdf.format(now);
//		System.out.println("Java cron job expression:: " + strDate);
//
//		try {
//			Thread.sleep(80000);//Simulate a long job
//		} catch (InterruptedException ex) {
//			System.out.println("xxxxxxxxxxxxxx interrupted");
//		}
//		System.out.println("---------------end");
//	}
	
	/* After adding @EnableAsync and @Async annotation, the jobs are executed in parallel.
	 * Logs are below:
	 * 
	 *  Java cron job expression:: 2019-10-22 11:44:00.025
		Java cron job expression:: 2019-10-22 11:45:00.005
		---------------end
		Java cron job expression:: 2019-10-22 11:46:00.006
		---------------end
		Java cron job expression:: 2019-10-22 11:47:00.006
		---------------end
		Java cron job expression:: 2019-10-22 11:48:00.006
		---------------end
		Java cron job expression:: 2019-10-22 11:49:00.004
		---------------end
		Java cron job expression:: 2019-10-22 11:50:00.004
		---------------end
	 */
	
//	@Scheduled(cron = "0 * 11 * * ?")
//	@Async
//	public void cronJobSchAsync() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		Date now = new Date();
//		String strDate = sdf.format(now);
//		System.out.println("Java cron job expression:: " + strDate);
//
//		try {
//			Thread.sleep(80000);//Simulate a long job
//		} catch (InterruptedException ex) {
//			System.out.println("xxxxxxxxxxxxxx interrupted");
//		}
//		System.out.println("---------------end");
//	}
	
	/*
	 * Note that scheduled tasks don't run in parallel by default. 
	 * So even if we used fixedRate, the next task won't be invoked until the previous one is done.
	 * If we want to support parallel behavior in scheduled tasks, we need to add the @EnableAsync and @Async annotation.
	 */
//	@Scheduled(fixedRate = 1000)
//	public void fixedRateSch() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//
//		Date now = new Date();
//		String strDate = sdf.format(now);
//		System.out.println("Fixed Rate scheduler start :: " + strDate);
//		try {
//			Thread.sleep(5000);// Simulate a long job
//		} catch (InterruptedException ex) {
//			System.out.println("xxxxxxxxxxxxxx interrupted");
//		}
//		now = new Date();
//		strDate = sdf.format(now);
//		System.out.println("---------------Fixed Rate scheduler end :: " + strDate);
//	}
	
	/*
	 * Note that scheduled tasks don't run in parallel by default. 
	 * So even if we used fixedRate, the next task won't be invoked until the previous one is done.
	 * If we want to support parallel behavior in scheduled tasks, we need to add the @EnableAsync and @Async annotation.
	 */
//	@Scheduled(fixedRate = 1000)
//	@Async
//	public void fixedRateSchAsync() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//
//		Date now = new Date();
//		String strDate = sdf.format(now);
//		System.out.println("xxxxxxxxxxxxxxxxxAsync Fixed Rate scheduler start :: " + strDate);
//		try {
//			Thread.sleep(5000);// Simulate a long job
//		} catch (InterruptedException ex) {
//			System.out.println("xxxxxxxxxxxxxx interrupted");
//		}
//		now = new Date();
//		strDate = sdf.format(now);
//		System.out.println("---------------Async Fixed Rate scheduler end :: " + strDate);
//	}	

	
	/*
	 *  ===============Fixed Delay scheduler start :: 2019-10-22 11:56:15.700
		---------------Fixed Delay scheduler end   :: 2019-10-22 11:56:21.701
		===============Fixed Delay scheduler start :: 2019-10-22 11:56:25.703
		---------------Fixed Delay scheduler end   :: 2019-10-22 11:56:31.704
		===============Fixed Delay scheduler start :: 2019-10-22 11:56:35.705
		---------------Fixed Delay scheduler end   :: 2019-10-22 11:56:41.706
		===============Fixed Delay scheduler start :: 2019-10-22 11:56:45.707
		---------------Fixed Delay scheduler end   :: 2019-10-22 11:56:51.708
	 */
	@Scheduled(fixedDelay = 4000, initialDelay = 2000)
	public void fixedDelaySch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("===============Fixed Delay scheduler start :: " + strDate);

		try {
			Thread.sleep(6000);// Simulate a long job
		} catch (InterruptedException ex) {
			System.out.println("xxxxxxxxxxxxxx interrupted");
		}
		now = new Date();
		strDate = sdf.format(now);
		System.out.println("---------------Fixed Delay scheduler end   :: " + strDate);
	}
}
