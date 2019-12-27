package com.chuhui.springbootdebug.controller;

import com.chuhui.resolver.Resolver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ResolveController
 *
 * @author: cyzi
 * @Date: 2019/12/27 0027
 * @Description:TODO
 */
@Component
public class ResolveController implements FactoryBean<Resolver>, ApplicationContextAware,InitializingBean {

	private ApplicationContext applicationContext;

	@Override
	public Resolver getObject() throws Exception {


		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return Resolver.class;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("afterPropertiesSet");
		System.err.println("afterPropertiesSet");
		System.err.println("afterPropertiesSet");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;

	}
}
