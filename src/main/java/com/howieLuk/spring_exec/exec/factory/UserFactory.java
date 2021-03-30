package com.howieLuk.spring_exec.exec.factory;

import com.howieLuk.spring_exec.exec.pojo.User;

public class UserFactory {
	User getUser(String username, String email) {
		return new User(username, email);
	}
}
