package com.chuhui.springbootdebug.services;

import com.chuhui.springbootdebug.interfaces.TestAutoInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @AUTHOR: cyzi
 * @DATE: 2020/4/10
 * @DESCRIPTION: todo
 */
@Service
public class TestAutoService {

	@Autowired(required = false)
	private TestAutoInterfaces autoInterfaces;

	public void message(){
		autoInterfaces.message();
	}

}
