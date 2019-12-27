package com.chuhui.springbootdebug.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * MyTask
 *
 * @author: cyzi
 * @Date: 2019/12/25 0025
 * @Description:TODO
 */
public class MyTask {
	final static private Logger logger = LoggerFactory.getLogger(MyTask.class);

	@Scheduled(initialDelay = 3000,fixedRate = 1000)
	public void work() {
		logger.error("invoke work....");
	}

	@Scheduled(initialDelay = 5000,fixedDelay = 2000)
	public void work2() {
		logger.error("invoke work2....");
	}

}
