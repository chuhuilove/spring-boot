package com.chuhui.xmlspringdebug.service;


/**
 * XmlService2
 *
 * @author: cyzi
 * @Date: 2019/12/20 0020
 * @Description:TODO
 */
public class XmlService2 {

	private XmlService1 service1;


	public void setXmlService(XmlService1 service1) {

		System.err.println("XmlService2 in setXmlService");



		this.service1 = service1;
	}
}
