package com.bluewind.log.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepository {
	private static final Logger logger = LoggerFactory.getLogger(LogRepository.class);
	
	public void test() {
		logger.debug("This is debug msg in LogRepository");
		logger.info("This is info msg in LogRepository");
		logger.warn("This is warn msg in LogRepository");
		logger.error("This is error msg in LogRepository");
	}
}
