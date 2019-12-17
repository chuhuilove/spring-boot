package com.chuhui.springbootdebug.annotation;

import com.chuhui.springbootdebug.custome.ReturnFloat;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ThreadLocalRandom;

/**
 * SpringBootDebug
 *
 * @author: cyzi
 * @Date: 2019/12/17 0017
 * @Description:TODO
 */
public class SpringBootDebug {

	@Bean
	public ReturnFloat returnFloat(){
		System.err.println("init return float");
		return new ReturnFloat(ThreadLocalRandom.current().nextFloat());
	}
}
