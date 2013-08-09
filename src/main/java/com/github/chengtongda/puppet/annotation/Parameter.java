package com.github.chengtongda.puppet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 参数注解
 * @author chengtongda
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Parameter {

	/**
	 * 是否必填
	 * @return
	 */
	public boolean isRequired();
	
	/**
	 * 参数类型
	 * @return
	 */
	public Class<?> getClazz();
	
}
