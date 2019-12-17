package com.chuhui.springbootdebug;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
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

		RootBeanDefinition def = new RootBeanDefinition(CustomBeanPostProcessor.class);
		def.setSource(null);

		registerPostProcessor((BeanDefinitionRegistry) applicationContext, def, "com.chuhui.springbootdebug.customBeanPostProcessor");
	}

	private static BeanDefinitionHolder registerPostProcessor(
			BeanDefinitionRegistry registry, RootBeanDefinition definition, String beanName) {

		definition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		registry.registerBeanDefinition(beanName, definition);
		return new BeanDefinitionHolder(definition, beanName);
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
