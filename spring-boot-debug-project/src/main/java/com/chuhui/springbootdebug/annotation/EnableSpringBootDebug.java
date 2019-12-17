package com.chuhui.springbootdebug.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableChuHuiSpringBootDebug
 *
 * @author: cyzi
 * @Date: 2019/12/17 0017
 * @Description:TODO
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SpringBootDebug.class)
public @interface EnableSpringBootDebug {
}
