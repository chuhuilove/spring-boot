package com.chuhui.springbootdebug.controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * NotRequestMapping
 *
 * @author: cyzi
 * @Date: 2020/1/3 0003
 * @Description:TODO
 */
@Repository
@RequestMapping
public class NotRequestMapping {


	@RequestMapping(value = "noRequestMapping/{uuid}",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
	public @ResponseBody String noRequestMapping(@PathVariable String uuid){
		System.err.println(uuid);
		return UUID.randomUUID().toString();
	}

}
