package com.chuhui.springbootdebug;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * CustomChuhuiBeanPostFactoryProcessor
 *
 * @author: cyzi
 * @Date: 2019/12/19 0019
 * @Description:TODO
 */
@Component
public class CustomChuhuiBeanPostFactoryProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

		for(String beanName:beanDefinitionNames){
//			System.err.println(beanName+"<=====>"+beanFactory.getBeanDefinition(beanName).getSource());
		}

	}
}
