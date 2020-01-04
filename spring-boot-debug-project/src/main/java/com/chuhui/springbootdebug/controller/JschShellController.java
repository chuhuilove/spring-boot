package com.chuhui.springbootdebug.controller;

import com.chuhui.springbootdebug.services.jsch.JshellExampleService;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * JschShellController
 *
 * @author: cyzi
 * @Date: 2019/12/31 0031
 * @Description:TODO
 */
@RestController
@RequestMapping("jschShell")
public class JschShellController {


	@PostMapping("executeCommand")
	public String executeCommand(@RequestBody DataCheckModel model) {

		model.setDnsName("dn1");
		model.setNodeDirectoryPath("/home/cyzidn1/QuickMDB");
		model.setNodeIp("127.0.0.1");
		model.setNodeXmlPath("/home/cyzidn1/dsds/mdbCheck.xml");
		model.setNodeUserName("cyzidn1");
		model.setNodeUserPwd("cyzi");
		JshellExampleService jshellExampleService = new JshellExampleService(model);

		System.err.println(jshellExampleService.get());

		return null;
	}


	@Setter
	@Getter
	@ToString
	public static class DataCheckModel {

		private String nodeUserName;
		private String nodeUserPwd;
		private String nodeXmlPath;
		private String nodeDirectoryPath;
		private String nodeIp;
		private String dnsName;
	}

}

