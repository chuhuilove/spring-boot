package com.chuhui.springbootdebug.services;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private DemoCircularServiceB serviceB;


	@PostConstruct
	public void init() {
		System.err.println("DemoCircularServiceA init method");
	}

}
