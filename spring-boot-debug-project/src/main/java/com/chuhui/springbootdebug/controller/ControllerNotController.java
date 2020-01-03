package com.chuhui.springbootdebug.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * ControllerNotController
 *
 * @author: cyzi
 * @Date: 2020/1/3 0003
 * @Description:TODO
 */
@Service
@RequestMapping("controllerNotController")
public class ControllerNotController {

	@GetMapping("invoke")
	public @ResponseBody
	String invokeMethod() {
		return UUID.randomUUID().toString();
	}



}
