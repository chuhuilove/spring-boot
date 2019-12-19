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
public class DemoCircularServiceA {

	private DemoCircularServiceB serviceB;

	public DemoCircularServiceA(DemoCircularServiceB serviceB) {
		System.err.println("DemoCircularServiceA Constructor invoke");
		this.serviceB = serviceB;
	}

	@PostConstruct
	public void init() {
		System.err.println("DemoCircularServiceA init method");
	}

}
