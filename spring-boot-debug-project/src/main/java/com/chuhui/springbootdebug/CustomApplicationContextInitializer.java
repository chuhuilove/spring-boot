package com.chuhui.springbootdebug;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Application
 *
 * @author: cyzi
 * @Date: 2019/12/16 0016
 * @Description:TODO
 */
public class CustomApplicationContextInitializer implements ApplicationContextInitializer {
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		applicationContext.addBeanFactoryPostProcessor(new CustomBeanPostProcessor());
	}


//	@Override
//	public int getOrder() {
//		return Ordered.LOWEST_PRECEDENCE;
//	}
//
//	@Override
//	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//		System.err.println("invoke postProcessBeanDefinitionRegistry");
//		System.err.println("invoke postProcessBeanDefinitionRegistry");
//	}
//
//	@Override
//	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		System.err.println("invoke postProcessBeanFactory");
//		System.err.println("invoke postProcessBeanFactory");
//	}
//
//	@Override
//	public void initialize(ConfigurableApplicationContext applicationContext) {
//		applicationContext.addBeanFactoryPostProcessor(new ApplicationRegistryPostProcessor());
//	}
//


}
