package com.chuhui.springbootdebug.services;

import com.chuhui.springbootdebug.interfaces.ChuHuiDemoAInterfaces;
import com.chuhui.springbootdebug.interfaces.ChuHuiDemoBInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DemoBService
 * <p>
 * //TODO description
 *
 * @author: 纯阳子
 * @date: 2019/12/14
 */
@Service
public class DemoBService implements ChuHuiDemoBInterfaces {

	@Autowired
	private ChuHuiDemoAInterfaces demoAService;

	public void invokeDemoBService() {
		System.err.println("in DemoBService invoke DemoAService");
		System.err.println("invokeDemoBService ");
		System.err.println("demoBService:"+demoAService.hashCode());
	}
}
