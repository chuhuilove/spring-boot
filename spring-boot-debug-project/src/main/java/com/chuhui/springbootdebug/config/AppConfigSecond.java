package com.chuhui.springbootdebug.config;

import com.chuhui.springbootdebug.custome.CustomClassSecond;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * AppConfigSecond
 *
 * @author: cyzi
 * @Date: 2019/12/17 0017
 * @Description:TODO
 */
@Configuration
@Order(Ordered.LOWEST_PRECEDENCE - 1)
@ComponentScan({"com.chuhui.springbootdebug","com.chuhui.resolver"})
public class AppConfigSecond implements SchedulingConfigurer, WebMvcConfigurer {

	@Bean
	public CustomClassSecond customClassSecond() {
		return new CustomClassSecond();
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		System.err.println("有人调用这个接口configureTasks");
		System.err.println("有人调用这个接口configureTasks");

	}


}
