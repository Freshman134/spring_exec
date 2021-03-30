package com.howieLuk.spring_exec.exec.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howieLuk.spring_exec.exec.dao.mappers.BaseDao;
import com.howieLuk.spring_exec.exec.pojo.Car;
import com.howieLuk.spring_exec.exec.pojo.User;

@Repository
public class CarDao implements BaseDao<Car> {
	
	public void save(Car car) {
		System.out.println("调用 " + this.getClass());
		System.out.println("保存 " + car);
	}

	public Car get(long id) {
		System.out.println("调用 " + this.getClass());
		return null;
	}
	
	/*
	 * Spring会运行Autowired标记的方法，并将参数名与id进行匹配
	 * @Autowired还可以装配参数
	 */
//	@Autowired
//	public void springRun(@Autowired()Car car) {
//		System.out.println("spring运行该方法");
//		System.out.println(car);
//	}
	
	public int methodStart() {
		System.out.println("方法开始，返回0");
		return 0;
	}

	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Car> getByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}
	
}
