package org.springframework.boot.autoconfigure.condition.chuhui;

/**
 * @AUTHOR: cyzi
 * @DATE: 2020/4/22
 * @DESCRIPTION: todo
 */

public class OnMissBeanLinuxService implements OnMissBeanInterface {
	@Override
	public void printBeanMessage() {
		System.err.println("test linux message.............");
	}
}
