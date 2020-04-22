package com.chuhui.research.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.chuhui.OnMissBeanInterface;
import org.springframework.boot.autoconfigure.condition.chuhui.OnMissBeanLinuxService;
import org.springframework.boot.autoconfigure.condition.chuhui.OnMissBeanWindowsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @AUTHOR: cyzi
 * @DATE: 2020/4/22
 * @DESCRIPTION: todo
 */
@Configuration
public class AppLinuxConfig {

	@Bean
	public OnMissBeanInterface onMissBeanService(){
		return new OnMissBeanLinuxService();
	}

}
