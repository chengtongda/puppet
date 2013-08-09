package com.github.chengtongda.puppet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����ע��
 * @author chengtongda
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Parameter {

	/**
	 * �Ƿ����
	 * @return
	 */
	public boolean isRequired();
	
	/**
	 * ��������
	 * @return
	 */
	public Class<?> getClazz();
	
}
