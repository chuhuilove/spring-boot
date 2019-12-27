package com.chuhui.springbootdebug.config;

import com.chuhui.springbootdebug.BootstrapApplication;
import com.chuhui.springbootdebug.custome.CustomClassFirst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ApplicationMain
 *
 * @author: cyzi
 * @Date: 2019/12/17 0017
 * @Description:TODO
 */
@Configuration
@Order(Ordered.LOWEST_PRECEDENCE - 2)
@ComponentScan(value = "com.chuhui.springbootdebug", excludeFilters = {@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BootstrapApplication.class)})
@EnableScheduling
public class AppConfigMain {

	@Bean
	public CustomClassFirst customClassFirst() {
		return new CustomClassFirst();
	}

	@Bean
	public MyTask myTask() {
		return new MyTask();
	}


}
