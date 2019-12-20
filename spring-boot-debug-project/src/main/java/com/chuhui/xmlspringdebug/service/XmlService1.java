package com.chuhui.xmlspringdebug.service;


/**
 * XmlService1
 *
 * @author: cyzi
 * @Date: 2019/12/20 0020
 * @Description:TODO
 */
public class XmlService1 {

	private XmlService2 service2;



	// spring 注入的方式有两种,
	// 基于setter的注入
	// 基于构造方法的注入

	public void setService(XmlService2 service2) {

		System.err.println("XmlService1 in setService");



		this.service2 = service2;
	}
}
