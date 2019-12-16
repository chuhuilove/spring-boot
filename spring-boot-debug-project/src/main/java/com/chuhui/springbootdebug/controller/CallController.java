package com.chuhui.springbootdebug.controller;

import com.chuhui.springbootdebug.interfaces.ChuHuiDemoAInterfaces;
import com.chuhui.springbootdebug.interfaces.ChuHuiDemoBInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;

/**
 * CallController
 * <p>
 * //TODO description
 *
 * @author: 纯阳子
 * @date: 2019/12/14
 */
@RestController
@RequestMapping("call")
public class CallController {

	@Autowired
	private ChuHuiDemoBInterfaces demoBService;

	@Autowired
	private ChuHuiDemoAInterfaces demoAService;


	@GetMapping("callDemoAService")
	public void callDemoAService(){
		demoAService.invokeDemoAService();
	}

	@GetMapping("callDemoBService")
	public void callDemoBService(){
		demoBService.invokeDemoBService();
	}

}
