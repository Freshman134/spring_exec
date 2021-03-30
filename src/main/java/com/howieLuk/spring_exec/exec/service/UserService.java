package com.howieLuk.spring_exec.exec.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.howieLuk.spring_exec.exec.dao.UserDao;
import com.howieLuk.spring_exec.exec.dao.mappers.BaseDao;
import com.howieLuk.spring_exec.exec.pojo.User;

@Service  //userService是没有指定idName时的默认idName
public class UserService {
	
//	@Resource(name = "userDao")  //通过name = idName装配
//	private UserDao uDao;
	/*或*/
	@Autowired
//	@Qualifier("userDao")
//	private UserDao u_dao;
	private BaseDao<User> u_dao; //该行用于mvc实验
	
	public void outUser() {
		System.out.println(u_dao.get(0));
	}
	
	public void saveUser(User user) {
		u_dao.save(user);
	}
}
