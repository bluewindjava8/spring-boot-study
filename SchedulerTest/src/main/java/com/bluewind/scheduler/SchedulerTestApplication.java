package com.bluewind.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
/*
 * https://www.baeldung.com/spring-scheduled-tasks
 * https://www.tutorialspoint.com/spring_boot/spring_boot_scheduling.htm
 */
public class SchedulerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerTestApplication.class, args);
	}

}
