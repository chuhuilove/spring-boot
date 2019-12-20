package com.chuhui.xmlspringdebug.service;

import com.chuhui.xmlspringdebug.StackUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * XmlServiceAnnotation
 *
 * @author: cyzi
 * @Date: 2019/12/20 0020
 * @Description:TODO
 */
@Service
public class XmlServiceAnnotation {

//	@Autowired
	private XmlService1 service1;
//	@Autowired
	private XmlService2 service2;


	public XmlServiceAnnotation(XmlService1 service1,XmlService2 service2){
		StackUtils.printStack();

		this.service1=service1;
		this.service2=service2;
	}
	@PostConstruct
	public void init() {
		System.err.println(" XmlServiceAnnotation inited,"+service1.hashCode()+" "+service2.hashCode());

	}

}
