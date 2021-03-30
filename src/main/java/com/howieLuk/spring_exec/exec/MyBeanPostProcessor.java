package com.howieLuk.spring_exec.exec;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	
	/**
	 * 初始化前调用
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + " 初始化前...");
		return bean;
	}
	
	/**
	 * 初始化后调用
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + " 初始化后...");
		return bean;
	}
	
}
