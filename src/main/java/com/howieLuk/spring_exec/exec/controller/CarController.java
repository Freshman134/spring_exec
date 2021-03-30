package com.howieLuk.spring_exec.exec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.howieLuk.spring_exec.exec.pojo.Car;
import com.howieLuk.spring_exec.exec.service.CarBaseService;
import com.howieLuk.spring_exec.exec.service.CarService;

//@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarBaseService carBaseService;
	
	public void run() {
		carService.outCar();
	}
	
	public void save() {
		carService.saveCar(new Car());
	}
	
	public void b_run() {
		long id = 0;
		carBaseService.get(id);
	}
	
	public void b_save() {
		carBaseService.save(new Car());
	}
}
