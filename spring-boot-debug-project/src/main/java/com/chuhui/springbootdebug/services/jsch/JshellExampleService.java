package com.chuhui.springbootdebug.services.jsch;

import com.chuhui.springbootdebug.controller.JschShellController.DataCheckModel;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelShell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * JshellExampleService
 *
 * @author: cyzi
 * @Date: 2019/12/31 0031
 * @Description:TODO
 */
public class JshellExampleService {

	final static private Logger logger = LoggerFactory.getLogger(JshellExampleService.class);


	private DataCheckModel dataModel;

	public JshellExampleService(DataCheckModel dataModel) {
		this.dataModel = dataModel;
	}


	public String get() {


		final RemoteExecuteService remoteExecuteService = new RemoteExecuteService(dataModel.getNodeIp(), dataModel.getNodeUserName(), dataModel.getNodeUserPwd());


		ExecuteThread executeThread = new ExecuteThread(remoteExecuteService, dataModel);
		MonitoThread monitoThread = new MonitoThread(executeThread, remoteExecuteService);

		executeThread.start();
		monitoThread.start();

		try {
			monitoThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return remoteExecuteService.getSb().toString();
	}


	static class ExecuteThread extends Thread {
		private RemoteExecuteService remoteExecuteService;
		private DataCheckModel dataModel;

		public ExecuteThread(RemoteExecuteService remoteExecuteService, DataCheckModel dataModel) {
			this.remoteExecuteService = remoteExecuteService;
			this.dataModel = dataModel;
		}

		@Override
		public void run() {

			String executeStr = "source .bash_profile; $QuickMDB_HOME/bin/mdbDataCheck -c  "
					+ dataModel.getDnsName() + " -f " + dataModel.getNodeXmlPath() + " -d";
			remoteExecuteService.executeCommandForShell(executeStr);
		}
	}

	static class MonitoThread extends Thread {

		private ExecuteThread executeThread;
		private RemoteExecuteService remoteService;

		public MonitoThread(ExecuteThread executeThread, RemoteExecuteService remoteService) {

			this.executeThread = executeThread;
			this.remoteService = remoteService;

		}

		@Override
		public void run() {

			boolean flag = true;
			while (flag) {
				if (executeThread.getState() == State.TIMED_WAITING) {

					if (remoteService.getSb().indexOf("will you restore the data[Y/N]") > 0) {

						if (remoteService.getSb().indexOf("Will compare again after") > 0) {
							ChannelShell channel = (ChannelShell) remoteService.getChannel();

							try {
								PrintWriter writer = new PrintWriter(channel.getOutputStream());
								writer.println("N");
								writer.flush();

								flag = false;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					// 判断,是否应该退出..
					if (remoteService.getSb().lastIndexOf(remoteService.getSftpUserName() + "@") > 0) {
						break;
					}
				}
				if (executeThread.getState() == State.TERMINATED) {
					flag = false;
				}

				try {
					TimeUnit.MILLISECONDS.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}


			}
		}
	}


}
