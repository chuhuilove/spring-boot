package com.chuhui.research.mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.text.MessageFormat;

/**
 * 研究在spring boot中,
 * 自定义RequestMapping,是如何取代{@link WebMvcAutoConfiguration.EnableWebMvcConfiguration#requestMappingHandlerMapping() RequestMapping}的.
 *
 * @AUTHOR: cyzi
 * @DATE: 2020/4/22
 * @DESCRIPTION: todo
 */
@Slf4j
public class CustomizeRequestMapping extends RequestMappingHandlerMapping {

	@Override
	protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
		String format = MessageFormat.format("chuhui-register requestMapping,method:{0},handlerType:{1}", method.getName(), handlerType.getName());

		logger.error(format);

		return super.getMappingForMethod(method,handlerType);
	}


}
