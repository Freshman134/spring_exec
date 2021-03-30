package com.howieLuk.spring_exec.exec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howieLuk.spring_exec.exec.dao.CarDao;
import com.howieLuk.spring_exec.exec.pojo.Car;
import com.howieLuk.spring_exec.exec.pojo.User;

@Service
public class CarService {
	
	@Autowired
	private CarDao carDao;
	
	public void outCar() {
		System.out.println(carDao.get(0));
	}
	
	public void saveCar(Car car) {
		carDao.save(car);
	}
}
