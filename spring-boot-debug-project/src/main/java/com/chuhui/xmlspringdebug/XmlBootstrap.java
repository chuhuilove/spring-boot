package com.chuhui.xmlspringdebug;

import com.chuhui.xmlspringdebug.service.XmlService1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * XmlBootstrap
 *
 * @author: cyzi
 * @Date: 2019/12/20 0020
 * @Description:TODO
 */
public class XmlBootstrap {


	public static void main(String[] args) {

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		XmlService1 service1 = context.getBean(XmlService1.class);

		System.err.println("this is debug ");


		/**
		 * 论循环引用.
		 *
		 * 两种注入方式,实现方法:
		 *
		 * 基于setter的注入方式
		 * 基于构造方法的注入方式
		 *
		 *
		 */



	}

}
