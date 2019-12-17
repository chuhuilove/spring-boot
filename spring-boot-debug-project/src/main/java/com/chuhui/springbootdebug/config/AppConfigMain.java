package com.chuhui.springbootdebug.config;

import com.chuhui.springbootdebug.annotation.EnableSpringBootDebug;
import com.chuhui.springbootdebug.custome.CustomClassFirst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * ApplicationMain
 *
 * @author: cyzi
 * @Date: 2019/12/17 0017
 * @Description:TODO
 */
@Configuration
@Order(Ordered.LOWEST_PRECEDENCE-2)
@EnableSpringBootDebug
public class AppConfigMain {

	@Bean
	public CustomClassFirst customClassFirst(){
		return new CustomClassFirst();
	}

}
