package com.github.chengtongda.puppet;

import java.util.HashMap;
import java.util.Map;

import com.github.chengtongda.puppet.constants.ParameterConstants;

/**
 * 一些参数信息
 * @author jiangyi.ctd
 *
 */
public class ParameterInfo {
	
	private Map<String, String> parameters = new HashMap<String, String>();

	public ParameterInfo() {
		super();
	}
	
	public ParameterInfo(String tool, String ip, String username, String password, String command) {
		super();
		setTool(tool);
		setIp(ip);
		setUsername(username);
		setPassword(password);
	}

	public String getIp() {
		return parameters.get(ParameterConstants.ip);
	}

	public void setIp(String ip) {
		parameters.put(ParameterConstants.ip, ip);
	}

	public String getUsername() {
		return parameters.get(ParameterConstants.username);
	}

	public void setUsername(String username) {
		parameters.put(ParameterConstants.username, username);
	}

	public String getPassword() {
		return parameters.get(ParameterConstants.password);
	}

	public void setPassword(String password) {
		parameters.put(ParameterConstants.password, password);
	}

	public void setCommand(String command) {
		parameters.put(ParameterConstants.command, command);
	}
	
	public String getCommand() {
		return parameters.get(ParameterConstants.command);
	}
	
	public String getTool() {
		return parameters.get(ParameterConstants.tool);
	}

	public void setTool(String tool) {
		parameters.put(ParameterConstants.tool, tool);
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	
}
