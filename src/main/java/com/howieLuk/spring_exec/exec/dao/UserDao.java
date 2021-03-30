package com.howieLuk.spring_exec.exec.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.howieLuk.spring_exec.exec.dao.mappers.BaseDao;
import com.howieLuk.spring_exec.exec.dao.mappers.UserMapper;
import com.howieLuk.spring_exec.exec.pojo.User;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

//@Repository("userDao")
//@Scope(value = "singleton")  //修改单多实例
public class UserDao implements BaseDao<User> {
	
	@Autowired
	private UserMapper userMapper;
	
	public User get(long id) {
		System.out.println("调用 " + this.getClass());
		return userMapper.get(id);
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.println("调用 " + this.getClass());
		userMapper.save(user);
		System.out.println("保存 " + user);
	}
	
	public int methodStart() {
		System.out.println("方法开始，返回0");
		return 0;
	}
	
	public void throwError() throws Exception {
		throw new Exception("手动抛出异常");
	}
	
	/*
	 * mybatis练习
	 */
	public void mybatis_exec() {
		System.out.println(userMapper.getUsersById(Arrays.asList(1L, 2L, 3L, 4L)));
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getByCondition(Map<String, Object> map) {
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
