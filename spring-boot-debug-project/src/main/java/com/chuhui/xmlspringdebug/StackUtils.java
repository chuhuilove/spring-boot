package com.chuhui.xmlspringdebug;

/**
 * StackUtil
 *
 * @author: cyzi
 * @Date: 2019/12/20 0020
 * @Description:TODO
 */
public class StackUtils {

	public static void printStack() {
		StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
		for(StackTraceElement stackTraceElement:stackTrace){
			System.err.println(stackTraceElement.getClassName()+" "+ stackTraceElement.getMethodName()+" " + stackTraceElement.getLineNumber());
		}
	}
}
