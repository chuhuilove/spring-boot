package com.chuhui.research.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @AUTHOR: cyzi
 * @DATE: 2020/4/22
 * @DESCRIPTION: todo
 */
@RestController
public class TestController {

	@GetMapping("test")
	public String getMessage(){
		return UUID.randomUUID().toString();
	}

}
