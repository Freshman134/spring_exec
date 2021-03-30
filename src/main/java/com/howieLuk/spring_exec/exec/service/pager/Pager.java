package com.howieLuk.spring_exec.exec.service.pager;

import java.util.List;
import java.util.Map;

/**
 * 分页实体类
 * @author HowieLuk
 *
 * @param <T>记录实体
 */
public class Pager<T> {
	/**
	 * 当前页面
	 */
	private int page;
	/**
	 * 记录总数
	 */
	private int count;
	/**
	 * 页面大小
	 */
	private int size; 
	/**
	 * 记录
	 */
	private List<T> rows;
	
	public Pager(Map<String, Object> map) {
		for(String key: map.keySet()) {
			if (key.equals("page")) page = (Integer) map.get(key);
			if (key.equals("count")) count = (Integer) map.get(key);
			if (key.equals("size")) size = (Integer) map.get(key);
			if (key.equals("rows")) rows = (List<T>) map.get(key);
		}
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public List<T> getRows() {
		return rows;
	}
	
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
