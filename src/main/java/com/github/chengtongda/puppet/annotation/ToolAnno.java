package com.github.chengtongda.puppet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 工具注解
 * @author chengtongda
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ToolAnno {

	/**
	 * 工具名称
	 * @return
	 */
	public String toolName();
	
}
