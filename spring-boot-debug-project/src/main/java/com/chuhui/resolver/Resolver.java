package com.chuhui.resolver;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Arrays;

/**
 * Resolver
 *
 * @author: cyzi
 * @Date: 2019/12/27 0027
 * @Description:TODO
 */
@Component
public class Resolver implements SmartLifecycle, BeanFactoryAware {

	@Nullable
	private volatile ConfigurableListableBeanFactory beanFactory;

	private volatile  boolean running=false;

	@Override
	public void start() {

		if(!isRunning()){
			String[] beanNamesForType = beanFactory.getBeanNamesForType(HandlerMapping.class);


			System.err.println(Arrays.toString(beanNamesForType));
			running=true;

			//[faviconHandlerMapping,
			// requestMappingHandlerMapping,
			// welcomePageHandlerMapping,
			// viewControllerHandlerMapping,
			// beanNameHandlerMapping,
			// resourceHandlerMapping,
			// defaultServletHandlerMapping]

		}
	}

	@Override
	public void stop() {

	}

	@Override
	public boolean isRunning() {
		return running;
	}


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.err.println("bean Factory Aware invoke ...");
		this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
	}
}
