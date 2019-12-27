package com.chuhui.springbootdebug.config;

import org.springframework.context.support.DefaultLifecycleProcessor;

/**
 * CustomLifecycleProcessor
 *
 * @author: cyzi
 * @Date: 2019/12/25 0025
 * @Description:TODO
 */

public class CustomLifecycleProcessor extends DefaultLifecycleProcessor {


	@Override
	public void onRefresh() {
		super.onRefresh();
	}
}
