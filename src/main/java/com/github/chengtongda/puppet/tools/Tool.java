package com.github.chengtongda.puppet.tools;

import com.github.chengtongda.puppet.ParameterInfo;

/**
 * »ù´¡¹¤¾ß
 * @author chengtongda
 *
 */
public abstract class Tool {

	private ParameterInfo parameterInfo;
	
	public ParameterInfo getParameterInfo() {
		return parameterInfo;
	}

	public void setParameterInfo(ParameterInfo parameterInfo) {
		this.parameterInfo = parameterInfo;
	}

	abstract public void execute();
	
}
