package com.chuhui.research.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.chuhui.OnMissBeanInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @AUTHOR: cyzi
 * @DATE: 2020/4/22
 * @DESCRIPTION: todo
 */
@Service
public class TestService implements InitializingBean {

	@Autowired
	private RequestMappingHandlerMapping mapping;

	@Autowired
	private OnMissBeanInterface onMissBeanService;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("this is ........");
		System.err.println("this is ........");
		System.err.println("this is ........");

		onMissBeanService.printBeanMessage();

	}
}
