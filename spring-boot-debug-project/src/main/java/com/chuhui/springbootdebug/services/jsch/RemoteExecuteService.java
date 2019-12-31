package com.chuhui.springbootdebug.services.jsch;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.locks.LockSupport;

/**
 * RemoteExecuteService
 *
 * @author: cyzi
 * @Date: 2019/12/31 0031
 * @Description:TODO
 */
public class RemoteExecuteService {
	final static private Logger logger = LoggerFactory.getLogger(RemoteExecuteService.class);


	private Session session;
	private Channel channel;

	private String sftpHost;


	private int sftpPort = 22;
	private String sftpUserName;
	private String sftpPassword;

	private String executeType;


	public RemoteExecuteService(String hostip, String sftpUserName, String sftpPassword) {
		this.sftpHost = hostip;
		this.sftpUserName = sftpUserName;
		this.sftpPassword = sftpPassword;
		this.executeType = "exec";
	}

	/**
	 * 获取连接
	 *
	 * @return
	 */
	private ChannelExec getChannelExec() {

		try {
			if (channel != null && channel.isConnected()) {
				return (ChannelExec) channel;
			}
			JSch jSch = new JSch();
			if (session == null || !session.isConnected()) {

				session = jSch.getSession(sftpUserName, sftpHost, sftpPort);
				session.setPassword(sftpPassword);
				Properties config = new Properties();
				config.put("StrictHostKeyChecking", "no");
				config.put("PreferredAuthentications", "password");
				session.setConfig(config);
				session.connect();
			}
			channel = session.openChannel(executeType);
		} catch (Exception e) {
			if (session != null) {
				session.disconnect();
				session = null;
			}
			channel = null;
		}
		return channel == null ? null : (ChannelExec) channel;
	}


	/**
	 * 获取连接
	 *
	 * @return
	 */
	private ChannelShell getChannelShell() {

		try {
			if (channel != null && channel.isConnected()) {
				return (ChannelShell) channel;
			}
			JSch jSch = new JSch();
			if (session == null || !session.isConnected()) {

				session = jSch.getSession(sftpUserName, sftpHost, sftpPort);
				session.setPassword(sftpPassword);
				Properties config = new Properties();
				config.put("StrictHostKeyChecking", "no");
				config.put("PreferredAuthentications", "password");
				session.setConfig(config);
				session.connect();
			}
			channel = session.openChannel("shell");
		} catch (Exception e) {
			if (session != null) {
				session.disconnect();
				session = null;
			}
			channel = null;
		}
		return channel == null ? null : (ChannelShell) channel;
	}

	/**
	 * 关闭连接
	 */
	private void closeChannel() {
		try {
			if (channel != null) {
				channel.disconnect();
				channel = null;
			}
			if (session != null) {
				session.disconnect();
				session = null;
			}
		} catch (Exception e) {
			logger.error("close channel error.", e);
		}
	}

	/**
	 * 执行命令
	 */
	public String executeCommand(String command) {
		return executeCommand(command, false);
	}


	/**
	 * 执行命令
	 */
	public String executeCommand(String command, boolean isSperator) {

		StringBuilder sb = new StringBuilder();

		ChannelExec channelExec = getChannelExec();
		if (channelExec == null) {
			return "";
		}
		try {
			channelExec.setCommand(command);
			InputStream in = channelExec.getInputStream();
			channelExec.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));

			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				if (isSperator) {
					sb.append("\n");
				}
			}
			reader.close();
			closeChannel();

		} catch (Exception e) {
		}
		return sb.toString();
	}

	private StringBuffer sb = new StringBuffer();

	public String executeCommandForShell(String command) {


		ChannelShell channelShell = getChannelShell();
		if (Objects.isNull(channelShell)) {
			return "";
		}
		String firstLine = "";
		try {

			channelShell.connect();

			PrintWriter printWriter = new PrintWriter(channelShell.getOutputStream());
			printWriter.println(command);
			printWriter.flush();


			InputStream in = channelShell.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));


			while (true) {
				String line = reader.readLine();

				if (Objects.isNull(line)) {
					// 如果读到null了,则睡眠
					logger.warn("read to null,start sleep");
					LockSupport.park(this);
				} else {
					if (!line.contains("source .bash_profile")) {
						sb.append(line + "\n");
						String s = sb.toString();
						if (s.lastIndexOf("cyzidn1@myhost1[/home/cyzidn1]$") > 0) {
							break;
						}
					} else {
						firstLine = line + "\n";
					}
				}
			}

			reader.close();
			closeChannel();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return firstLine + sb.toString();
	}

	public Channel getChannel() {
		return getChannelShell();
	}

	public StringBuffer getSb() {
		return sb;
	}

}
