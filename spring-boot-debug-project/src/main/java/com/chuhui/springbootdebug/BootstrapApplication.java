package com.chuhui.springbootdebug;

import com.chuhui.springbootdebug.config.AppConfigMain;
import com.chuhui.springbootdebug.config.AppConfigSecond;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BootstrapApplication
 *
 * @author: 纯阳子
 * @date: 2019/12/14
 */
@SpringBootApplication
public class BootstrapApplication {

	public static void main(String[] args) {

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(AppConfigSecond.class, AppConfigMain.class);
//		context.refresh();


		SpringApplication app = new SpringApplication(BootstrapApplication.class);
		app.addInitializers(new CustomApplicationContextInitializer());
		app.run(args);
	}

}
