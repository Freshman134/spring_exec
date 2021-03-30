package com.howieLuk.spring_exec.exec.converters;

import org.springframework.core.convert.converter.Converter;

import com.howieLuk.spring_exec.exec.pojo.Student;

/*
 * 将这个组件添加到ConversionServiceFactoryBean
 * 
 * <bean id="conversionServiceFactoryBean" class="org.springframework.context.support.ConversionServiceFactoryBean">
		<property name="converters">
			<set>
				<bean class="com.howieLuk.spring_exec.exec.converters.MyConverter"/>
			</set>
		</property>
	</bean>
	<mvc:annotation-driven conversion-service="conversionServiceFactoryBean" />
 */
public class MyConverter implements Converter<String, Student> {

	public Student convert(String source) {
		
		return null;
	}

}
