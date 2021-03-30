package com.howieLuk.spring_exec.exec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.howieLuk.spring_exec.exec.pojo.User;
import com.howieLuk.spring_exec.exec.service.BaseService;
import com.howieLuk.spring_exec.exec.service.UserBaseService;
import com.howieLuk.spring_exec.exec.service.UserService;

@Controller
public class UserController {
	
	@Autowired  //通过属性名与idName进行匹配装配
	private UserService userService;  //userService是没有指定idName时的默认idName
	
	@Autowired
	private UserBaseService userBaseService;
	
	
	@RequestMapping(value = "/getUser",
					method = RequestMethod.GET,
					params = {"id"})
	@ResponseBody
	public String getUser(int id) {
		return userBaseService.get(id).toString();
	}
	
	public void run() {
		userService.outUser();
	}
	
	public void save(String username, String email) {
		userService.saveUser(new User(username, email));
	}
	
	public void b_run() {
		long id = 0;
		userBaseService.get(id);
	}
	
	public void b_save(String username, String email) {
		userBaseService.save(new User(username, email));
	}

	public UserBaseService getUserBaseService() {
		return userBaseService;
	}
}
