package com.bluewind.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * https://www.tutorialspoint.com/spring_boot/spring_boot_logging.htm
 */
@SpringBootApplication
public class LogTestApplication {
	private static final Logger logger = LoggerFactory.getLogger(LogTestApplication.class);

	public static void main(String[] args) {
		logger.debug("This is debug msg");
		logger.info("This is info msg");
		logger.warn("This is warn msg");
		logger.error("This is error msg");
		SpringApplication.run(LogTestApplication.class, args);
	}

}
