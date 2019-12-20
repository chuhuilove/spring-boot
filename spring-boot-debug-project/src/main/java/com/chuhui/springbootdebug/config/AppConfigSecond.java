package com.chuhui.springbootdebug.config;

import com.chuhui.springbootdebug.custome.CustomClassSecond;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * AppConfigSecond
 *
 * @author: cyzi
 * @Date: 2019/12/17 0017
 * @Description:TODO
 */
@Configuration
@Order(Ordered.LOWEST_PRECEDENCE-1)
@ComponentScan("com.chuhui.springbootdebug")
public class AppConfigSecond {

	@Bean
	public CustomClassSecond customClassSecond() {
		return new CustomClassSecond();
	}

}
