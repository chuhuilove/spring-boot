package com.chuhui.springbootdebug.services;

import com.chuhui.springbootdebug.interfaces.ChuHuiDemoAInterfaces;
import com.chuhui.springbootdebug.interfaces.ChuHuiDemoBInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DemoAService
 * <p>
 * //TODO description
 *
 * @author: 纯阳子
 * @date: 2019/12/14
 */
@Service
public class DemoAService implements ChuHuiDemoAInterfaces {

	@Autowired
	private ChuHuiDemoBInterfaces demoBService;

	@Override
	public void invokeDemoAService() {
		System.err.println("in invokeDemoAService invoke DemoBService");
		System.err.println("invokeDemoAService ");
		System.err.println("demoBService:" + demoBService.hashCode());
	}
}
