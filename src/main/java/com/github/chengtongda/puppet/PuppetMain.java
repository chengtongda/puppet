package com.github.chengtongda.puppet;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import com.github.chengtongda.puppet.annotation.Parameter;
import com.github.chengtongda.puppet.constants.ParameterConstants;
import com.github.chengtongda.puppet.tools.Tool;
import com.github.chengtongda.puppet.tools.utils.ToolUtils;

public class PuppetMain {
	
	public PuppetMain(String[] args) throws IllegalArgumentException, IllegalAccessException {
		super();
		
		ParameterInfo param = parseArgs(args);
		
		Tool command = ToolUtils.getCommand(param);
		
		if(command == null){
			System.out.println("Tools Not Found!");
			return;
		}
		
		command.execute();
	}

	private ParameterInfo parseArgs(String[] args) throws IllegalArgumentException, IllegalAccessException{
		final OptionParser parser = new OptionParser();
		ParameterInfo parameter = new ParameterInfo();
		Set<String> parameterKeySet = new HashSet<String>();
		for(Field field: ParameterConstants.class.getDeclaredFields()){
			Parameter p = field.getAnnotation(Parameter.class);
			field.setAccessible(true);
			String parameterKey = String.valueOf(field.get(null));
			field.setAccessible(false);
			if(p.isRequired()){
				parser.accepts(parameterKey).withRequiredArg().ofType(p.getClazz()).required();
			}else{
				parser.accepts(parameterKey).withOptionalArg().ofType(p.getClazz());
			}
			parameterKeySet.add(parameterKey);
		}
		
		final OptionSet os = parser.parse(args);
		for(String parameterKey: parameterKeySet){
			parameter.getParameters().put(parameterKey, String.valueOf(os.valueOf(parameterKey)));
		}
		
		return parameter;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		new PuppetMain(args);
	}
}
