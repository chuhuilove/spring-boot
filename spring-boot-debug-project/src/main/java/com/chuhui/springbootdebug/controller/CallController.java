package com.chuhui.springbootdebug.controller;

import com.chuhui.springbootdebug.interfaces.ChuHuiDemoAInterfaces;
import com.chuhui.springbootdebug.interfaces.ChuHuiDemoBInterfaces;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.PostConstruct;

/**
 * CallController
 * <p>
 * //TODO description
 *
 * @author: 纯阳子
 * @date: 2019/12/14
 */
@RestController("callControllerCyzi")
@RequestMapping("call")
public class CallController implements InitializingBean {

	@Autowired
	private ChuHuiDemoBInterfaces demoBService;

	@Autowired
	private ChuHuiDemoAInterfaces demoAService;


	@PostConstruct
	void callControllerInitMethod_PostConstruct() {
		/**
		 * 调用链
		 * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#initializeBean 1800
		 * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization 417
		 * org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor#postProcessBeforeInitialization 136
		 * org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata#invokeInitMethods 307
		 * org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleElement#invoke 363
		 * java.lang.reflect.Method#invoke 566
		 * ...
		 * com.chuhui.springbootdebug.controller.CallController#callControllerInitMethod
		 *
		 */
		System.err.println("in callControllerInitMethod demoBService hash code:" + demoBService.hashCode());
		System.err.println("in callControllerInitMethod demoAService hash code:" + demoAService.hashCode());
	}


	@GetMapping("callDemoAService")
	public void callDemoAService() {
		demoAService.invokeDemoAService();
	}

	@GetMapping("callDemoBService")
	public void callDemoBService() {
		demoBService.invokeDemoBService();
	}

	@GetMapping("params/{uuid}")
	public void callDemoBService1(@PathVariable String uuid) {
		try{
			throw new  RuntimeException("自定义抛出异常");
		}catch (RuntimeException e){
			e.printStackTrace();
		}
		System.err.println(uuid);
	}


	@Override
	public void afterPropertiesSet() throws Exception {

		/**
		 * 调用链:
		 * 1. org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#initializeBean 1804
		 * 2. org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#invokeInitMethods 1867
		 * 3. com.chuhui.springbootdebug.controller.CallController#afterPropertiesSet
		 *
		 */

		System.err.println("in afterPropertiesSet demoBService hash code:" + demoBService.hashCode());
		System.err.println("in afterPropertiesSet hash code:" + demoAService.hashCode());

	}
}
