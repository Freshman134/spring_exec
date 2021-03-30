package com.howieLuk.spring_exec.exec.pojo;

import java.util.List;
import java.util.Map;

public class Car {
	private String carName;
	private User driver;
	private List<User> passenger;
	private Map<String, Object> maps;
	
	public Car() {}
	public Car(String carName, User driver, List<User> passenger, Map<String, Object> maps) {
		this.carName = carName;
		this.driver = driver;
		this.passenger = passenger;
		this.maps = maps;
	}
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public User getDriver() {
		return driver;
	}
	public void setDriver(User driver) {
		this.driver = driver;
	}
	public List<User> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<User> passenger) {
		this.passenger = passenger;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	
	@Override
	public String toString() {
		return "Car [carName=" + carName + ", driver=" + driver + ", passenger=" + passenger + ", maps=" + maps + "]";
	}
	
}
