package com.chuhui.springbootdebug.custome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * CustomBeanPostProcessor
 *
 * @author: cyzi
 * @Date: 2019/12/19 0019
 * @Description:TODO
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
	final static private Logger logger = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.err.println(beanName+" 初始化之前");

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		System.err.println(beanName+" 初始化之后");
		return bean;
	}
}
