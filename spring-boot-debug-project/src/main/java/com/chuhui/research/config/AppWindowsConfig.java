package com.chuhui.research.config;

import com.chuhui.research.mapping.CustomizeRequestMapping;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.chuhui.OnMissBeanInterface;
import org.springframework.boot.autoconfigure.condition.chuhui.OnMissBeanWindowsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @AUTHOR: cyzi
 * @DATE: 2020/4/22
 * @DESCRIPTION: todo
 */
@Configuration
public class AppWindowsConfig extends WebMvcConfigurationSupport {

	/**
	 * 重写这个方法,才能注入自定义的{@code RequestMappingHandlerMapping}
	 * @return 自定义的{@code RequestMappingHandlerMapping}
	 */
	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new CustomizeRequestMapping();
	}

	@Bean
	@ConditionalOnMissingBean
	public OnMissBeanInterface onMissBeanService(){
		return new OnMissBeanWindowsService();
	}




}
