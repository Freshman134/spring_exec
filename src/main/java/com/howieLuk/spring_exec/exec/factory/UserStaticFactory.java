package com.howieLuk.spring_exec.exec.factory;

import com.howieLuk.spring_exec.exec.pojo.User;

public class UserStaticFactory {
	
	public static User getUser(String username, String email) {
		return new User(username, email);
	}
}
