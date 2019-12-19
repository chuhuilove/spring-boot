package com.chuhui.springbootdebug.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * DemoCircularServiceA
 *
 * @author: cyzi
 * @Date: 2019/12/19 0019
 * @Description:TODO
 */
@Service
public class DemoCircularServiceB {

	private DemoCircularServiceA serviceA;

	public DemoCircularServiceB(DemoCircularServiceA serviceA) {
		System.err.println("DemoCircularServiceB Constructor invoke");
		this.serviceA = serviceA;
	}


	@PostConstruct
	public void init() {
		System.err.println("DemoCircularServiceB init method");
	}

}
