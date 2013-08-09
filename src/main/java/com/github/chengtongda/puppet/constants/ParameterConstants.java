package com.github.chengtongda.puppet.constants;

import com.github.chengtongda.puppet.annotation.Parameter;

/**
 * 参数标示（-i -u -xxx ）
 * @author chengtongda
 *
 */
public class ParameterConstants {

	@Parameter(isRequired = true, getClazz = String.class)
	public static final String ip = "i";
	
	@Parameter(isRequired = true, getClazz = String.class)
	public static final String username = "u";
	
	@Parameter(isRequired = true, getClazz = String.class)
	public static final String password = "p";
	
	@Parameter(isRequired = true, getClazz = String.class)
	public static final String tool = "t";
	
	@Parameter(isRequired = false, getClazz = String.class)
	public static final String command = "c";
}
