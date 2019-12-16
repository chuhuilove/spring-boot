package com.chuhui.springbootdebug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * BootstrapApplication
 * <p>
 *
 * @author: 纯阳子
 * @date: 2019/12/14
 */
@SpringBootApplication
public class BootstrapApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BootstrapApplication.class);
		app.addInitializers();
		app.run(args);
	}

}
