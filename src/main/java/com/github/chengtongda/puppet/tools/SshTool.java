package com.github.chengtongda.puppet.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import com.github.chengtongda.puppet.ParameterInfo;
import com.github.chengtongda.puppet.annotation.ToolAnno;

/**
 * ssh√¸¡Ó
 * @author chengtongda
 *
 */
@ToolAnno(toolName = "cssh")
public class SshTool extends Tool{

	@Override
	public void execute() {
		ParameterInfo param = getParameterInfo();
		doSshCommand(param.getIp(), param.getUsername(), param.getPassword(), param.getCommand());
	}

	private void doSshCommand(String ip, String username, String password, String command){
		System.out.println(String.format("===============%s===============", ip));
		try {
			Connection conn = new Connection(ip);
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username,password);
			
			if (isAuthenticated == false){
				throw new Exception("password check failed.");
			}
				
			Session sess = conn.openSession();
			sess.execCommand(command + "\n");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new InputStreamReader(new StreamGobbler(sess.getStdout())));
			
			while (true) {
				String line = br.readLine();
				
				if (line == null){
					break;
				}
					
				System.out.println(line);
			}
			
			sess.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
}
