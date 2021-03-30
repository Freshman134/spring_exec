package com.howieLuk.spring_exec.exec.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.howieLuk.spring_exec.exec.dao.mappers.BaseDao;

public class BaseService<T> {
	
	@Autowired
	private BaseDao<T> baseDao;
	
	public T get(long id) {
		System.out.println(baseDao.get(id));
		return baseDao.get(id);
	}
	
	public void save(T t) {
		baseDao.save(t);
	}
	
	public List<T> getAll() {
		return baseDao.getAll();
	}
	
	public List<T> getByCondition(Map<String, Object> map) {
		return baseDao.getByCondition(map);
	}
	
	public void update(Map<String, Object> map) {
		baseDao.update(map);
	}
	
}
