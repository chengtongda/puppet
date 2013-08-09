package com.github.chengtongda.puppet.tools.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.github.chengtongda.puppet.ParameterInfo;
import com.github.chengtongda.puppet.ReflectUtils;
import com.github.chengtongda.puppet.annotation.ToolAnno;
import com.github.chengtongda.puppet.tools.Tool;

/**
 * puppetTool常用工具类
 * @author chengtongda
 *
 */
public class ToolUtils {

	private static Map<String, Class<?>> tools = new HashMap<String,Class<?>>();
	
	static{
		for(Class<?> clazz : ReflectUtils.getClasses("com.github.chengtongda.puppet.tools")) {
			if( Tool.class.isAssignableFrom(clazz) && clazz.isAnnotationPresent(ToolAnno.class)) {
				tools.put(clazz.getAnnotation(ToolAnno.class).toolName(), clazz);
			}
		}
		
//		tools.put(SshTool.class.getAnnotation(ToolAnno.class).toolName(), SshTool.class);
	}
	
	public static Tool getCommand(ParameterInfo param){
		Tool tool = null;
		if(StringUtils.isEmpty(param.getTool())){
			return tool;
		}
		
		try {
			tool = (Tool) tools.get(param.getTool()).newInstance();
		} catch (Exception e) {
			// 理论上不会发生
			System.out.println(e.getMessage());
		}
		
		if(tool != null){
			tool.setParameterInfo(param);
		}
		
		return tool;
	}
}
