package com.howieLuk.spring_exec.exec.factory;

import org.springframework.beans.factory.FactoryBean;

import com.howieLuk.spring_exec.exec.pojo.Car;

public class CarFactoryBean implements FactoryBean<Car> {

	public Car getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Car();
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Car.class;
	}
	
}
