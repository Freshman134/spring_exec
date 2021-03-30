package com.howieLuk.spring_exec.exec.dao.mappers;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	
	T get(long id);
	
	List<T> getAll();
	
	void save(T t);
	
	List<T> getByCondition(Map<String, Object> map);
	
	void update(Map<String, Object> map);
	
	void delete(Map<String, Object> map);
}
