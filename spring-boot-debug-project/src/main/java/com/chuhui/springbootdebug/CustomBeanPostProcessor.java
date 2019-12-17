package com.chuhui.springbootdebug;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * CustomBeanPos
 *
 * @author: cyzi
 * @Date: 2019/12/16 0016
 * @Description:TODO
 */
public class CustomBeanPostProcessor  implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.err.println("invoke CustomBeanPostProcessor#postProcessBeanDefinitionRegistry method ");
		System.err.println("invoke CustomBeanPostProcessor#postProcessBeanDefinitionRegistry method ");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.err.println("invoke CustomBeanPostProcessor#postProcessBeanFactory method");
		System.err.println("invoke CustomBeanPostProcessor#postProcessBeanFactory method");
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE-1;
	}



}
